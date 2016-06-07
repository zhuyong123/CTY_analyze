package com.dev.cty.vo;

import java.io.Serializable;
import java.util.Date;

import com.dev.cty.entity.MobileUser;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UserVo implements Serializable {

	private static final long serialVersionUID = 987975313303903964L;

	private Integer userId;
	private String username;
	private String cnName;
	private String password;
	private String telephone;
	private String age;
	private String gender;
	private String job;
	private Integer userTypeId;
	private String homeCode;
	private String floorCode;
	private String unitCode;
	private Integer communityId;
	private Integer houseOwnerId;
	private String relation;
	private String loginToken;
	private String picturePath;
	private String parentId;
	private String deviceId;
	private String deviceName;
	private String network;
	private String deviceToken;
	private String os;
	private String ip;
	private String remark;
	private String clientVersion;
	private Date createTime;
	private Date updateTime;
	private String positionName;
	private Integer departmentId;
	private String officePhone;
	
	private String CommunityName;
	
	public String getCommunityName() {
		return CommunityName;
	}

	public void setCommunityName(String communityName) {
		CommunityName = communityName;
	}

	public UserVo() {
		super();
	}

	public UserVo(MobileUser user) {
		this.userId=user.getId();
		this.username=user.getUsername();
		this.cnName=user.getCnName();
		this.password=user.getPassword();
		this.telephone=user.getTelephone();
		this.age=user.getAge();
		this.gender=user.getGender();
		this.job=user.getJob();
		this.communityId=user.getCommunityId();
		this.homeCode=user.getHomeCode();
		this.floorCode=user.getFloorCode();
		this.unitCode=user.getUnitCode();
		this.houseOwnerId=user.getHouseOwnerId();
		this.relation=user.getRelation();
		this.userTypeId=user.getUserTypeId();
		this.loginToken=user.getLoginToken();
		this.picturePath=user.getPicturePath();
		this.parentId=user.getParentId();
		this.deviceId=user.getDeviceId();
		this.deviceName=user.getDeviceName();
		this.network=user.getNetwork();
		this.deviceToken=user.getDeviceToken();
		this.os=user.getOs();
		this.ip=user.getIp();
		this.remark=user.getRemark();
		this.clientVersion=user.getClientVersion();
		this.positionName=user.getPositionName();
		this.departmentId=user.getDepartmentId();
		this.officePhone=user.getOfficePhone();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getHomeCode() {
		return homeCode;
	}

	public void setHomeCode(String homeCode) {
		this.homeCode = homeCode;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public Integer getCommunityId() {
		return communityId;
	}

	public void setCommunityId(Integer communityId) {
		this.communityId = communityId;
	}

	public Integer getHouseOwnerId() {
		return houseOwnerId;
	}

	public void setHouseOwnerId(Integer houseOwnerId) {
		this.houseOwnerId = houseOwnerId;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	
	
}
