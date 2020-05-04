package ems.functions;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import ems.logger.Emslogger;

public class FileCreater {
public static boolean checkDir(String path) {
	try {
	File file=new File(path);
	if(!file.exists()) {
		file.mkdir();
		Emslogger.info("new dir created.PATH="+path);
		return true;
	}
	else
		return true;
}catch(Exception e) {
	e.printStackTrace();
	Emslogger.error("error creating Dir.PATH="+path+e.getMessage());
	return false;
	}
}
public static boolean moveFile(String path,byte[] b) {
	try {
	BufferedOutputStream dos=new BufferedOutputStream(new FileOutputStream(path));
	dos.write(b);
	dos.flush();
	dos.close();
	return true;
	}catch(Exception e) {e.printStackTrace();return false;}
}
public static File getFile(String path) {
	File file=new File(path);
	return file;
}
}