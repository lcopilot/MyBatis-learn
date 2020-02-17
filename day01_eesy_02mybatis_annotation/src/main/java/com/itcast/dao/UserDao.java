package com.itcast.dao;

import com.itcast.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/9/15
 * @time: 14:59
 * @description: 用户持久层接口
 */
public interface UserDao {

	/**
	 * 查询所有操作
	 * @return
	 */
	@Select("SELECT*FROM user")
	List<User> findAll();
}
