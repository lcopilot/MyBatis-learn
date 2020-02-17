package com.itcast.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/15
 * @time: 9:39
 * @description:
 */
public class Account implements Serializable {

	private Integer id;
	private Integer uid;
	private Double money;

	//多对一(mybatis中称之为一对一)的映射:一个账户正属于一个用户
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", uid=" + uid +
				", money=" + money +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
}
