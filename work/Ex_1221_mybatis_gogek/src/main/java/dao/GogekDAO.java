package dao;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.mybatisConnector;
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
	
	SqlSessionFactory factory= null;
	
	public GogekDAO() {
		factory = mybatisConnector.getInstance().getFactory();
		
		
	}
	public List<GogekVO> select() {
		SqlSession session = factory.openSession();
		List<GogekVO> list = session.selectList("g.gogek_list");
		session.close();
		return list;
	}
	
	public List<GogekVO> select(int deptno) {
		SqlSession session = factory.openSession();
		List<GogekVO> list = session.selectList("g.gogek_deptno",deptno);
		session.close();
		return list;
	}
	
	public List<GogekVO> selectName(String name) {
		SqlSession session = factory.openSession();
		List<GogekVO> list = session.selectList("g.gogek_name",name);
		session.close();
		return list;
	}
	
	public int insert(GogekVO vo) {
		SqlSession session = factory.openSession(true);
		int res = session.insert("g.gogek_insert",vo);
		session.close();
		return res;
				
	}
}
