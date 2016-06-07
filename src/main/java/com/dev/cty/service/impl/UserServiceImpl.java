package com.dev.cty.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.cty.dao.Dao;
import com.dev.cty.entity.MobileUser;
import com.dev.cty.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private Dao<MobileUser> dao;
	
	private String QUERY_USER_SQL="";

	@Override
	public MobileUser getById(Long userId) {
		
//		return dao.get(QUERY_USER_SQL);
		return null;
	}
	


}
