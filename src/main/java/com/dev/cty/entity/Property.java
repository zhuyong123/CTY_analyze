package com.dev.cty.entity;

import java.io.Serializable;

public class Property implements Serializable {

	private static final long serialVersionUID = 5079945846731197986L;

	public static String LOWESTVERSION = "snapMatch.lowestVersion";

	public static String LATESTVERSION = "snapMatch.latestVersion";

	private String name;

	private String value;

	public Property() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
