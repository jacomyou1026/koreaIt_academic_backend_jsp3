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
 * Servlet implementation class ListAction
 */
@WebServlet("/insert.do")
public class InsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * // - private int gobun; private String goname; private String goaddr; private
		 * String gojumin; private int godam;
		 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int gobun = Integer.parseInt(request.getParameter("gobun"));
		int godam= Integer.parseInt(request.getParameter("godam"));
		String goname =request.getParameter("goname");
		String goaddr=request.getParameter("goaddr");
		String gojumin=request.getParameter("gojumin");
		
		GogekVO vo = new GogekVO();
		vo.setGoaddr(goaddr);
		vo.setGobun(gobun);
		vo.setGodam(godam);
		vo.setGojumin(gojumin);
		vo.setGoname(goname);
		
		int res = GogekDAO.getInstance().insert(vo);
		System.out.println(res+"fdsfs");
		response.sendRedirect("gogek_list.do");
		
		
	}

}
