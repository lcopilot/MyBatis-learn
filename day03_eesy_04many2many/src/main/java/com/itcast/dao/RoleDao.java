package com.itcast.dao;

import com.itcast.domain.Role;
import java.util.List;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/11
 * @time: 16:32
 * @description:
 */
public interface RoleDao {

	/**
	 * 查询所有角色
	 * @return
	 */
	List<Role> findAll();
}
