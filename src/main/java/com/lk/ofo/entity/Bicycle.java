package com.lk.ofo.entity;

/**
 * 自行车
 * @author lkj41110
 * @version time：2017年3月11日 下午9:38:56
 */
public class Bicycle extends Basis{
	private int id;
	private double addressX;
	private double addressY;
	private String password;
	private String status;//状态1.正在使用  2.出现故障  3.停止使用  4.还未使用
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getAddressX() {
		return addressX;
	}
	public void setAddressX(double addressX) {
		this.addressX = addressX;
	}
	public double getAddressY() {
		return addressY;
	}
	public void setAddressY(double addressY) {
		this.addressY = addressY;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Bicycle [id=" + id + ", addressX=" + addressX + ", addressY=" + addressY + ", password=" + password
				+ "]";
	}
	
	
}
