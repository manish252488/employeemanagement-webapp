package ems.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Emslogger{
	private static Logger logger;
	static {System.out.println("logger working");}
	
public static void warn(String msg) {
	try {
	logger=LogManager.getLogger("WarnLogger");
	logger.warn(msg);
	}catch(Exception e) {e.printStackTrace();}
}
public static void fatal(String msg) {
	try {
	logger=LogManager.getLogger("FatalLogger");
	logger.fatal(msg);
}catch(Exception e) {e.printStackTrace();}
	
}
public static void error(String msg) {
	try {
	logger=LogManager.getLogger("ErrorLogger");
	logger.error(msg);
}catch(Exception e) {e.printStackTrace();}
	
}
public static void info(String msg) {
	try {
	logger=LogManager.getLogger("InfoLogger");
	logger.info(msg);
}catch(Exception e) {e.printStackTrace();}
	
}
public static void debug(String msg) {
	try {
	logger=LogManager.getLogger("DebugLogger");
	logger.debug(msg);
}catch(Exception e) {e.printStackTrace();}
}
}
