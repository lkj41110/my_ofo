package com.lk.ofo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * @author lkj41110
 * @version time：2017年3月28日 下午10:39:41
 */
public class StringUtils {

	/** 检验是否为空 */
	public static boolean isEmpty(String s) {
		return s == null || s.trim().length() == 0;
	}

	/** 检验是否为电话号码 */
	public static boolean isPhone(String phone) {
		if (isEmpty(phone)) {
			return false;
		} else {
			try {
				Pattern p = null;
				Matcher m = null;
				boolean b = false;
				p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
				m = p.matcher(phone);
				b = m.matches();
				return b;
			} catch (Exception var1) {
				return false;
			}
		}
	}

	/** 坐标检验 在杭州 */
	public static boolean isInHangZHou(Double x, Double y) {
		if (x >= 118.35 && x < 120.5 && y > 29.183 && y < 20.55)
			return true;
		return false;
	}

}
