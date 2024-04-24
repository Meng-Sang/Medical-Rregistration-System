package com.sangmeng.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
	/**
	 * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014-06-14-16-09-00"）
	 * @param time
	 * @return
	 */
	public static String timesOne(String time) {
		SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		@SuppressWarnings("unused")
		long lcc = Long.valueOf(time);
//		int i = Integer.parseInt(time);
		String times = sdr.format(new Date(lcc));
		return times;
 
	}
	/**
	 * 获取当前时间
	 * @return
	 */
	public static String getCurrentTime_Today() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
 
	/**
	 * 调此方法输入所要转换的时间输入例如（"2014-06-14-16-09-00"）返回时间戳
	 * @param time
	 * @return
	 */
	public static String dataOne(String time) {
		SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.CHINA);
		Date date;
		String times = null;
		try {
			date = sdr.parse(time);
			long l = date.getTime();
			String stf = String.valueOf(l);
			times = stf.substring(0, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return times;
	}

	

}
