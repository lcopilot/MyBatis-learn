package com.itcast.domain;

import java.io.Serializable;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/11
 * @time: 14:56
 * @description:
 */
public class Account implements Serializable {
	private Integer id;
	private Integer uid;
	private double money ;

	//从表实体应该包含一个主表实体的对象引用
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}



}
