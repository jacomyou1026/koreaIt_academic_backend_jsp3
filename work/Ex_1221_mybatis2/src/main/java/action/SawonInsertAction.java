package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDAO;
import vo.SwonVO;

/**
 * Servlet implementation class SawonInsertAction
 */
@WebServlet("/insert.do")
public class SawonInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int sabun = Integer.parseInt(request.getParameter("sabun"));
		int deptno= Integer.parseInt(request.getParameter("deptno"));
		int sapay= Integer.parseInt(request.getParameter("sapay"));
		int samgr= Integer.parseInt(request.getParameter("samgr"));
		String saname = request.getParameter("saname");
		String sagen= request.getParameter("sagen");
		String sajob= request.getParameter("sajob");
		String sahire= request.getParameter("sahire");
		
		//받아온 파라미터를 vo에 포장
		SwonVO vo =new SwonVO();
		vo.setDeptno(deptno);
		vo.setSabun(sabun);
		vo.setSagen(sagen);
		vo.setSahire(sahire);
		vo.setSajob(sajob);
		vo.setSamgr(samgr);
		vo.setSaname(saname);
		vo.setSapay(sapay);
		
		int res = SawonDAO.getInstance().insert(vo);
		
		response.sendRedirect("sawon_list");
	}
	

}
