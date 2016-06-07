package com.dev.cty.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BalanceNotEnoughException extends RestException {

	private static final long serialVersionUID = 5880689669433149789L;

	public BalanceNotEnoughException(String errMsg) {
		super(400, "4000", errMsg);
	}

	public BalanceNotEnoughException(String errCode, String errMsg) {
		super(400, errCode, errMsg);
	}

}
