/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.dev.cty.validation;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@XmlRootElement(name = "error")
@XmlType(propOrder = { "code" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Error implements Serializable {

	private static final long serialVersionUID = -5490092725897576735L;

	@XmlAttribute
	private Integer code;

	public Error() {

	}

	public Error(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
