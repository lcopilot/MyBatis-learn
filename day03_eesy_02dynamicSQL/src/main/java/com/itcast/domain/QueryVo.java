package com.itcast.domain;

import java.util.List;

/**
 * @program: frame
 * @auther: MuGe
 * @date: 2019/10/8
 * @time: 11:27
 * @description:
 */
public class QueryVo {
	private User user;
	private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
