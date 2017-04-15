package com.lk.ofo.entity.vo;

import com.lk.ofo.entity.Basis;

import java.util.Date;

/**
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class UserVO extends Basis{
	private int id;
	private String photo;
	private String sex;
	private String name;
	private String hobby;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
