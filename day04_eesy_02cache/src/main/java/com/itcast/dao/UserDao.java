package com.itcast.dao;

import com.itcast.domain.User;
import java.util.List;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/9/25
 * @time: 14:00
 * @description:	用户持久层接口
 */
public interface UserDao {

	/**
	 * 查询所有用户,同时获取到用户下所有账户的信息
	 * @return
	 */
	List<User> findAll();

	/**
	 * 根据id查询用户
	 * @param userId
	 */
	User findById(Integer userId);

	/**
	 * 更新用户信息
	 * @param user
	 */
	void updateUser(User user);
}
