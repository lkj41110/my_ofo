package com.lk.ofo.enums;

/**
 * chang'lian
 */
public enum ConstantEnum {
	PAGE_LIMIT(15);
	
	
	public static final int USER_GRADE_MAX_ADMIN=1;
	public static final int USER_GRADE_ADMIN=2;
	public static final int USER_GRADE_USER=3;
	
	// 分页的最小数目
	private int msg;

	ConstantEnum(int msg) {
		this.msg = msg;
	}

	public int getMsg() {
		return msg;
	}
}
