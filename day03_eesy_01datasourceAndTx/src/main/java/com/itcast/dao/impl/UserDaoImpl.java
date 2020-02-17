package com.itcast.dao.impl;

import com.itcast.dao.UserDao;
import com.itcast.domain.User;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/10
 * @time: 15:57
 * @description:
 */
public class UserDaoImpl implements UserDao {

	private SqlSessionFactory factory;

	public UserDaoImpl(SqlSessionFactory factory) {
		this.factory = factory;
	}

	public List<User> findAll() {
		//1.根据factory获取
		SqlSession session = factory.openSession();
		//2.调用SqlSession中的方法,实现查询列表
		List<User> users = session
				.selectList("com.itcast.dao.UserDao.findAll");//参数就是能获取配置文件的key
		//3.释放资源
		session.close();
		return users;
	}

	public void saveUser(User user) {
		//1.根据factory获取
		SqlSession session = factory.openSession();
		//2.调用SqlSession中的方法,实现保存
		session.insert("com.itcast.dao.UserDao.saveUser", user);//参数就是能获取配置文件的key
		//3.提交事务
		session.commit();
		//4.释放资源
		session.close();
	}

	public void updateUser(User user) {
		//1.根据factory获取
		SqlSession session = factory.openSession();
		//2.调用SqlSession中的方法,实现更新
		session.update("com.itcast.dao.UserDao.updateUser", user);//参数就是能获取配置文件的key
		//3.提交事务
		session.commit();
		//4.释放资源
		session.close();
	}

	public void deleteUser(Integer userId) {
		//1.根据factory获取
		SqlSession session = factory.openSession();
		//2.调用SqlSession中的方法,实现删除
		session.delete("com.itcast.dao.UserDao.deleteUser", userId);//参数就是能获取配置文件的key
		//3.提交事务
		session.commit();
		//4.释放资源
		session.close();
	}

	public User findById(Integer userId) {
		//1.根据factory获取
		SqlSession session = factory.openSession();
		//2.调用SqlSession中的方法,实现查询列表
		User user = session
				.selectOne("com.itcast.dao.UserDao.findById", userId);//参数就是能获取配置文件的key
		//3.释放资源
		session.close();
		return user;

	}

	public List<User> findByName(String username) {
		//1.根据factory获取
		SqlSession session = factory.openSession();
		//2.调用SqlSession中的方法,实现查询列表
		List<User> users = session
				.selectList("com.itcast.dao.UserDao.findByName",username);//参数就是能获取配置文件的key
		//3.释放资源
		session.close();
		return users;
	}

	public int findTotal() {
		//1.根据factory获取
		SqlSession session = factory.openSession();
		//2.调用SqlSession中的方法,实现查询列表
		Integer count = session
				.selectOne("com.itcast.dao.UserDao.findTotal");//参数就是能获取配置文件的key
		//3.释放资源
		session.close();
		return count;
	}
}
