package com.itcast.test;

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
public class AccountTest {
	private AccountDao accountDao;
	private SqlSession sqlSession;
	private InputStream in;

	@Before
	public void init() throws IOException {
		//1.读取配置文件
		in = Resources.getResourceAsStream("SqlMapConfig.xml");
		//2.获取SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);;
		//3.获取SqlSession对象
		sqlSession = factory.openSession(true);
		//4.获取dao的代理对象
		accountDao=sqlSession.getMapper(AccountDao.class);
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
	 * 测试查询所有
	 */
	@Test
	public void testFindAll(){
		List<Account> accounts=accountDao.findAll();
		for (Account account : accounts) {
			System.out.println(account);
			System.out.println(account.getUser());
		}
	}

}
