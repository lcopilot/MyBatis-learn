package com.itcast.test;

import com.itcast.dao.AccountDao;
import com.itcast.dao.UserDao;
import com.itcast.domain.Account;
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
 * @date: 2019/10/14
 * @time: 17:55
 * @description:
 */
public class AccountTest {

	private InputStream in;
	private SqlSessionFactory factory;
	private SqlSession session;
	private AccountDao accountDao;

	@Before
	public void init() throws IOException {
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		factory = new SqlSessionFactoryBuilder().build(in);
		session = factory.openSession();
		accountDao = session.getMapper(AccountDao.class);
	}

	@After
	public void destroy() throws IOException {
		//提交事务
		session.commit();
		//释放资源
		session.close();
		in.close();
	}
	@Test
	public void testFindAll(){
		List<Account> accounts = accountDao.findAll();
		for (Account account : accounts) {
			System.out.println(account);
			System.out.println(account.getUser());
		}

	}

	/**
	 * 测试基于注解通过id查找一个用户
	 */
	@Test
	public void testFindById() {
		//User user = userDao.findById(57);
		//System.out.println(user);
	}

	/**
	 * 测试基于注解通过用户名模糊查询
	 */
	@Test
	public void testFindUserByName() {
		//List<User> users = userDao.findUserByName("王");
//		for (User user : users) {
//			System.out.println(user);
//		}
	}

}
