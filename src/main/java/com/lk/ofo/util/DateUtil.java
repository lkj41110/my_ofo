package com.lk.ofo.util;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author fengxf
 * @since 2016-08-28
 */
public class DateUtil{


    public static final String DEFAULT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_HM = "yyyy-MM-dd HH:mm";

    public static final String DEFAULT_DATE = "yyyy-MM-dd";

    public static final String BD_DATE_FORMAT = "yyyy/MM/dd";
    public static final String BD_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm";

    public static final String SHORT_DATE = "MM-dd";

    public static final String DATE_FMT_MONTH_END = "yyyy-MM";
    public static final String CAR_LICENSE_DATE_FORMAT = "yyyy/MM";

    public static final long MILLS_OF_DAY = 3600L * 24L * 1000L;

    public static final long MILLS_OF_SECOND = 1000L;

    public static final int ONE_YEAR = 365; //一年的天数
    public static final int ONE_MOUNTH = 365; //一月的天数

//    public static final Integer[] WEEK_DAY = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
    public static final Integer[] WEEK_DAY = {0, 1, 2, 3, 4, 5, 6};


    public static Date parse(String input, String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        try {
            return sdf.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parse(String input) {
        return parse(input, DEFAULT_DATE_TIME);
    }

    public static Date parseMonthEnd(String input) {
        return parse(input, DATE_FMT_MONTH_END);
    }

    public static String format(Date date, String fmt) {
        try {
            if (date == null) {
                return "";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            return sdf.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static String formatToMonthEnd(Date date) {
        try {
            return format(date, DATE_FMT_MONTH_END);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 取一天中最大的时间的字符串描述
     *
     * @param date
     * @return
     */
    public static String ceilingToStr(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        return sm.format(date) + " 23:59:59";
    }

    /**
     * 取一天中最小的时间字符串描述
     *
     * @param date
     * @return
     */
    public static String floorToStr(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        return sm.format(date) + " 00:00:00";
    }

    /**
     * 计算天
     *
     * @param date
     * @param changeValue 正数为增加，负数为减去
     * @return
     */
    public static Date changeDay(Date date, int changeValue) {
        if (date == null || changeValue == 0) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, changeValue);
        return c.getTime();
    }

    /**
     * 判断目标时间 targetDate 距当前时间是否未在 days 天之内, 以天为单位
     *
     * @param targetDate
     * @param days
     * @return
     */
    public static boolean isInDaysFromNow(Date targetDate, int days) {
        long currentDateMills = new Date().getTime();
        long durationDay = (currentDateMills - targetDate.getTime()) / MILLS_OF_DAY;
        return durationDay <= days;
    }

    /**
     * 获取当天往前后往后几天的几点整的时间
     *
     * @param addDate
     * @param hour
     * @return
     */
    public static Date getAfterDate(int addDate, int hour) {
        Date currentDate = new Date();
        Date date = DateUtils.addDays(currentDate, addDate);
        date = DateUtils.setHours(date, hour);
        date = DateUtils.setMinutes(date, 0);
        date = DateUtils.setSeconds(date, 0);
        date = DateUtils.setMilliseconds(date, 0);
        return date;
    }

    /**
     * 获取当天往前后往后几年的0点时间
     *
     * @param
     * @return
     */
    public static Date getAfterYear(int addYear) {
        Date currentDate = new Date();
        Date date = DateUtils.addYears(currentDate, addYear);
        date = DateUtils.setHours(date, 0);
        date = DateUtils.setMinutes(date, 0);
        date = DateUtils.setSeconds(date, 0);
        date = DateUtils.setMilliseconds(date, 0);
        return date;
    }

    /**
     * 获取某天往前后往后几天的几点整的时间
     *
     * @param currentDate
     * @param addDate
     * @param hour
     * @return
     */
    public static Date getAfterDate(Date currentDate, int addDate, int hour) {
        Date date = DateUtils.addDays(currentDate, addDate);
        date = DateUtils.setHours(date, hour);
        date = DateUtils.setMinutes(date, 0);
        date = DateUtils.setSeconds(date, 0);
        date = DateUtils.setMilliseconds(date, 0);
        return date;
    }


    /**
     * 模糊计算两个日期相差天数
     *
     * @param fDate
     * @param oDate
     * @return
     */
    public static int dateSubtract(Date fDate, Date oDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fDate);
        int startDay = aCalendar.get(Calendar.DAY_OF_YEAR);
        int startYear = aCalendar.get(Calendar.YEAR);
        aCalendar.setTime(oDate);
        int endDay = aCalendar.get(Calendar.DAY_OF_YEAR);
        int endyear = aCalendar.get(Calendar.YEAR);

        return (endyear - startYear) * ONE_YEAR + (endDay - startDay);

    }
    public static int dateSubtractOfMin(Date fDate, Date oDate) {
        long between=(oDate.getTime()-fDate.getTime())/1000;//除以1000是为了转换成秒
        int min=(int)(between/60);
        return min;
    }

    /**
     * 判断目标时间戳 距当前时间是否超过 seconds 秒
     *
     * @param timestamp 这里的单位为毫秒,不是 Unix 时间戳
     * @param seconds
     * @return
     */
    public static boolean isExceedCurrentBySeconds(long timestamp, int seconds) {
        long currentDateMills = new Date().getTime();
        return ((currentDateMills - timestamp) > (seconds * MILLS_OF_SECOND));
    }

    public static Date now() {
        return new Date();
    }

    /**
     * 取得星期名称
     *
     * @param date
     * @return
     */
    public static Integer getWeekday(Date date) {
        try {
            Integer w = getWeekdayNumber(date);
            return WEEK_DAY[w];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 取得星期数
     *
     * @param date
     * @return
     */
    public static Integer getWeekdayNumber(Date date) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            Integer w = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if (w < 0) {
                w = 0;
            }
            return w;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer getMonthNumber(Date date){
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            Integer w = cal.get(Calendar.MONTH);
            return w;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
