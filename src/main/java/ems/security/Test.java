package ems.security;



public class Test {
public static void main(String args[]) throws Exception {
	String detxt=Decrypt.decrypt("KxWdrVPwI+Tpq0278Efv9A==",MyKey.getKey());
	System.out.println("decrypted text: "+ detxt);

}
}
