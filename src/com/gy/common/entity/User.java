package com.gy.common.entity;

import java.io.Serializable;

/**
 * Copyright 2018 bejson.com 
 */

import com.alibaba.fastjson.JSONObject;
import com.gy.common.base.BaseBmob;

/**
 * Auto-generated: 2018-11-28 11:8:24
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class User extends BaseBmob implements Serializable {

	private static final long serialVersionUID = -3557885682189847519L;
	private String auto;
	private String headerPic;
	private String identity;
	private String nickname;
	private String pass;
	private String sessionToken;
	private Integer sex;
	private String username;
	private Integer plate;
	private Hospital hospital;
	private Department department;
	private String password;

	public User() {
		super();
	}

	public User(String __type, String objectId) {
		super();
		this.set__type(__type);
		this.setObjectId(objectId);

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public String getHeaderPic() {
		return headerPic;
	}

	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPlate() {
		return plate;
	}

	public void setPlate(Integer plate) {
		this.plate = plate;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}

}
