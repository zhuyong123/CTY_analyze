package com.dev.cty.utils;

public class ExceptionUtils {
	public static String ConvertStackTrace(Exception e) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(e.getClass().getName() + " " + e.getMessage() + "\n");
		for (StackTraceElement element : e.getStackTrace()) {
			buffer.append(element.toString() + "\n");
		}
		return buffer.toString();
	}
}
