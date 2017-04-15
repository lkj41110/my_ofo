package com.lk.ofo.entity;

import java.util.Date;

/**
 * 用户资料表
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class User2 extends Basis{
	private int id;
	private String photo;
	private String sex;
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

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "User2{" +
				"id=" + id +
				", photo='" + photo + '\'' +
				", sex='" + sex + '\'' +
				", hobby='" + hobby + '\'' +
				'}';
	}
}
