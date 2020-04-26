package ems.logfile.handler;

import java.io.File;
import java.io.FileWriter;

public class ExceptionPrinter {
	FileWriter fw=null;
	public void doEntry(String s)
	{
		File f=new File("log");
		if(!f.isDirectory())
		{
			f.mkdir();
		}
		try {
		fw=new FileWriter("log/Exception.log", true);
		fw.write(s);
		fw.flush();
		fw.close();
		}catch(Exception e)
		{
			e.printStackTrace();
			try{fw.flush();fw.close();}
			catch(Exception ex) {}
		}
		
	
	}

}
