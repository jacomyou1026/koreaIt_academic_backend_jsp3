package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDAO;
import vo.PhotoVO;

/**
 * Servlet implementation class DeleteAction
 */
@WebServlet("/photo_del.do")
public class DeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//photo_del.do?idx="+idx
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt(request.getParameter("idx"));

		//파라미터로 받은 idx에 해당되는 게시물을 조회
		PhotoVO vo = PhotoDAO.getInstance().selectOne(idx);
		
		String web_path = "/img/";
		ServletContext app =request.getServletContext();
		String path  = app.getRealPath(web_path);
		
		int res =PhotoDAO.getInstance().delete(idx);
		if(res>0) {
			File f= new File(path,vo.getFilename());
			if(f.exists()) { //path경로로 들어가서 지우고자 하는 파일명과 일치하는 데이터가 존재한다면 
				f.delete();//vo.getFilename과 일치하는 파일을 삭제
			}
			
			//삭제완료 후 첫페이지로 화면을 전환
			response.sendRedirect("list.do");
		
	}}

}
