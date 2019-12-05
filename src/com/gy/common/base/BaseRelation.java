package com.gy.common.base;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class BaseRelation<T> {

	private String __op;

	private List<T> objects;

	{
		__op = "AddRelation";
	}

	public BaseRelation(List<T> objects) {
		super();
		this.objects = objects;
	}

	public BaseRelation(String __op, List<T> objects) {
		super();
		this.__op = __op;
		this.objects = objects;
	}

	public BaseRelation() {
		super();
		// TODO 自动生成的构造函数存根
	}

	@JSONField(name = "__op")
	public String get__op() {
		return __op;
	}

	@JSONField(name = "__op")
	public void set__op(String __op) {
		this.__op = __op;
	}

	public List<T> getObjects() {
		return objects;
	}

	public void setObjects(List<T> objects) {
		this.objects = objects;
	}

}
