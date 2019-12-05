package com.gy.common.entity;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.gy.common.base.BaseBmob;

public class Hospital extends BaseBmob implements Serializable {

	private static final long serialVersionUID = 7323589509441597328L;

	private String auto;
	private String name;
	private String pic;
	private String place;
	private List<User> doctor;
	private List<Department> department;

	public Hospital() {
		super();
	}

	public Hospital(String __type, String objectId) {
		super();
		this.set__type(__type);
		this.setObjectId(objectId);

	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public List<User> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<User> doctor) {
		this.doctor = doctor;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return JSONObject.toJSONString(this);
	}

}
