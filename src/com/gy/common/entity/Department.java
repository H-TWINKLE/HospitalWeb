package com.gy.common.entity;

import java.io.Serializable;

import com.gy.common.base.BaseBmob;

public class Department extends BaseBmob implements Serializable {

	private static final long serialVersionUID = -6385694482464929758L;
	private String auto;
	private User doctor;
	private Hospital hospital;
	private Integer hot;
	private String name;
	private String place;

	public Department() {
		super();
	}

	public Department(String __type, String objectId) {
		super();
		this.set__type(__type);
		this.setObjectId(objectId);

	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getAuto() {
		return this.auto;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public User getDoctor() {
		return this.doctor;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Integer getHot() {
		return this.hot;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPlace() {
		return this.place;
	}

}
