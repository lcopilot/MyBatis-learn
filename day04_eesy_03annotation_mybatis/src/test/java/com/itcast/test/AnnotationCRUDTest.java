package com.itcast.test;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
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
 * @time: 17:55
 * @description:
 */
public class AnnotationCRUDTest {
	private InputStream in;
	private SqlSessionFactory factory;
	private SqlSession session;
	private UserDao userDao;

	@Before
	public void init() throws IOException {
		in= Resources.getResourceAsStream("SqlMapConfig.xml");
		factory=new SqlSessionFactoryBuilder().build(in);
		session = factory.openSession();
		userDao = session.getMapper(UserDao.class);
	}
	@After
	public void destroy() throws IOException {
		//提交事务
		session.commit();
		//释放资源
		session.close();
		in.close();
	}

	/**
	 * 测试基于注解保存用户
	 */
	@Test
	public void testSave(){
		User user = new User();
		user.setUsername("mybatis Annotation");
		user.setAddress("长沙");
		user.setSex("男");
		user.setBirthday(new Date());

		userDao.saveUser(user);
	}

	/**
	 * 测试基于注解更新用户
	 */
	@Test
	public void testUpdate(){
		User user = new User();
		user.setUsername("mybatis Annotation update");
		user.setAddress("长沙");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setId(57);

		userDao.updateUser(user);
	}

	/**
	 * 测试基于注解删除用户
	 */
	@Test
	public void testDelete(){
		userDao.deleteUser(52);
	}

	/**
	 * 测试基于注解通过id查找一个用户
	 */
	@Test
	public void testFindById(){
		User user = userDao.findById(57);
		System.out.println(user);
	}
	/**
	 * 测试基于注解通过用户名模糊查询
	 */
	@Test
	public void testFindUserByName(){
		List<User> users = userDao.findUserByName("王");
		for (User user : users) {
			System.out.println(user);
		}
	}
	/**
	 * 测试基于注解查询用户数量
	 */
	@Test
	public void testFindTotalUser(){
		int totalUser = userDao.findTotalUser();
		System.out.println(totalUser);
	}
}
