package com.itcast.dao;

import com.itcast.domain.QueryVo;
import com.itcast.domain.User;
import java.util.List;
import javax.management.Query;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/9/25
 * @time: 14:00
 * @description:	用户持久层接口
 */
public interface UserDao {

	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> findAll();

	/**
	 * 保存用户
	 * @param user
	 */
	void saveUser(User user);

	/**
	 * 更新用户
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 根据Id删除用户
	 * @param userId
	 */
	void deleteUser(Integer userId);

	/**
	 * 根据id查询用户
	 * @param userId
	 */
	User findById(Integer userId);

	/**
	 * 根据用户名模糊查询用户信息
	 * @param username
	 * @return
	 */
	List<User> findByName(String username);

	/**
	 * 查询总用户数
	 * @return
	 */
	int findTotal();

	/**
	 * 根据queryVo中的条件查询用户
	 * @param vo
	 * @return
	 */
	List<User> findUserByVo(QueryVo vo);



}
