package action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDAO;
import vo.PhotoVO;

/**
 * Servlet implementation class InSertAction
 */
@WebServlet("/insert.do")
public class InSertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String web_img = "/img/";
		ServletContext sc = request.getServletContext();
		
		String path = sc.getRealPath(web_img);
		
		int max_size = 1024*1024*100;
		MultipartRequest mr = new MultipartRequest(
				request, 
				 path, //업로드 위치
				max_size, //최대용량
				"utf-8",//수신 인코딩 타입
				new DefaultFileRenamePolicy()); 
		
		File f =mr.getFile("photo");
		String filename ="";
		if(f!= null) {
			filename = f.getName();
		}
		System.out.println(filename+"sd");
		
		String title = mr.getParameter("title");
		System.out.println(title+"DF");
		String pwd = mr.getParameter("pwd");
		String ip = request.getRemoteAddr();
		
		
		PhotoVO vo =new PhotoVO();
		vo.setFilename(filename);
		vo.setIp(ip);
		vo.setPwd(pwd);
		vo.setTitle(title);
		
		PhotoDAO.getInstance().insert(vo);
		
		response.sendRedirect("list.do");

	}

}
