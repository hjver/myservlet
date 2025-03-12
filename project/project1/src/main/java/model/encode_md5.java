package model;

import java.security.MessageDigest;

public class encode_md5 {
	
	MessageDigest md = null;
	StringBuilder sb = new StringBuilder();
	String encode_data = "";
	
	public String encode(String pw) {
		
		
		try {
			this.md = MessageDigest.getInstance("md5");
			md.update(pw.getBytes());
			byte md5bytes[] = md.digest();
			
			for (byte md5byte : md5bytes) {
				sb.append(String.format("%02x", md5byte));
			}
			
			encode_data = String.valueOf(sb);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return encode_data;
	}
}
