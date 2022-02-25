package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class IdCheckAction
 */
@WebServlet("/check_id.do")
public class IdCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check_id.do?id=one
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		System.out.println(id);
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		String resultStr = "";
		if(vo==null) {
			//회원가입이 가능한 경우
			//추후에 resultStr에 담긴 json구조의 데이터가 콜백메서드로 전달되는데
			//이 json값을 받은 콜백메서드는 배열구조의 json이 아닌
			//일반 단일 json형태일때 분석이 불가하므로, 콜백메서드로 json타입의 데이터를 보낼때는
			//꼭 []배열 형식으로 묶어서 보내도록 한다
			resultStr = "[{'res':'yes'}]";
			
		}else {
			resultStr = "[{'res':'no'}]";			
		}
		System.out.println(resultStr);
		//resultStr값을 가지고 콜백메서드로 복귀
		response.getWriter().print(resultStr);
	}

}












