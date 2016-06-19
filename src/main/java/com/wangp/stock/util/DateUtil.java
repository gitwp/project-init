package com.wangp.stock.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {

	public final static String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";
	public final static String DATE_FORMAT_SOLIDUS = "yyyy/MM/dd";
	public final static String DATE_FORMAT_COMPACT = "yyyyMMdd";
	public final static String DATE_FORMAT_UTC_DEFAULT = "MM-dd-yyyy";
	public final static String DATE_FORMAT_UTC_SOLIDUS = "MM/dd/yyyy";
	public final static String DATE_FORMAT_TAODA_DIRECTORY = "yyyyMMdd HHmmss";
	public final static String DATE_FORMAT_TAODA_DIRECTORY_T = "yyyyMMddHHmmss";

	public final static String DATE_FORMAT_CHINESE = "yyyy年MM月dd日";
	public final static String DATE_TIME_FORMAT_COMPACT = "yyyyMMdd hhmmss";
	public final static String DATE_TIME_FORMAT_CHINESE = "yyyy年MM月dd日 HH时mm分ss秒";

	public final static String DATE_TIME_FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public final static String DATE_TIME_FORMAT_SOLIDUS = "yyyy/MM/dd HH:mm:ss";
	public final static String DATE_TIME_FORMAT_UTC_DEFAULT = "MM-dd-yyyy HH:mm:ss";
	public final static String DATE_TIME_FORMAT_UTC_SOLIDUS = "MM/dd/yyyy HH:mm:ss";

	private static Map<String, String> dateFormatRegisterMap = new HashMap<String, String>();
	private static Map<String, SimpleDateFormat> dateFormatMap = new HashMap<String, SimpleDateFormat>();

	static {
		// 各种日期格式注册，有新需要请在此处添加 ，无需其它改动
		dateFormatRegisterMap.put(DATE_FORMAT_COMPACT, "^\\d{8}$");
		dateFormatRegisterMap.put(DATE_FORMAT_DEFAULT,
				"^\\d{4}-\\d{1,2}-\\d{1,2}$");
		dateFormatRegisterMap.put(DATE_FORMAT_SOLIDUS,
				"^\\d{4}/\\d{1,2}/\\d{1,2}$");
		dateFormatRegisterMap.put(DATE_FORMAT_UTC_DEFAULT,
				"^\\d{1,2}-\\d{1,2}-\\d{4}$");
		dateFormatRegisterMap.put(DATE_FORMAT_UTC_SOLIDUS,
				"^\\d{1,2}/\\d{1,2}/\\d{4}$");
		dateFormatRegisterMap.put(DATE_TIME_FORMAT_DEFAULT,
				"^\\d{4}-\\d{1,2}-\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}$");
		dateFormatRegisterMap.put(DATE_TIME_FORMAT_SOLIDUS,
				"^\\d{4}/\\d{1,2}/\\d{1,2}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}$");
		dateFormatRegisterMap.put(DATE_TIME_FORMAT_UTC_DEFAULT,
				"^\\d{1,2}-\\d{1,2}-\\d{4}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}$");
		dateFormatRegisterMap.put(DATE_TIME_FORMAT_UTC_SOLIDUS,
				"^\\d{1,2}/\\d{1,2}/\\d{4}\\s*\\d{1,2}:\\d{1,2}:\\d{1,2}$");

		dateFormatMap.put(DATE_FORMAT_DEFAULT, new SimpleDateFormat(
				DATE_FORMAT_DEFAULT));
		dateFormatMap.put(DATE_FORMAT_SOLIDUS, new SimpleDateFormat(
				DATE_FORMAT_SOLIDUS));
		dateFormatMap.put(DATE_FORMAT_COMPACT, new SimpleDateFormat(
				DATE_FORMAT_COMPACT));
		dateFormatMap.put(DATE_FORMAT_UTC_DEFAULT, new SimpleDateFormat(
				DATE_FORMAT_UTC_DEFAULT));
		dateFormatMap.put(DATE_FORMAT_UTC_SOLIDUS, new SimpleDateFormat(
				DATE_FORMAT_UTC_SOLIDUS));
		dateFormatMap.put(DATE_TIME_FORMAT_DEFAULT, new SimpleDateFormat(
				DATE_TIME_FORMAT_DEFAULT));
		dateFormatMap.put(DATE_TIME_FORMAT_SOLIDUS, new SimpleDateFormat(
				DATE_TIME_FORMAT_SOLIDUS));
		dateFormatMap.put(DATE_TIME_FORMAT_UTC_DEFAULT, new SimpleDateFormat(
				DATE_TIME_FORMAT_UTC_DEFAULT));
		dateFormatMap.put(DATE_TIME_FORMAT_UTC_SOLIDUS, new SimpleDateFormat(
				DATE_TIME_FORMAT_UTC_SOLIDUS));
	}

	public static String getNowDate(String format) {
		return formatDate(new Date(), format);
	}

	public static String formatDate(Date date, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(date);
	}

	public static String format(String formatString, Date date) {
		return new SimpleDateFormat(formatString).format(date);
	}
	
	public static String formatDateStr(String dateStr, String formatFrom, String formatTo) {
		Date date = parseStrToDate(formatFrom,dateStr);
		return new SimpleDateFormat(formatTo).format(date);
	}

	public static Date parse(String formatString, String dateString) {
		try {
			return new SimpleDateFormat(formatString).parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static Date parseStrToDate(String formatString, String dateString) {
		try {
			return new SimpleDateFormat(formatString).parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static long parseDateToLong(String date) {
		date = date.replace("-", "");
		Long result = Long.valueOf(date);
		return result;
	}

	public static String formatDate(String date, String format, String newFormat)
			throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		Date d = sf.parse(date);
		sf = new SimpleDateFormat(newFormat);
		return sf.format(d);
	}

	public static Date add(Date date, int n, int calendarField) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, n);

		return c.getTime();
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param sdate
	 *            较小的时间
	 * @param edate
	 *            较大的时间
	 * @return 相差天数
	 * @throws Exception
	 */
	public static int daysBetween(Date sdate, Date edate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DEFAULT);
		sdate = sdf.parse(sdf.format(sdate));
		edate = sdf.parse(sdf.format(edate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(edate);
		long time2 = cal.getTimeInMillis();
		long betweenDays = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(betweenDays));
	}

	
	public static Date calMonth(Date date, String format, int n) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		return parseStrToDate(format, sdf.format(calendar.getTime()));
	}
	
	public static Date calWeek(Date date, String format, int n) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.WEDNESDAY, n);
		return parseStrToDate(format, sdf.format(calendar.getTime()));
	}
	public static Date getCurrNightDate(){
		 Calendar cal = Calendar.getInstance();
         cal.set(Calendar.MINUTE, 0);
         cal.set(Calendar.HOUR, 0);
         cal.set(Calendar.SECOND, 0);
         return cal.getTime();
	}
	public static Date getStartOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	public static Date getEndOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}
	public static void main(String[] args) {
		Date today=getCurrNightDate();
		Date yes=DateUtil.add(today, 1, Calendar.WEEK_OF_MONTH);
		System.out.println(yes);
	}
}
