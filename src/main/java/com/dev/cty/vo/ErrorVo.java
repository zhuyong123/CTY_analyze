package com.dev.cty.vo;

import com.dev.cty.type.ErrorType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorVo {
	
	private String errCode;
	
	private String errMsg="";

	public ErrorVo(ErrorType errCode,String errMsg){
		this.errCode = errCode.value();
		this.errMsg = errMsg;
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
