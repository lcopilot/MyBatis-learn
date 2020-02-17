package com.itcast.dao.impl;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/9/15
 * @time: 22:25
 * @description:
 */
public class UserDaoImpl implements UserDao {
	private SqlSessionFactory factory;

	public UserDaoImpl(SqlSessionFactory factory){
		this.factory=factory;
	}

	public List<User> findAll() {
		//1.使用工厂创建SqlSession对象
		SqlSession session = factory.openSession();
		//2.使用session查询所有方法
		List<User> users = session.selectList("com.itcast.dao.UserDao.findAll");
		session.close();
		//3.返回查询结果
		return users;
	}
}
