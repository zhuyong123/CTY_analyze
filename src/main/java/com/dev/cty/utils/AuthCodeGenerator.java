package com.dev.cty.utils;

import java.io.UnsupportedEncodingException;

public class AuthCodeGenerator {

	private String code = "";

	public AuthCodeGenerator() {
		generateCode(6);
	}

	public String generateCode(int num) {
		String rand = null;
		for (int i = 0; i < num; i++) {
			if( i==0 ){
				int max = 9, min= 1;
				Long randNum = Math.round(Math.random()*(max-min)+min); 
				rand = String.valueOf(randNum);
			}else{
				int max = 9, min= 0;
				Long randNum = Math.round(Math.random()*(max-min)+min); 
				rand = String.valueOf(randNum);
			}
			code += rand;
		}
		return code;
	}

	public String getCode() {
		return code;
	}

	public String changeIsoToUtf(String s) {
		String str = "";
		try {
			if (s == null || s == "" || s.equals("")) {
				str = s;
			} else {
				str = new String(s.getBytes("ISO8859-1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public String changeIsoToGbk(String s) {
		String str = "";
		try {
			if (s == null || s == "" || s.equals("")) {
				str = s;
			} else {
				str = new String(s.getBytes("ISO8859-1"), "GBK");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

}
