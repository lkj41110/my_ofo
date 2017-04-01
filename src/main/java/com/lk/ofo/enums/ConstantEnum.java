package com.lk.ofo.enums;

/**
 * 常量
 */
public enum ConstantEnum {
	// 分页的最小数目
	PAGE_LIMIT(15);
	
	//用户权限
	public static final int USER_GRADE_MAX_ADMIN=1;
	public static final int USER_GRADE_ADMIN=2;
	public static final int USER_GRADE_USER=3;
	
	//状态码
	public static final int ORDER_NOT_COMPLETE=1;//未完成
	public static final int ORDER_NOT_PAY=2;//未支付
	public static final int ORDER_COMPLETE=3;//完成
	
	
	private int msg;

	ConstantEnum(int msg) {
		this.msg = msg;
	}

	public int getMsg() {
		return msg;
	}
}
