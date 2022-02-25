package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GogekDAO;
import vo.GogekVO;

/**
 * Servlet implementation class GogekUpdateAction
 */
@WebServlet("/update.do")
public class GogekUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int gobun = Integer.parseInt(request.getParameter("gobun")); 
			String goname = request.getParameter("goname");
			String goaddr = request.getParameter("goaddr");
			String gojumin= request.getParameter("gojumin");
			
			System.out.println(gobun+"Dfdf");
			System.out.println(goname);
			System.out.println(goaddr);
			
			GogekVO vo =new GogekVO();
			vo.setGoaddr(goaddr);
			vo.setGobun(gobun);
			vo.setGojumin(gojumin);
			vo.setGoname(goname);
			
			int res = GogekDAO.getInstance().update(vo);
			
			if(res>0) {
				response.sendRedirect("list.do");
			}
			
	}

}
