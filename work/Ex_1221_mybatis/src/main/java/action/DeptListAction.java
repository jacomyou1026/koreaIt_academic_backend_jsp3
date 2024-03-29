package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptListAction
 */
@WebServlet("/dept_list.do")
public class DeptListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//부서목록 가져오기
		List<DeptVO> list =DeptDAO.getInstance().select();
		
		//dept_list.jsp에서 
		request.setAttribute("list", list);
		RequestDispatcher disp = request.getRequestDispatcher("dept_list.jsp");
		disp.forward(request, response);
		
		
	}

}
