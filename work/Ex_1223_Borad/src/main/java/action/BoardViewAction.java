package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class BoardViewAction
 */
@WebServlet("/view.do")
public class BoardViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//	<a href="view.do?idx=${vo.idx }">
		int idx = Integer.parseInt(request.getParameter("idx"));

		BoardDAO dao = BoardDAO.getInstance();
		//idx에 해당하는 게시글 한 건 얻어오
		BoardVO list= dao.selectOne(idx);
		
		//조회수 증가
		//세션에 값을 저장하여 조회수가 한번에 하나만 증가되도록 처리
		HttpSession session = request.getSession();
		String show = (String) session.getAttribute("a");
		if(show == null) {
			dao.update_readhit(idx);
			session.setAttribute("a", "");
		}
			
		//바인딩
		request.setAttribute("list", list);
		
		//포워딩
		RequestDispatcher disp = request.getRequestDispatcher("view.jsp");
		
		disp.forward(request, response);
		
		
		
		
		
		
	}

}
