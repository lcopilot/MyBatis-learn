package com.itcast.dao;

import com.itcast.domain.Account;
import com.itcast.domain.AccountUser;
import java.util.List;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/11
 * @time: 14:58
 * @description:
 */
public interface AccountDao {

	/**
	 * 查询所有账户,同时还要获取到当前账户的所属用户信息
	 * @return
	 */
	List<Account> findAll();

	/**
	 * 查询所有账户,并且带有用户名称和地址信息
	 * @return
	 */
	List<AccountUser> findAllAccount();
}
