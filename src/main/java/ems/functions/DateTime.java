package ems.functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime { 
	  private static LocalDateTime now;
public static String getCurrentTime()
{
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss"); 
	   now = LocalDateTime.now();  
	   return dtf.format(now);
}
public static String getCurrentDate()
{
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
	   now = LocalDateTime.now();  
	   return dtf.format(now);
}
public static String getYear() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");  
	   now = LocalDateTime.now(); 
	   return dtf.format(now);
}
public static String getMonth() {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");  
   now = LocalDateTime.now();  
   return dtf.format(now);
}
public static String getDay() {

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");  
   now = LocalDateTime.now();  
   return dtf.format(now);
}
public static String getHour() {
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH");
	now=LocalDateTime.now();
	return dtf.format(now);
}public static String getMin() {
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("mm");
	now=LocalDateTime.now();
	return dtf.format(now);
}public static String getSec() {
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("ss");
	now=LocalDateTime.now();
	return dtf.format(now);
}
}
