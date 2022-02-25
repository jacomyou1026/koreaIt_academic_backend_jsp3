package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

/**
 * Servlet implementation class DeleteAction
 */
@WebServlet("/del.do")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		int res = MemberDAO.getInstance().delete(idx);
		
		String resultStr ="";
		if (res>0) {//삭제 성공
			resultStr = "[{'p':'yes'}]";
		}else {//삭제 실패
			resultStr = "[{'p':'no'}]";
			
		}
		
		//param변수를 콜백메서드로 보낸다.
		response.getWriter().print(resultStr);
		
	}

}
