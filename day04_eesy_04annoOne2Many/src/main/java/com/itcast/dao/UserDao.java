package com.itcast.dao;

import com.itcast.domain.User;
import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/14
 * @time: 17:25
 * @description: 在mybatis中针对, crud一共有四个注解
 * @Select @Insert @Update @Delete
 */
@CacheNamespace(blocking = true)
public interface UserDao {

	/**
	 * 查询所有用户
	 *
	 * @return
	 */
	@Select("select * from user")
	@Results(id = "userMap", value = {
			@Result(id = true, column = "id", property = "id"),
			@Result(column = "username", property = "name"),
			@Result(column = "address", property = "address"),
			@Result(column = "sex", property = "sex"),
			@Result(column = "birthday", property = "birthday"),
			@Result(property = "accounts", column = "id", many = @Many(select = "com.itcast.dao.AccountDao.findAccountByUid", fetchType = FetchType.LAZY))
	})
	List<User> findAll();

	/**
	 * 通过id查找一个用户
	 *
	 * @param userId
	 * @return
	 */
	@Select("select *from user where id=#{id}")
	@ResultMap(value = {"userMap"})
	//@ResultMap("userMap")
	User findById(Integer userId);

	/**
	 * 根据用户名模糊查询
	 *
	 * @param username
	 * @return
	 */
	@Select("select *from user where username like #{username} ")
	List<User> findUserByName(String username);


}
