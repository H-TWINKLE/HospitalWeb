package com.gy.common.entity;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.gy.common.base.BaseBmob;

public class Post extends BaseBmob implements Serializable {

	private static final long serialVersionUID = 2170097004780391473L;
	private User author;
	private String content;
	private String title;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

}
