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
 * Servlet implementation class BoardDeleteAction
 */
@WebServlet("/del.do")
public class BoardDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//del.do?idx=20
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		//삭제를 원하는 게시물의 일련번호를 통해 정보를얻어온다.
		BoardVO baseVO = dao.selectOne(idx);
		
		baseVO.setSubject("이미 삭제된 게시글입니다.");
		baseVO.setName(" ");
		
		//제목과 작성자가 변경된 baseVO를 DB에 업데이트
		int res = dao.del_update(baseVO);
		//res값을 가지고 view의 콜백메서드(delResult)로 복귀
		response.getWriter().print(res);
		
		
		
	}

}
