package com.lk.ofo.entity;

import java.util.Date;

public class Basis {
	private Date createTime;
	private Date delTime;
	private Date updateTime;
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getDelTime() {
		return delTime;
	}
	public void setDelTime(Date delTime) {
		this.delTime = delTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Basis() {
	}

	public Basis(Date createTime, Date delTime, Date updateTime) {
		this.createTime = createTime;
		this.delTime = delTime;
		this.updateTime = updateTime;
	}
}
