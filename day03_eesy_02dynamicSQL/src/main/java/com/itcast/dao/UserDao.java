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
	 * 根据queryVo中的条件查询用户
	 * @param vo
	 * @return
	 */
	List<User> findUserByVo(QueryVo vo);

	/**
	 * 根据传入的参数条件查询
	 * @param user 查询条件:用户名,性别,地址,
	 * @return
	 */
	List<User> findUserByCondition(User user);

	/**
	 * 根据queryvo中提供的id集合,查询用户信息
	 * @param vo
	 * @return
	 */
	List<User> findUserInIds(QueryVo vo);
}
