package com.dev.cty.entity;

import java.util.Date;

public class Report {
	private String repName;
	private String repUrl;
	private String repDesc;
	private Date createDate;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	
	
}
