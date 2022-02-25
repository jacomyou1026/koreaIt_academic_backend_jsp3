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
 * Servlet implementation class BoardReplyAction
 */
@WebServlet("/reply.do")
public class BoardReplyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//reply.do?idx=2&page=2subject=제목&name=작성자명&content=내용&pwd=1111
		
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String subject = request.getParameter("subject");
		String name= request.getParameter("name");
		String content= request.getParameter("content");
		String pwd = request.getParameter("pwd");
		String ip = request.getRemoteAddr();
		
		BoardDAO dao = BoardDAO.getInstance();
		
		//댓글을 달고자하는 기준글의 idx를 사용하여 정보를 얻어온다.
		BoardVO baseVO = dao.selectOne(idx);
		
		//기준글의 step보다 큰 값을 가진 step들을 +1처리
		dao.update_step(baseVO);
		
		//댓글vo
		BoardVO vo  =new BoardVO();
		vo.setContent(content);
		vo.setIdx(idx);
		vo.setIp(ip);
		vo.setName(name);
		vo.setPwd(pwd);
		vo.setSubject(subject);
		
		vo.setRef(baseVO.getRef());
		vo.setStep(baseVO.getStep()+1);
		vo.setDepth(baseVO.getDepth()+1);
		
		//댓글 등록
		dao.reply(vo);
		
	
		//reply.do?
		//reply.do?page=
		
		//int myPage = 1;
		String page = request.getParameter("page");
		
//		if(page!=null&&!page.isEmpty()) {
//			myPage = Integer.parseInt(page);
//		}
//		
		response.sendRedirect("list.do?page="+page);
		
		
	}

}
