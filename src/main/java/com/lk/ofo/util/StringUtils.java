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

    /**
     * 检验是否为空
     */
    public static boolean isEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }

    /**
     * 检验是否为电话号码
     */
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

    /**
     * 坐标检验 在杭州
     */
    public static boolean isInHangZHou(Double x, Double y) {
        if (y >= 118.35 && y < 120.5 && x > 29.183 && x < 31.55)
            return true;
        return false;
    }

    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if(str == null) {
            return false;
        } else {
            int length = str.length();

            for(int i = 0; i < length; ++i) {
                if(!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 判断是否为double类型
     * @param str
     * @return
     */
    public static boolean isDouble(String str){
        try{
            double b = Double.parseDouble(str);
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }
}
