package com.dev.cty.dto;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.dev.cty.dto.parent.TransferObject;
import com.dev.cty.entity.MobileUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto extends TransferObject<MobileUser> {

	private static final long serialVersionUID = -6739867753935035999L;

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
	private String houseOwnerCode;
	private String houseOwnerName;
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
	private Integer positionName;
	private Integer departmentId;
	private String officePhone;
	
	private String RoomNo;
	private String OldPassword;
	
	
	public String getHouseOwnerName() {
		return houseOwnerName;
	}
	public void setHouseOwnerName(String houseOwnerName) {
		this.houseOwnerName = houseOwnerName;
	}
	public String getHouseOwnerCode() {
		return houseOwnerCode;
	}
	public void setHouseOwnerCode(String houseOwnerCode) {
		this.houseOwnerCode = houseOwnerCode;
	}
	public String getOldPassword() {
		return OldPassword;
	}
	public void setOldPassword(String oldPassword) {
		OldPassword = oldPassword;
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
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
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
	public Integer getDepartmentId() {
		return departmentId;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(String roomNo) {
		RoomNo = roomNo;
	}
	public Integer getPositionName() {
		return positionName;
	}
	public void setPositionName(Integer positionName) {
		this.positionName = positionName;
	}
	
	@Override
	public MobileUser toObject(MobileUser user) {
		if (this.userId != null) {
			user.setId(this.userId);
		}
		user.setUsername(this.username);
		user.setCnName(this.cnName);
		user.setPassword(this.password);
		user.setTelephone(this.telephone);
		user.setAge(this.age);
		user.setGender(this.gender);
		user.setJob(this.job);
		user.setCommunityId(this.communityId);
		user.setHomeCode(this.homeCode);
		user.setFloorCode(this.floorCode);
		user.setUnitCode(this.unitCode);
		user.setHouseOwnerId(this.houseOwnerId);
		user.setRelation(this.relation);
		user.setUserTypeId(this.userTypeId);
		user.setLoginToken(this.loginToken);
		user.setPicturePath(this.picturePath);
		user.setParentId(this.parentId);
		user.setDeviceId(this.deviceId);
		user.setDeviceName(this.deviceName);
		user.setNetwork(this.network);
		user.setDeviceToken(this.deviceToken);
		user.setOs(this.os);
		user.setIp(this.ip);
		user.setRemark(this.remark);
		user.setClientVersion(this.clientVersion);
		return user;

	}
	
	public Boolean checkParamIsNull(String colum){
		if(StringUtils.isNotEmpty(colum)){
			return false;
		}else{
			return true;
		}
	}

}
