package dbTest;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class MemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao=new MemberDAO();
		PrintWriter out=response.getWriter();
		String command=request.getParameter("command");
		if(command !=null && command.equals("addMember")) {
			String name=request.getParameter("name");
			String id=request.getParameter("id");
			String pwd=request.getParameter("pwd");
			String nickname=request.getParameter("nickname");
			int tel=Integer.parseInt(request.getParameter("tel"));
			String email=request.getParameter("email");
			String emailAfter=request.getParameter("emailAfter");
			String emailAdd=null;
			MemberVO memberVO=new MemberVO();
			memberVO.setName(name);
			memberVO.setId(id);
			memberVO.setPwd(pwd);
			memberVO.setNickname(nickname);
			memberVO.setTel(tel);
			if(emailAfter.equals("1")) {
				emailAdd=request.getParameter("emailAdd");
				memberVO.setEmail(email+"@"+emailAdd);
			}else {
				memberVO.setEmail(email+"@"+emailAfter);
			}
			dao.addMember(memberVO);
		}
		List list=dao.listMembers();
		out.print("<html><body>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='#FF9999'>");
		out.print("<th>이름</th><th>아이디</th><th>비밀번호</th><th>닉네임</th>"
				+ "<th>전화번호</th><th>이메일</th>");
		out.print("</tr>");
		for(int i=0; i<list.size(); i++) {
			MemberVO vo=(MemberVO)list.get(i);
			String name=vo.getName();
			String id=vo.getId();
			String pwd=vo.getPwd();
			String nickname=vo.getNickname();
			int tel=vo.getTel();
			String email=vo.getEmail();
			out.print("<tr><td>"+name+"</td><td>"+id+"</td><td>"+pwd+"</td>"
					+ "<td>"+nickname+"</td><td>"+tel+"</td><td>"+email+"</td></tr>");
		}
		out.print("</table>");
		out.print("<a href='index.html'>메인 페이지로 돌아가기</a>	");
		out.print("<a href='login.html'>로그인하러 가기</a>		");
		out.print("<a href='join.html'>회원가입 페이지로 돌아가기</a>");
		out.print("</body></html>");
	}

}
