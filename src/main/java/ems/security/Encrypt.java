package ems.security;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import ems.logger.Emslogger;

public class Encrypt {

	
	public static String encrypt(String str,String userkey) {
		try {
			SecretKeySpec secretkey=KeyGenerator.setKey(userkey);
			Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretkey);
			byte[] initial=str.getBytes("UTF-8");
			byte[] finalbytes=cipher.doFinal(initial);
			String encodedString=Base64.getEncoder().encodeToString(finalbytes);
			return encodedString;
		}catch(Exception e) {
			e.printStackTrace();
			Emslogger.error("error encrypting"+e);
			return null;
			}
	}
	
}
