package ems.DaoServices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import ems.functions.DateTime;
import ems.services.MsgService;

public class MsgDao implements MsgService {
	private static final String PATH="msg";
	JsonObject Jobj1,Jobj2;
	JsonWriter jsw;
	FileWriter out;
	JsonReader jsr;
	
	
	public void initialize(int empid) {
		try {
		File fol=new File(PATH);
		File file=new File(PATH+"/msg"+empid+".json");
		if(!fol.isDirectory()) {fol.mkdir();}
		if(!file.exists()) {
			file.createNewFile();
			System.out.println("filecreated");
		}
		file=null;
		fol=null;
		}catch(Exception e) {
			e.printStackTrace();
			}

	}
	public void sendMessage(int empid,int toid,String msg) {
		
	initialize(empid);
	initialize(toid);
	Jobj1=new JsonObject();
	Jobj1.addProperty("to", toid);
	Jobj1.addProperty("msg", msg);
	Jobj1.addProperty("date", DateTime.getCurrentDate());
	Jobj1.addProperty("time", DateTime.getCurrentTime());
	Jobj1.addProperty("seen", false);
	
	Jobj2=new JsonObject();
	Jobj2.addProperty("from", empid);
	Jobj2.addProperty("msg", msg);
	Jobj2.addProperty("date", DateTime.getCurrentDate());
	Jobj2.addProperty("time", DateTime.getCurrentTime());

	File file1=new File(PATH+"/msg"+empid+".json");
	File file2=new File(PATH+"/msg"+toid+".json");
	if(saveChat(Jobj1,file1)) {
		if(saveChat(Jobj2,file2)) {
			System.out.println("message sent");
			file2=null;
		}
		file1=null;
	}
	}
public String getMessages(int empid) {
	try {
	BufferedReader read=new BufferedReader(new FileReader(PATH+"/msg"+empid+".json"));
	String s=read.readLine();
	read.close();
	return s;
	}catch(Exception FileNotFoundException) {
		System.out.println("file not found");
		return null;
	}
}

public boolean saveChat(JsonObject obj,File file) {
	try {
		out=new FileWriter(file,true);
		jsw=new JsonWriter(out);
		jsw.jsonValue(obj.toString()+",");
		out.flush();
		out.close();
		jsw.close();
		obj=null;
return true;	}catch(Exception e) {e.printStackTrace();obj=null;return false;}
}
public JsonArray getChat(int empid) {
	try {
	File file=new File("msg/msg"+empid+".json");
	Reader read=new FileReader(file);
	JsonReader js=new JsonReader(read);
	JsonParser jp=new JsonParser();
	JsonElement jele=jp.parse(js);
	JsonArray arr=jele.getAsJsonArray();
	return arr;

	}catch(FileNotFoundException e) {e.printStackTrace();return null;}
}
}
