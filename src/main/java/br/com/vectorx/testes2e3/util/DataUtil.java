package br.com.vectorx.testes2e3.util;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public final class DataUtil {
	
	public static final String FORMATO_ISO8601RECEBIDO = "yyyy-MM-ddTHH24:mm:ss";
	public static final String FORMATO_ISO8601 = "yyyy-MM-dd'T'HH24:mm:ss";
	
	
	public static final DateTime formataDataISOtoDateTime(String data){
		DateTimeFormatter dtf = DateTimeFormat.forPattern(FORMATO_ISO8601);
		return dtf.parseDateTime(data);
	}
	
	public static final Calendar datetoCalendar(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
}
