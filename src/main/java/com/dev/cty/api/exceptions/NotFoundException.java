package com.dev.cty.api.exceptions;

import javax.servlet.http.HttpServletResponse;

import com.dev.cty.type.ErrorType;

public class NotFoundException extends RestException {

	private static final long serialVersionUID = 5880689669433149789L;

	public NotFoundException(String errMsg) {
		super(HttpServletResponse.SC_NOT_FOUND, ErrorType.NOT_FOUND_EXCEPTION.value(), errMsg);
	}

	public NotFoundException(String errCode, String errMsg) {
		super(HttpServletResponse.SC_NOT_FOUND, errCode, errMsg);
	}

}
