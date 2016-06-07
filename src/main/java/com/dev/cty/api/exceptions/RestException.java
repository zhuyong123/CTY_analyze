package com.dev.cty.api.exceptions;


public class RestException extends RuntimeException {

	private static final long serialVersionUID = 5880689669433149789L;

	private int status;
	
	private String errCode;
	
	private String errMsg;
	
	public RestException(int status, String errCode, String errMsg) {
		super(errMsg);
		this.status = status;
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
