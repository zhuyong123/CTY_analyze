package com.dev.cty.type;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {

	COMMON_USER(1),

	PM_USER(2),

	GM_USER(3),
	
	MOBILE_USER(4),
	
	MANAGE_USER(5);


	private final Integer value;

	private UserType(Integer value) {
		this.value = value;
	}

	@JsonValue
	public Integer value() {
		return value;
	}

	public static UserType fromInt(Integer value) {
		for (UserType type : UserType.values()) {
			if (type.value == value) {
				return type;
			}
		}
		return null;
	}
}
