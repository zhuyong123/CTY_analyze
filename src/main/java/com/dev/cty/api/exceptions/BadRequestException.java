package com.dev.cty.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dev.cty.type.ErrorType;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RestException {

	private static final long serialVersionUID = 5880689669433149789L;

	public BadRequestException(ErrorType errCode) {
		super(400, errCode.value(), "");
	}

	public BadRequestException(ErrorType errCode, String errMsg) {
		super(400, errCode.value(), errMsg);
	}

}
