package com.gy.common.entity;

import java.io.Serializable;

import com.gy.common.base.BaseBmob;

public class Eval extends BaseBmob implements Serializable {

	private static final long serialVersionUID = -8721078244285278342L;
	private User author;
	private String content;
	private User doctor;
	private int hot;
	private int score;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

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

	public int getHot() {
		return hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
