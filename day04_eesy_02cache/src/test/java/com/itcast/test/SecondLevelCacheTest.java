package com.itcast.test;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/14
 * @time: 15:51
 * @description:
 */
public class SecondLevelCacheTest {

	private InputStream in;
	SqlSessionFactory factory;

	@Before
	public void init() throws IOException {
		//1.读取配置文件
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//2.获取SqlSessionFactory
		factory = new SqlSessionFactoryBuilder().build(in);

	}

	@After
	public void destroy() throws IOException {
		//提交事务
		//sqlSession.commit();
		//6.释放资源
		in.close();

	}

	/**
	 * 测试一级缓存
	 */
	@Test
	public void testFirstLevelCache() {
		SqlSession sqlSession1=factory.openSession();
		UserDao userDao1=sqlSession1.getMapper(UserDao.class);
		User byId1 = userDao1.findById(41);
		System.out.println(byId1);
		sqlSession1.close();	//一级缓存消失

		SqlSession sqlSession2=factory.openSession();
		UserDao userDao2=sqlSession2.getMapper(UserDao.class);
		User byId2 = userDao2.findById(41);
		System.out.println(byId2);
		sqlSession2.close();

		System.out.println(byId1 == byId2);
	}


}
