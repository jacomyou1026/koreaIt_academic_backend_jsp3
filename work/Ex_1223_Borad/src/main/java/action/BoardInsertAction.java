package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import vo.BoardVO;

/**
 * Servlet implementation class BoardInsertAction
 */
@WebServlet("/insert.do")
public class BoardInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//insert.do?subject=제목&name=작성자명&content=내용&pwd=1111
		
		String subject = request.getParameter("subject");
		String name= request.getParameter("name");
		String content= request.getParameter("content");
		String pwd = request.getParameter("pwd");
		
		String ip = request.getRemoteAddr();
		
		BoardVO vo =new BoardVO();
		
		vo.setSubject(subject);
		vo.setName(name);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setIp(ip);
		
		int res = BoardDAO.getInstance().Insret(vo);
		response.sendRedirect("list.do");
		
	}

}
