package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import service.DBService;
import vo.MyUserVO;

public class MyuserDAO {
// single-ton pattern: 
// 객체1개만생성해서 지속적으로 서비스하자
static MyuserDAO single = null;

public static MyuserDAO getInstance() {
	//생성되지 않았으면 생성
	if (single == null)
		single = new MyuserDAO();
	//생성된 객체정보를 반환
	return single;
}

 public MyUserVO selectOne(String idx) {
	 
	MyUserVO vo = null;

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from myuser where id=?";

	try {
		//1.Connection얻어온다
		conn = DBService.getInstance().getConnection();
		//2.명령처리객체정보를 얻어오기
		pstmt = conn.prepareStatement(sql);

		//3.pstmt parameter 설정
		pstmt.setString(1, idx);
		//4.결과행 처리객체 얻어오기
		rs = pstmt.executeQuery();

		if (rs.next()) {
			vo = new MyUserVO();
			//현재레코드값=>Vo저장
			vo.setName(rs.getString("name"));
			vo.setPwd(rs.getString("pwd"));
		}

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	return vo;
}
	
	
}
