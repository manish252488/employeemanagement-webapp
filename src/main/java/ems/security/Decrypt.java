package ems.security;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import ems.logger.Emslogger;

public class Decrypt {

	
	public static String decrypt(String str,String userkey) {
		try {
		SecretKeySpec secretkey=KeyGenerator.setKey(userkey);
		Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretkey);
		byte[] b=Base64.getDecoder().decode(str);
		String decryptedStr=new String(cipher.doFinal(b));
		return decryptedStr;
		}catch (Exception e) {
		e.printStackTrace();
		Emslogger.error("error decrypting "+e.getMessage());
		return null;
		}
		
	}
	
}
