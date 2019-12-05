package com.gy.common.entity;

import java.io.Serializable;

import com.gy.common.base.BaseBmob;

public class Seek extends BaseBmob implements Serializable {

	private static final long serialVersionUID = 4299343949196514154L;
	private String content;
	private User doctor;
	private String eval;
	private String progress;
	private String replay;
	private User user;
	private Integer view;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public String getEval() {
		return eval;
	}

	public void setEval(String eval) {
		this.eval = eval;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
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

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

}
