package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SwonVO;

public class SawonDAO {
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static SawonDAO single = null;

	public static SawonDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new SawonDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory = null;
	
	public SawonDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
		
	}
	
	//사원전체목록 조회
	public List<SwonVO> select(){
		SqlSession sqlSession = factory.openSession();
		
		List<SwonVO> list = sqlSession.selectList("s.swon_list");
		
		sqlSession.close();
		return list;
	}
	//부서별 사원목록 조회
	public List<SwonVO> select(int no){
	SqlSession sqlSeqssion = factory.openSession();
	
	//파라미터 no를 mapper로 전달
	//mapper로 전달되는 파라미터는 최대가 1개 이다.
	List<SwonVO> list = sqlSeqssion.selectList("s.sawon_dept",no);
	sqlSeqssion.close();
	return list;
	
	}
	
	public List<SwonVO> selectName(String name){
		SqlSession sqlSession = factory.openSession();
		List<SwonVO> list = sqlSession.selectList("s.sawon_name",name);
		sqlSession.close();
		return list;
	}
	
	public int insert(SwonVO vo){
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.insert("s.sawon_insert",vo);
		//factory.openSession(true) : auto commit을 통해 sqlSession.commit(); 코드생략 가능 
		//sqlSession.commit();
		
		sqlSession.close();
		return res;
		
	}
}
