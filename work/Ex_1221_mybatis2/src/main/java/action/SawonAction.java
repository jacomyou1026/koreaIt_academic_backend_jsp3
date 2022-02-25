package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SawonDAO;
import vo.SwonVO;

/**
 * Servlet implementation class SawonAction
 */
@WebServlet("/sawon_list")
public class SawonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//sawon_list?deptno = 10
		//sawon_list <== null
		//sawon_list?deptno =  <=="",empty
		
		request.setCharacterEncoding("utf-8");
		int deptno =0;
		String s_deptno =request.getParameter("deptno");
		
		
		//파라미터가 null이거나 empty가 아닌 경우(정상적으로 값이 넘어온 경우)
		if(s_deptno!=null && !s_deptno.isEmpty()) {
			deptno = Integer.parseInt(s_deptno);
		}
		
		//sawon_list?search=감우성
		String s_name = request.getParameter("search");
	
		
		 List<SwonVO> list =null;
		 if(deptno==0) {
			 //전체 사원 조회
			 list =SawonDAO.getInstance().select();
		 }else {
			 //부서별 사원 조회
			 list= SawonDAO.getInstance().select(deptno);
		 }
		 
		 System.out.println(s_name);
		 if(s_name ==null||s_name.equals("all")) {
			 list =SawonDAO.getInstance().select();
		 }else {
			 list =SawonDAO.getInstance().selectName(s_name);
		 }
		 
		 request.setAttribute("list", list);
		 RequestDispatcher disp =request.getRequestDispatcher("sawon_list.jsp");
		 disp.forward(request, response);
		 
		 
	}

}
