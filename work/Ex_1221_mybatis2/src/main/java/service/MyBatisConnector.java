package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnector {
	
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
	
	public MyBatisConnector() {
		try {
			Reader read = Resources.getResourceAsReader("config/mtbatis/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(read);
			read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public SqlSessionFactory getFactory() {
		return factory;
	}
}
