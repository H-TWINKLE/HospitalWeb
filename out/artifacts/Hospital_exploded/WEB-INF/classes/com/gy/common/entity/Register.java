package com.gy.common.entity;

import java.io.Serializable;

import com.gy.common.base.BaseBmob;

public class Register extends BaseBmob implements Serializable {

	private static final long serialVersionUID = 4909772711779265408L;

	private Department department;
	private String progress;
	private User user;
	private Integer view;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

}
