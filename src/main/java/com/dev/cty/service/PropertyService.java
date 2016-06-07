package com.dev.cty.service;

import java.util.Map;

import com.dev.cty.entity.Property;



public interface PropertyService {
	public Property save(Property gpProperty);
	
	public Property updateProperty(Property gpProperty);
	
	public void removeProperty(Property gpProperty);
	
	public String getProperty(String name);
	
	public String getProperty(String name, String defalut);
	
	public Map<String, String> getProperty();
}
