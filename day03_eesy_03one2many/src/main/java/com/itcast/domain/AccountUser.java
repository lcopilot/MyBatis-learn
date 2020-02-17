package com.itcast.domain;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/11
 * @time: 15:21
 * @description:
 */
public class AccountUser extends Account{
	private String username;
	private String address;

	@Override
	public String toString() {
		return super.toString()+"       AccoutUser{" +
				"username='" + username + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
