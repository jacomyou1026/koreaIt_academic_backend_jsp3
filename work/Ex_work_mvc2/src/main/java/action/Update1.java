package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update1
 */
@WebServlet("/update1.do")
public class Update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int gobun = Integer.parseInt(request.getParameter("gobun")); 
		String goname = request.getParameter("goname");
		String goaddr = request.getParameter("goaddr");
		String gojumin= request.getParameter("gojumin");
	
		
		request.setAttribute("goname", goname);
		request.setAttribute("gobun", gobun);
		request.setAttribute("goaddr", goaddr);
		request.setAttribute("gojumin", gojumin);
		
		RequestDispatcher dis = request.getRequestDispatcher("update.jsp");
		dis.forward(request, response);
		
		
	}

}
