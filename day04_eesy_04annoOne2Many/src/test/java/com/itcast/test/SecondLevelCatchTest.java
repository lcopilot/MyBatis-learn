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
 * @date: 2019/10/15
 * @time: 10:34
 * @description:
 */
public class SecondLevelCatchTest {

	private InputStream in;
	private SqlSessionFactory factory;
	private SqlSession session;
	private UserDao userDao;

	@Before
	public void init() throws IOException {
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		factory = new SqlSessionFactoryBuilder().build(in);
		session = factory.openSession();
		userDao = session.getMapper(UserDao.class);
	}

	@After
	public void destroy() throws IOException {
		in.close();
	}

	@Test
	public void testFindById() {
		User user = userDao.findById(57);
		System.out.println(user);
		session.close();//释放一级缓存

		SqlSession session1=factory.openSession();//再次打开session
		UserDao userDao1=session1.getMapper(UserDao.class);
		User user1 = userDao1.findById(57);
		System.out.println(user1);

	}
}






