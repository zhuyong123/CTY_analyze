/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.dev.cty.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "errors")
@XmlType(propOrder = { "errors" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Errors implements Serializable {

	private static final long serialVersionUID = -247003817442505713L;

	@XmlElementRef
	private List<Error> errors;

	public Errors() {

	}

	public Errors(List<Error> errors) {
		this.errors = errors;
	}

	public List<Error> getErrors() {
		if (errors == null) {
			errors = new ArrayList<Error>();
		}
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

}
