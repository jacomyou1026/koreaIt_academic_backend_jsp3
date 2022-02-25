package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnector {
	
	//MyBatis : 데이터베이스 프로그래밍을 좀 더 쉽게 할 수 있게 도와주는 개발 프레임워크
	//기존 DAO처럼 50줄 이상의 코드를 사용하여 조회,수정등을 하던 코드를 좀 더 편하게 관리, 사용하기 위해 개발
	
	//sqlMapConfig.xml로 접근
	SqlSessionFactory factory = null;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static MyBatisConnector single = null;

	public static MyBatisConnector getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new MyBatisConnector();
		//생성된 객체정보를 반환
		return single;
	}
	
	private MyBatisConnector() {
		//생성자
		try {
			//sqlMapConfig.xml의 내용을 읽어오기위한 준비
			Reader reader = Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public SqlSessionFactory getFactory() {
		return factory;
	}
	
	
	
}
