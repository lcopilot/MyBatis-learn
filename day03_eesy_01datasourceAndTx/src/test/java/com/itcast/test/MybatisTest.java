package com.itcast.test;

import com.itcast.dao.UserDao;
import com.itcast.dao.impl.UserDaoImpl;
import com.itcast.domain.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MybatisTest {

	private UserDao userDao;
	private InputStream in;

	@Before
	public void init() throws IOException {
		//1.读取配置文件
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		;
		//3.使用工厂对象创建dao对象
		userDao = new UserDaoImpl(factory);
	}

	@After
	public void destroy() throws IOException {
		//6.释放资源
		in.close();

	}

	/**
	 * 测试查询所有
	 *
	 * @throws IOException
	 */
	@Test
	public void testFindAll() throws IOException {
		//5.执行查询所有方法
		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user);
		}

	}

	/**
	 * 测试保存操作
	 */
	@Test
	public void testSave() throws IOException {
		User user = new User();
		user.setUsername("autocommit");
		user.setAddress("长沙");
		user.setSex("男");
		user.setBirthday(new Date());
		System.out.println("保存前:" + user);
		//5.执行保存方法
		userDao.saveUser(user);
		System.out.println("保存后:" + user);
	}

	/**
	 * 测试更新操作
	 */
	@Test
	public void testUpdate() throws IOException {
		User user = new User();
		user.setId(53);
		user.setUsername("mybatis update user");
		user.setAddress("长沙");
		user.setSex("男");
		user.setBirthday(new Date());
		//5.执行保存方法
		userDao.updateUser(user);

	}

	/**
	 * 测试通过id删除用户操作
	 */
	@Test
	public void testDelete() throws IOException {
		//5.执行删除方法
		userDao.deleteUser(54);

	}

	/**
	 * 测试通过id查询用户操作
	 */
	@Test
	public void testFindByUser() throws IOException {
		//5.执行查询一个用户方法
		User user = userDao.findById(46);
		System.out.println(user);

	}

	/**
	 * 测试通过用户名模糊查询用户操作
	 */
	@Test
	public void testFindByName() throws IOException {
		//5.执行查询一个用户方法
		List<User> users = userDao.findByName("%王%");
		//List<User> users = userDao.findByName("老");
		for (User user : users) {
			System.out.println(user);
		}

	}

	/**
	 * 测试查询总用户数
	 */
	@Test
	public void testFindTotal() throws IOException {
		//5.执行查询总用户数
		int count = userDao.findTotal();
		System.out.println(count);
	}


}
