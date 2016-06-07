package com.dev.cty.api.exceptions;

import com.dev.cty.type.ErrorType;


public class InvalidMediaException extends RestException {

	private static final long serialVersionUID = 5880689669433149789L;

	public InvalidMediaException(String errMsg) {
		super(400, ErrorType.INVALID_MEDIA_DATA.value(), errMsg);
	}

	public InvalidMediaException(String errCode, String errMsg) {
		super(400, errCode, errMsg);
	}

}
