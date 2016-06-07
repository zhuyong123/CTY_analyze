
package com.dev.cty.type;

import com.fasterxml.jackson.annotation.JsonValue;


public enum ErrorType {
	
	NOT_FOUND_EXCEPTION("1000"),
	
	ACCOUNT_NOT_EXIST("2003"),
	
	ACCOUNT_USERNAME_EXIST("2004"),
	
	ACCOUNT_USERNAME_ISNULL("2005"),
	
	ACCOUNTORPASSWORD_ERROR("2006"),
	
	ACCOUNT_NOT_EXIST_OR_PASSWORD_ERROR("2007"),
	
	HOUSE_OWNER_NOT_EXIST("2008"),
	
	AUTHCODE_TIMEOUT("2050"),
	
	AUTHCODE_INCORRECT("2051"),
	
	ILLEGAL_REQUEST("2059"),
	
	NOT_AUTH_EXCEPTION("20000"),
	
	INVALID_IAP_ORDER("40000"),
	
	NOT_VERFIED_IAP_ORDER("40001"),
	
	USER_DO_NOT_HAVE_LOCATION("40009"),
	
	INVALID_MEDIA_DATA("40010"),
	
	UPLOAD_FILE_WRITE_FAILED("40011"),
	
	SAVE_DATABASE_ROW_FAILED("50000");
	
	
	private String value;

	ErrorType(String value) {
		this.value = value;
	}
	
	@JsonValue
	public String value() {
		return value;
	}
	
}
