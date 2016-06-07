/*
 * 文件名： DateUtil.java
 * 
 * 创建日期： 2009-3-19
 *
 * Copyright(C) 2009, by liupeng.
 *
 * 原始作者: <a href="mailto:liupeng@fetionyy.com.cn">liupeng</a>
 *
 */
package com.dev.cty.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期格式工具
 * 
 * @version $Revision: 20314 $
 * @since 2009-3-19
 */
public class DateUtil  {

	/** yyyyMMddHHmmss */
	public static final String DEFAULT_DATE_FORMAT = "yyyyMMddHHmmss";
	/** yyyy-MM-dd */
	public static final String DEFAULT_DATE_HYPHEN_FORMAT = "yyyy-MM-dd";
	/** yyyy-MM-dd HH:mm:ss */
	public static final String DEFAULT_DATETIME_HYPHEN_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** yyyyMMddHHmmssSSS000 */
	public static final String DEFAULT_DATE_FORMAT_MICROSEC = "yyyyMMddHHmmssSSS000";

	/**
	 * 微秒
	 */
	public static final String DEFAULT_DATE_FORMAT_MILL = "yyyyMMddHHmmssSSS";

	/**
	 * 得到当前时间的格式化
	 * 
	 * @param formatStr
	 * @return
	 */
	public static String getSystemCurrentDate() {
		return getSystemCurrentDate(DEFAULT_DATE_FORMAT);
	}

	/**
	 * 得到当前时间的格式化
	 * 
	 * @param formatStr
	 * @return
	 */
	public static String getSystemCurrentDateHY() {
		return getSystemCurrentDate(DEFAULT_DATE_HYPHEN_FORMAT);
	}

	/**
	 * 得到当前时间的格式化(精确到毫秒)
	 * 
	 * @param formatStr
	 * @return
	 */
	public static String getSystemCurrentDate_microSec() {
		return getSystemCurrentDate(DEFAULT_DATE_FORMAT_MICROSEC);
	}

	/**
	 * 计算给定时间字符串strDate的lms之前的微秒级的时间字符串。
	 * 
	 * @param l
	 * @return
	 * @author <a href="mailto:lemom8000@gmail.com">zhangyan</a>
	 * @throws ParseException
	 * @sinc 2009-7-15
	 */
	public static String getDateStrBeforeMS(String strDate, long l) throws ParseException {
		SimpleDateFormat sdformat = new SimpleDateFormat(DEFAULT_DATE_FORMAT_MILL);
		Date date = sdformat.parse(strDate);
		return getFormatDate(new Date(date.getTime() - l), DEFAULT_DATE_FORMAT_MICROSEC);
	}

	/**
	 * 得到当前时间的格式化
	 * 
	 * @param formatStr
	 * @return
	 */
	public static String getSystemCurrentDate(String formatStr) {
		Calendar calendar = Calendar.getInstance();
		return getFormatDate(calendar.getTime(), formatStr);
	}

	/**
	 * 将时间进行格式化
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormatDate(Date date, String format) {
		SimpleDateFormat sdformat = new SimpleDateFormat(format);
		return sdformat.format(date);
	}

	/**
	 * 把字符串转换为时间
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date str2Date(String dateStr) {
		return str2Date(dateStr, DEFAULT_DATE_FORMAT);
	}

	/**
	 * 把字符串转换为时间
	 * 
	 * @param dateStr
	 * @param formatStr
	 * @return
	 */
	public static Date str2Date(String dateStr, String formatStr) {
		if (dateStr == null || dateStr.isEmpty())
			return null;
		SimpleDateFormat sdformat = new SimpleDateFormat(formatStr);
		try {
			return sdformat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param nowSysDateTime
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws ParseException
	 * @author <a href="mailto:lemom8000@gmail.com">zhangyan</a>
	 * @sinc 2009-3-24
	 */
	public static boolean compareThreeDate(Date nowSysDateTime, Date startTime, Date endTime) {
		return nowSysDateTime.compareTo(startTime) >= 0 && nowSysDateTime.compareTo(endTime) <= 0;
	}

	/**
	 * 取得下个月的一号
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);// 日，设为一号
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
		return getFormatDate(cal.getTime(), DEFAULT_DATE_FORMAT);
	}

	/**
	 * 得到上一个月
	 * 
	 * @return
	 */
	public static String getLastMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		return getFormatDate(cal.getTime(), "yyyyMM");
	}

	/**
	 * 得到上一个月日期
	 * 
	 * @return
	 */
	public static String getLastMonthDay() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		return getFormatDate(cal.getTime(), DEFAULT_DATE_HYPHEN_FORMAT);
	}

	/**
	 * 将Date转换为字符串
	 * 
	 * @param aDate
	 * @param pattern 格式
	 * @return
	 */
	public static String date2Str(Date aDate, String pattern) {
		if (aDate == null)
			return null;
		if (pattern == null || pattern.trim().length() == 0)
			pattern = DEFAULT_DATETIME_HYPHEN_FORMAT;
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(aDate);
	}

	/**
	 * 将Date转换为字符串,默认格式 {@value #DEFAULT_DATETIME_HYPHEN_FORMAT}
	 * 
	 * @param aDate
	 * @return
	 */
	public static String date2Str(Date aDate) {
		return date2Str(aDate, null);
	}

	/**
	 * 得到上一个月
	 * 
	 * @return
	 */
	public static Calendar changeCalendar(String date) {
		Calendar cal = Calendar.getInstance();

		String[] arr = date.split("-");

		cal.set(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]), Integer.valueOf(arr[2]));
		return cal;
	}
	
	/**
	 * 
	 * 计算两个日期之间相差的天数
	 * 
	 * @param date1
	 * 
	 * @param date2
	 * 
	 * @return
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}


}
