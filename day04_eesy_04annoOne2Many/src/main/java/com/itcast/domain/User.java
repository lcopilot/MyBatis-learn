package com.itcast.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/14
 * @time: 17:16
 * @description:
 */
public class User implements Serializable {

	private Integer id;
	private String name;
	private String address;
	private String sex;
	private Date birthday;

	//一对多关系映射:一个用户对应多个账户
	private List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", sex='" + sex + '\'' +
				", birthday=" + birthday +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
