package com.lk.ofo.entity;

import java.util.Date;
/**
 * @author lkj41110
 * @version time：2017年3月30日 下午9:06:11
 */
public class Order extends Basis{
	private int id;
	private int userId;
	private int bicycleId;
	private Date startTime;
	private Date endTime;
	private double cost;
	private String start_X;
	private String start_y;
	private String end_X;
	private String end_y;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBicycleId() {
		return bicycleId;
	}
	public void setBicycleId(int bicycleId) {
		this.bicycleId = bicycleId;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getStart_X() {
		return start_X;
	}
	public void setStart_X(String start_X) {
		this.start_X = start_X;
	}
	public String getStart_y() {
		return start_y;
	}
	public void setStart_y(String start_y) {
		this.start_y = start_y;
	}
	public String getEnd_X() {
		return end_X;
	}
	public void setEnd_X(String end_X) {
		this.end_X = end_X;
	}
	public String getEnd_y() {
		return end_y;
	}
	public void setEnd_y(String end_y) {
		this.end_y = end_y;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", bicycleId=" + bicycleId + ", status=" + status + "]";
	}
	
	
}
