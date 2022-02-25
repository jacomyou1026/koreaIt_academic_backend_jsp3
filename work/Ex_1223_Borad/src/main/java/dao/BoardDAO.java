package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.BoardVO;

public class BoardDAO {
// single-ton pattern: 
// 객체1개만생성해서 지속적으로 서비스하자
	static BoardDAO single = null;

	public static BoardDAO getInstance() {
		// 생성되지 않았으면 생성
		if (single == null)
			single = new BoardDAO();
		// 생성된 객체정보를 반환
		return single;
	}
	
	SqlSessionFactory factory = null;
	public BoardDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	

	public List<BoardVO> select(int start, int end) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("s", start);
		map.put("e", end);
		
		SqlSession sqlSession = factory.openSession();
		List<BoardVO> list = sqlSession.selectList("b.board_list",map);
		sqlSession.close();
		return  list;
	}
	
	public int Insret(BoardVO vo) {
		SqlSession session = factory.openSession(true);
		int res = session.insert("b.board_insert",vo);
		session.close();
		return res;
	}
	
	//게시글 상세보기
	public BoardVO selectOne(int idx){
		SqlSession sqlSession = factory.openSession();
		BoardVO li = sqlSession.selectOne("b.board_one",idx);
		sqlSession.close();
		return li;
	}
	
	//조회수 증가시키기
	public int update_readhit(int idx) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("b.update_readhit",idx);
		sqlSession.close();
		return res;
	}
	//댓글처리를 위한 step+1
	public int update_step(BoardVO baseVO ) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("b.update_step",baseVO);
		sqlSession.close();
		return res;
	}
	//댓글등록
	public int reply(BoardVO vo) {
		SqlSession sqlSession= factory.openSession(true);
		int res = sqlSession.insert("b.board_reply",vo);
		sqlSession.close();
		return res;
	}
	
	
	//게시글 삭제
	public int del_update(BoardVO baseVO ) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.update("b.del_update",baseVO);
		sqlSession.close();
		return res;
	}
	
	//전체 게시물 수
	public int rowTotal() {
		SqlSession sqlSession = factory.openSession();
		int res = sqlSession.selectOne("b.board_count");
		sqlSession.close();
		return res;
	}
	
}
