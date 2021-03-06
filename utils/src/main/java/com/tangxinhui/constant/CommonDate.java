package com.tangxinhui.constant;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期类
 */
public class CommonDate {

    public static final String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    public static final String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH)+1);
    public static final String day = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    public static final String hour_24 = String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
    public static final String hour_12 = String.valueOf(Calendar.getInstance().get(Calendar.HOUR));
    public static final String minute = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
    public static final String second = String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
    public static final String week_of_year = String.valueOf(Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
    public static final String week_of_month = String.valueOf(Calendar.getInstance().get(Calendar.WEEK_OF_MONTH));
    public static final String day_of_year = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
    public static final String day_of_month = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    public static final String day_of_week = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));

    /**
     * 获取当前时间
     * @return 当前时间,24小时yyyy-MM-dd HH:mm:ss格式
     */
    public static String getTime24(){
        Date date = new Date();
        SimpleDateFormat timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = timeStamp.format(date);
        return time;
    }

    /**
     * 获取当前时间的时间戳
     * @return Unix时间戳
     */
    public static Long getStamp(){
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 将Unix时间戳转换为日期时间
     * @param timeStamp Unix时间戳
     * @return 日期时间yyyy-MM-dd HH:mm:ss
     */
    public static String stamp2Time(long timeStamp){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timeStamp * 1000));
    }

    /**
     * 计算年龄
     * @param year 出生年份
     * @return 年龄
     */
    public static int getAge(int year){
        return Integer.parseInt(CommonDate.year) - year;
    }
}
