package com.dev.cty.dto;

import java.io.Serializable;

public class ReportDto implements Serializable {
	private String repName;
	private String repUrl;
	private String repDesc;
	private String createPerson;
	public String getRepName() {
		return repName;
	}
	public void setRepName(String repName) {
		this.repName = repName;
	}
	public String getRepUrl() {
		return repUrl;
	}
	public void setRepUrl(String repUrl) {
		this.repUrl = repUrl;
	}
	public String getRepDesc() {
		return repDesc;
	}
	public void setRepDesc(String repDesc) {
		this.repDesc = repDesc;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	
}
