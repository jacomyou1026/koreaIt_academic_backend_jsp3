package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVO;

public class DeptDAO {
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new DeptDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory =null;
	
	public DeptDAO() {
		//MyBatisConnector.java에서 설정해준 factory(어떤 계정의 DB를 쓸 것인가.. 어떤 mapper를 쓸 것인가)
		//를 DAO에서 받아온다.
		factory= MyBatisConnector.getInstance().getFactory();
	}
	
	//부서목록 가져오기
	public List<DeptVO> select() {
		
		//mapper로 접근하여 결과를 가지고 올 객체
		SqlSession sqlSession = factory.openSession();
		
		List<DeptVO> list = sqlSession.selectList("s.dept_list");
		
		//DB사용에 관여한 객체들을 닫아준다.
		sqlSession.close();
		
		return list;
	}
	
}
