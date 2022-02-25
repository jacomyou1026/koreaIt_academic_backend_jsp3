package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutAction
 */
@WebServlet("/logout.do")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//위의 vo라는 이름으로 저장된 데이터를 세션에서 제거하면 로그아웃
		HttpSession session = request.getSession();
		session.removeAttribute("vo");//세션에서 vo라는 키값 제거
		
		//로그아웃을 했으므로 로그인 페이지 전환
		response.sendRedirect("login_form.jsp");
		
	}

}
