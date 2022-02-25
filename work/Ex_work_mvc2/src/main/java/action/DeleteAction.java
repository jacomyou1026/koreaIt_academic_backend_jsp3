package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GogekDAO;

/**
 * Servlet implementation class DeleteAction
 */
@WebServlet("/delet.do")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int gobun = Integer.parseInt(request.getParameter("gobun"));
		int res = GogekDAO.getInstance().delete(gobun);
		String resultStr = "";
		if(res>0) {
			resultStr ="[{'p':'yes'}]"; 
		}else {
			resultStr ="[{'p':'no'}]"; 
		}
		
		response.getWriter().print(resultStr);
	}

}
