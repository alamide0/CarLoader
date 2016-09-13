package com.car.util;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatUtil {
	private DateFormatUtil(){
		
	}
	
	public static String getTime(long date){
		Date d = new java.sql.Date(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//System.out.println("--"+format.format(d));
		//format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return format.format(d);
	}
	
}
