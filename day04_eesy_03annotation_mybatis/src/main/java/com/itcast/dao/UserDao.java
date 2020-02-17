package com.itcast.dao;

import com.itcast.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/14
 * @time: 17:25
 * @description:
 * 在mybatis中针对,crud一共有四个注解
 * @Select @Insert @Update @Delete
 */
public interface UserDao {

	/**
	 * 查询所有用户
	 * @return
	 */
	@Select("select * from user")
	List<User> findAll();

	/**
	 * 保存用户
	 * @param user
	 */
	@Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
	void saveUser(User user);

	/**
	 * 更新用户
	 * @param user
	 */
	@Update("update user set username=#{username},sex=#{sex},address=#{address},birthday=#{birthday} where id=#{id}")
	void updateUser(User user);

	/**
	 * 删除用户
	 * @param userId
	 */
	@Delete("delete from user where id=#{id}")
	void deleteUser(Integer userId);

	/**
	 * 通过id查找一个用户
	 * @param userId
	 * @return
	 */
	@Select("select *from user where id=#{id}")
	User findById(Integer userId);

	/**
	 * 根据用户名模糊查询
	 * @param username
	 * @return
	 */
	//@Select("select *from user where username like #{username} ")
	@Select("select *from user where username like '%${value}%' ")
	List<User> findUserByName(String username);

	/**
	 * 查询总用户数量
	 * @return
	 */
	@Select("select count(*) from user")
	int findTotalUser();


}
