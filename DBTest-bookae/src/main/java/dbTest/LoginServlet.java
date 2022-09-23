package dbTest;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		MemberVO vo=new MemberVO();
		vo.setId(user_id);
		vo.setPwd(user_pw);
		MemberDAO dao=new MemberDAO();
		boolean result=dao.isExisted(vo);
		out.print("<html><body>");
		if(result) {
			String name=dao.whatName(vo);
			HttpSession session=request.getSession();
			session.setAttribute("isLogin", true);
			session.setAttribute("log_id", user_id);
			out.print(name+"�� ȯ���մϴ�.<br>");
			out.print("<a href='login.html'>�α׾ƿ�</a>");
		}else {
			out.print("<p>ȸ�� ������ Ʋ���ϴ�.</p>");
			out.print("<a href='login.html'>�ٽ� �α����ϱ�</a>");
		}
		out.print("</body></html>");
	}
}
