package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/login.do")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login.do?id=one&pwd=1111
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		
		String result = "";
		if( vo == null ) {//id가 일치하지 않는경우
			result = "[{'res':'no_id'}]";
			
			//no_id를 가진 json데이터를 콜백메서드(resFn)로 전송
			response.getWriter().print(result);
			return; 
		}
		
		//비밀번호 불일치
		if( !vo.getPwd().equals(pwd) ) {
			result = "[{'res':'no_pwd'}]";
			response.getWriter().print(result);
			return;
		}
		
		//아이디와 비밀번호 체크에 문제가 없다면 vo객체를
		//어디서든 사용가능하도록 sessionScope영역에 저장.
		HttpSession session = request.getSession();//세션영역을 가져온다
		session.setAttribute("vo", vo);
		//세션유지시간(기본값 30분)
		session.setMaxInactiveInterval( 60 * 60 );//세션 유지시간을 1시간으로 설정
		
		result = "[{'res':'clear'}]";
		response.getWriter().print(result);
		
	}

}









