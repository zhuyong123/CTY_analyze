/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.dev.cty.dao;

import java.util.Map;

import com.dev.cty.entity.Property;

public interface PropertyDao {

	public Property save(Property property);
	
	public Property updateProperty(Property property);
	
	public void removeProperty(Property property);
	
	public String getProperty(String name);
	
	public String getProperty(String name, String defalut);
	
	public Map<String, String> getProperty();
}
