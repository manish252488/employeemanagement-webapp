package ems.logfile.handler;

import java.io.File;
import java.io.FileWriter;


public class Databaselog {

	FileWriter fw=null;
	public void doEntry(String s)
	{
		File f=new File("log");
		if(!f.isDirectory())
		{
			f.mkdir();
		}
		try {
		fw=new FileWriter("log/database.log", true);
		fw.write(s);
		fw.flush();
		fw.close();
		}catch(Exception e)
		{
			new ExceptionPrinter().doEntry("databaselog:"+e);
	
		}
		
	
	}
	
	
//	public static void main(String args[])throws Exception
//	{
//		new Databaselog().doEntry("hello");
//	}
//	
}
