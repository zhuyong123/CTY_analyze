package com.dev.cty.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.dev.cty.dao.BaseDao;
import com.dev.cty.dao.Dao;

@SuppressWarnings("rawtypes")
@Repository("userDao")
public class DaoImpl<T> extends BaseDao<Object> implements Dao {

	private static final Logger logger = LoggerFactory
			.getLogger(DaoImpl.class);

	@Override
	public Map get(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getList(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}





}
