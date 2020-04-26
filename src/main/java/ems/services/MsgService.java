package ems.services;

import com.google.gson.JsonArray;

public interface MsgService {
public void sendMessage(int empid,int toid,String msg);
public JsonArray getChat(int empid);
}
