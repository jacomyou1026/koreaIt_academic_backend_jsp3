package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GogekDAO;
import vo.GogekVO;

/**
 * Servlet implementation class InsertAction
 */
@WebServlet("/insert.do")
public class InsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gobun = Integer.parseInt(request.getParameter("gobun"));
		String goname = request.getParameter("goname");
		String gojumin = request.getParameter("gojumin");
		String goaddr= request.getParameter("goaddr");
		
		GogekVO vo = new GogekVO();
		vo.setGoaddr(goaddr);
		vo.setGobun(gobun);
		vo.setGojumin(gojumin);
		vo.setGoname(goname);
		
		int res =  GogekDAO.getInstance().insert(vo);
		
		if(res>0) {
			response.sendRedirect("list.do");
		}
		
		
	}

}
