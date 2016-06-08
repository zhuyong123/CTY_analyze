package com.dev.cty.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.cty.dao.PropertyDao;
import com.dev.cty.entity.Property;
import com.dev.cty.service.PropertyService;

@Service("propertyService")
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	private PropertyDao propertyDao;

	@Override
	public String getProperty(String name) {
		return propertyDao.getProperty(name);
	}

	@Override
	public String getProperty(String name, String defalut) {
		return propertyDao.getProperty(name, defalut);
	}

	@Override
	public Map<String, String> getProperty() {
		return propertyDao.getProperty();
	}

	@Override
	public void removeProperty(Property property) {
		propertyDao.removeProperty(property);
	}

	@Override
	@Transactional
	public Property save(Property property) {
		return propertyDao.save(property);
	}

	@Override
	public Property updateProperty(Property propert) {
		return propertyDao.updateProperty(propert);
	}
	
	

}
