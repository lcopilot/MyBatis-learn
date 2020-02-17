package com.itcast.dao;

import com.itcast.domain.Account;
import java.util.List;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/15
 * @time: 9:40
 * @description:
 */
public interface AccountDao {

	/**
	 * 查询所有账户,并且获取每个账户所属的用户信息
	 * @return
	 */
	@Select("select * from account")
	@Results(id="accountMap",value = {
			@Result(id = true,column = "id",property = "id"),
			@Result(column = "uid",property = "uid"),
			@Result(column = "money",property = "money"),
			@Result(column = "uid",property = "user",one=@One(select="com.itcast.dao.UserDao.findById",fetchType= FetchType.EAGER)),
	})
	List<Account> findAll();

	/**
	 * 根据用户id查询账户信息
	 * @param userId
	 * @return
	 */
	@Select("select *from account where uid=#{userId}")
	List<Account> findAccountByUid(Integer userId);
}
