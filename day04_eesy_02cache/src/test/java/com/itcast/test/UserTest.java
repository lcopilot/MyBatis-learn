package com.itcast.test;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
 * @date: 2019/10/11
 * @time: 15:02
 * @description:
 */
public class UserTest {

	private UserDao userDao;
	private SqlSession sqlSession;
	private InputStream in;
	SqlSessionFactory factory;

	@Before
	public void init() throws IOException {
		//1.读取配置文件
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//2.获取SqlSessionFactory
	 	factory = new SqlSessionFactoryBuilder().build(in);
		;
		//3.获取SqlSession对象
		sqlSession = factory.openSession(true);
		//4.获取dao的代理对象
		userDao = sqlSession.getMapper(UserDao.class);
	}

	@After
	public void destroy() throws IOException {
		//提交事务
		//sqlSession.commit();
		//6.释放资源
		sqlSession.close();
		in.close();

	}

	/**
	 * 测试一级缓存
	 */
	@Test
	public void testFirstLevelCache() {
		User byId = userDao.findById(41);
		System.out.println(byId);
		//sqlSession.close();

		//再次获取SqlSession对象
		//sqlSession=factory.openSession();

		sqlSession.clearCache();//此方法也可以清空缓存
		userDao=sqlSession.getMapper(UserDao.class);

		User byId2 = userDao.findById(41);
		System.out.println(byId2);

		System.out.println(byId==byId2);
	}
	/**
	 * 测试一级缓存
	 */
	@Test
	public void testClearCache() {
		//1.根据id查询用户
		User user1 = userDao.findById(41);
		System.out.println(user1);
		//2.更新用户信息
		user1.setUsername("update user clear cache");
		user1.setAddress("长沙市天心区");
		userDao.updateUser(user1);

		//3.再次查询id为41的用户
		User user2 = userDao.findById(41);
		System.out.println(user2);

		System.out.println(user1==user2);
	}

}
