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
 * Servlet implementation class DeptnoListAction
 */
@WebServlet("/dept_list.do")
public class DeptnoListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DeptVO> list = DeptDAO.getInstance().selectList();
		
		//list 바이딩
		request.setAttribute("m_list", list);
		
		//바인딩 된 정보를 어디에서 사용할 지 알려주는 포워딩
		RequestDispatcher disp =request.getRequestDispatcher("dept_list.jsp");
		disp.forward(request, response);
		
		
		
	}

}
