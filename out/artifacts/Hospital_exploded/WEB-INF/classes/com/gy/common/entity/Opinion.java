package com.gy.common.entity;

import java.io.Serializable;

import com.gy.common.base.BaseBmob;

public class Opinion extends BaseBmob implements Serializable {

	private static final long serialVersionUID = 2222004223852402686L;
	private User admin;
	private String content;
	private String replay;
	private User user;

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReplay() {
		return replay;
	}

	public void setReplay(String replay) {
		this.replay = replay;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
