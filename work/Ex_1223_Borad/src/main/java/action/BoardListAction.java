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
import util.Common;
import util.Paging;
import vo.BoardVO;

/**
 * Servlet implementation class BoardListAction
 */
@WebServlet("/list.do")
public class BoardListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8");
		
		//list.do <--- null
		//list.do?page=	<--empty
		
		int nowPage = 1; //기본페이지는 1페이지
		
		String page = request.getParameter("page");
		
		if(page !=null && !page.isEmpty()) {
			nowPage=Integer.parseInt(page);
		}
		
		//한페이지에 보여줄 게시물의 시작번호와 끝번호를 계산
		//1page는 1~5번 게시물까지 보여줘야 함
		//2page 는 6~10
		
		int start = (nowPage-1) * Common.Board.BLOCKLIST+1;
		int end = start+Common.Board.BLOCKLIST-1;
		
		//페이지별 목록 가져오기
		BoardDAO dao = BoardDAO.getInstance();
		
		//전체 게시물 수 구하기
		int row_total = dao.rowTotal();
		
		//하단부에 추가될 페이지 메뉴 생성
		String pageMenu = Paging.getPaging("list.do", //호출되는 페이지url
				nowPage, //현재 페이지 번호 
				row_total, //전체 게시물 수
				Common.Board.BLOCKLIST, //한페이지에 몇개 보여줄지 
				Common.Board.BLOCKPAGE);
		
		
		List<BoardVO> list= dao.select(start,end);
		
		request.setAttribute("list", list);
		request.setAttribute("pageMenu", pageMenu); //하단 페이지 메뉴 바인딩
		
		//세션에 저장해둔 a라는 키값을 제거
		HttpSession session = request.getSession();
		session.removeAttribute("a");
		
		RequestDispatcher disp = request.getRequestDispatcher("list.jsp");
		
		disp.forward(request, response);
	}

}
