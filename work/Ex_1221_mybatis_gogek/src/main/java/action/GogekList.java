package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GogekDAO;
import vo.GogekVO;

/**
 * Servlet implementation class GogekList
 */
@WebServlet("/gogek_list.do")
public class GogekList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		int deptno = 0;
		String s_deptno = request.getParameter("deptno");
		
		String s_name = request.getParameter("name");
		
		if(s_deptno!=null&& !s_deptno.isEmpty()) {
			deptno = Integer.parseInt(s_deptno);
		}
		
		
		List<GogekVO> list =null;
		if(deptno==0) {
			list =GogekDAO.getInstance().select();
		}else {
			list = GogekDAO.getInstance().select(deptno);
		}
		
		if(s_name==null||s_name.equals("all")) {
			list= GogekDAO.getInstance().select();
		}else {
			list = GogekDAO.getInstance().selectName(s_name);
		}
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("gogek_list.jsp");
		
		disp.forward(request, response);
	}

}
