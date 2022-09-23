package dbTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context)ctx.lookup("java:/comp/env");
			dataFactory=(DataSource)envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			System.out.println("오라클 연결 안됨");
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list=new ArrayList<MemberVO>();
		try {
			con=dataFactory.getConnection();
			String query="select * from bamembertbl";
			pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				String id=rs.getString("id");
				String pwd=rs.getString("pwd");
				String nickname=rs.getString("nickname");
				int tel=rs.getInt("tel");
				String email=rs.getString("email");
				MemberVO vo=new MemberVO();
				vo.setName(name);
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setNickname(nickname);
				vo.setTel(tel);
				vo.setEmail(email);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			System.out.println("오라클 연결 끊김");
		}
		return list;
	}
	
	
	public void addMember(MemberVO memVO) {
		try {
			con=dataFactory.getConnection();
			String name=memVO.getName();
			String id=memVO.getId();
			String pwd=memVO.getPwd();
			String nickname=memVO.getNickname();
			int tel=memVO.getTel();
			String email=memVO.getEmail();
			System.out.println(email);
			String query="insert into bamembertbl(name, id, pwd, nickname, tel, email) values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pwd);
			pstmt.setString(4, nickname);
			pstmt.setInt(5, tel);
			pstmt.setString(6, email);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			System.out.println("등록중 오류발생");
		}
	}
	
	
	//회원가입확인
	public boolean isExisted(MemberVO vo) {
		boolean result=false;
		String id=vo.getId();
		String pwd=vo.getPwd();
		try {
			con=dataFactory.getConnection();
			String query="select decode(count(*), 1, 'true','false') as "
					+ "result from bamembertbl where id=? and pwd=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			result=Boolean.parseBoolean(rs.getString("result"));
		}catch(Exception e) {
			System.out.println("회원가입확인 오류");
		}
		return result;
	}
	
	//회원이름 가져오기
	public String whatName(MemberVO vo) {
		String id=vo.getId();
		String name=null;
		try {
			con=dataFactory.getConnection();
			String query="select name from bamembertbl where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			rs.next();
			name=rs.getString("name");
		}catch(Exception e) {
			System.out.println("이름 갖고오기 오류");
		}
		return name;
	}
}
