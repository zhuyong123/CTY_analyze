/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.dev.cty.dao;

import java.util.List;
import java.util.Map;

public interface Dao<T> {

	
	public Map<String,String> get(String sql);
	
	public List<Map<String,String>> getList(String sql);
	
	public int add(String sql);
	
	public int update(String sql);
	
	public int delete(String sql);
	
	
}
