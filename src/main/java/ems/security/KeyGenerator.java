package ems.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

import ems.logger.Emslogger;

public class KeyGenerator {
	private static SecretKeySpec secretkey;
	private static byte[] key;
	public static SecretKeySpec setKey(String emskey) {
		MessageDigest sha=null;
		try{
		key=emskey.getBytes("UTF-8");
		sha=MessageDigest.getInstance("SHA-1");
		key=sha.digest(key);
		key=Arrays.copyOf(key,16);
		secretkey=new SecretKeySpec(key,"AES");
		return secretkey;
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
			Emslogger.error("error creating spec key:"+e.getMessage());
			return null;
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			Emslogger.error("error creating spec key:"+e.getMessage());
			return null;
		}
		
	}
}
