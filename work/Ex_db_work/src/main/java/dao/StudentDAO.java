package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.StudentVo;

public class StudentDAO {

	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static StudentDAO single = null;

	public static StudentDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new StudentDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	
	public List<StudentVo> selectList() {

		List<StudentVo> list = new ArrayList<StudentVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from T_STUDENT  ";

		try {
			//1.Connection얻어온다
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체정보를 얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.결과행 처리객체 얻어오기
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StudentVo vo = new StudentVo();
				//현재레코드값=>Vo저장
				vo.setStudno(rs.getInt("studno"));
				vo.setName(rs.getString("name"));
				vo.setGrade(rs.getInt("grade"));
				vo.setHeight(rs.getInt("height"));
				vo.setWight(rs.getInt("weight"));
				vo.setDeptno1(rs.getInt("deptno1"));
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
	public int delete(int vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from t_student where studno = ?";

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
	
	public int insert(StudentVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into t_student(studno,name,grade,height,weight,deptno1) values(st_seq.nextval,?,?,?,?,?)";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getGrade());
			pstmt.setInt(3, vo.getHeight());
			pstmt.setInt(4, vo.getWight());
			pstmt.setInt(5, vo.getDeptno1());
			
			
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
	
	public int update(StudentVo vo) {
		// TODO Auto-generated method stub
		int res = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update t_student set name= ?,grade=?, height =?,weight = ?,deptno1 =? where studno=? ";

		try {
			//1.Connection획득
			conn = DBService.getInstance().getConnection();
			//2.명령처리객체 획득
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getGrade());
			pstmt.setInt(3, vo.getHeight());
			pstmt.setInt(4, vo.getWight());
			pstmt.setInt(5, vo.getDeptno1());
			pstmt.setInt(6, vo.getStudno());
			
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