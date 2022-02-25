package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.GogekVO;

public class GogekDAO {
// single-ton pattern: 
// 객체1개만생성해서 지속적으로 서비스하자
static GogekDAO single = null;

public static GogekDAO getInstance() {
	//생성되지 않았으면 생성
	if (single == null)
		single = new GogekDAO();
	//생성된 객체정보를 반환
	return single;
}

public List<GogekVO> selectList() {

	List<GogekVO> list = new ArrayList<GogekVO>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from gogek";

	try {
		//1.Connection얻어온다
		conn = DBService.getInstance().getConnection();
		//2.명령처리객체정보를 얻어오기
		pstmt = conn.prepareStatement(sql);

		//3.결과행 처리객체 얻어오기
		rs = pstmt.executeQuery();

		while (rs.next()) {
			GogekVO vo = new GogekVO();
			//현재레코드값=>Vo저장
			vo.setGoaddr(rs.getString("goaddr"));
			vo.setGobun(rs.getInt("gobun"));
			vo.setGojumin(rs.getString("gojumin"));
			vo.setGoname(rs.getString("goname"));
			//ArrayList추가
			list.add(vo);
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

	return list;
}
public int update(GogekVO vo) {
	// TODO Auto-generated method stub
	int res = 0;

	Connection conn = null;
	PreparedStatement pstmt = null;

	String sql = "update gogek set goname =?,goaddr=?,gojumin=? where gobun=?";

	try {
		//1.Connection획득
		conn = DBService.getInstance().getConnection();
		//2.명령처리객체 획득
		pstmt = conn.prepareStatement(sql);

		//3.pstmt parameter 채우기
		pstmt.setString(1, vo.getGoname());
		pstmt.setString(2, vo.getGoaddr());
		pstmt.setString(3, vo.getGojumin());
		pstmt.setInt(4, vo.getGobun());
		
		//4.DB로 전송(res:처리된행수)
		res = pstmt.executeUpdate();

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {

		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return res;
}

public int delete(int vo) {
	// TODO Auto-generated method stub
	int res = 0;

	Connection conn = null;
	PreparedStatement pstmt = null;

	String sql = "delete from gogek where gobun =?";

	try {
		//1.Connection획득
		conn = DBService.getInstance().getConnection();
		//2.명령처리객체 획득
		pstmt = conn.prepareStatement(sql);

		//3.pstmt parameter 채우기
		pstmt.setInt(1, vo);
		//4.DB로 전송(res:처리된행수)
		res = pstmt.executeUpdate();

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {

		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return res;
}
public int insert(GogekVO vo) {
	// TODO Auto-generated method stub
	int res = 0;

	Connection conn = null;
	PreparedStatement pstmt = null;

	String sql = "insert into gogek(gobun,goname,goaddr,gojumin) values(gobun=?,goname=?,goaddr=?,gojumin=?)";

	try {
		//1.Connection획득
		conn = DBService.getInstance().getConnection();
		//2.명령처리객체 획득
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getGobun());
		pstmt.setString(2, vo.getGoname());
		pstmt.setString(3, vo.getGoaddr());
		pstmt.setString(2, vo.getGojumin());
		//3.pstmt parameter 채우기
			
		//4.DB로 전송(res:처리된행수)
		res = pstmt.executeUpdate();

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {

		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return res;
}
}
