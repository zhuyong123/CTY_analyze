package com.dev.cty.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dev.cty.entity.MobileUser;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class UsersVo implements Serializable {

	private static final long serialVersionUID = 1444741726787055989L;

	private Long count;

	private List<UserVo> users;

	public UsersVo() {

	}

	public UsersVo(List<MobileUser> users) {
		if (users == null || users.isEmpty()) {
			this.count = 0L;
		} else {
			for (MobileUser user : users) {
				this.addUser(new UserVo(user));
			}
			this.count = new Long(users.size());
		}
	}
	
//	public UsersVo(List<UserVo> usersVo){
//		if (usersVo == null || usersVo.isEmpty()) {
//			this.count = 0L;
//		} else {
//			this.users = usersVo;
//			this.count = new Long(usersVo.size());
//		}
//	}
//	
	private void addUser(UserVo userVo) {
		if (this.users == null) {
			this.users = new ArrayList<UserVo>();
		}
		this.users.add(userVo);
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<UserVo> getUsers() {
		return users;
	}

	public void setUsers(List<UserVo> users) {
		this.users = users;
	}

}
