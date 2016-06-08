package com.dev.cty.dao.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dev.cty.dao.PropertyDao;
import com.dev.cty.entity.Property;

@Repository("propertyDao")
public class PropertyDaoImpl implements PropertyDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PropertyDaoImpl.class);

	private static final String LOAD_PROPERTIES = "SELECT name, propValue FROM property";
	private static final String INSERT_PROPERTY = "INSERT INTO property(name, propValue) VALUES(?,?)";
	private static final String UPDATE_PROPERTY = "UPDATE property SET propValue=? WHERE name=?";
	private static final String DELETE_PROPERTY = "DELETE FROM property WHERE name LIKE ?";

	private Map<String, String> properties = new ConcurrentHashMap<String, String>();

	private Long propertyUpdateTime = Calendar.getInstance().getTimeInMillis();

	public Property save(Property gpProperty) {
		jdbcTemplate.update(INSERT_PROPERTY, new Object[] { gpProperty.getName(), gpProperty.getValue() });
		properties.put(gpProperty.getName(), gpProperty.getValue());
		return gpProperty;
	}

	private Map<String, String> init() {
		properties.clear();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(LOAD_PROPERTIES);
		for (Map<String, Object> row : rows) {
			String name = (String) row.get("name");
			String propValue = (String) row.get("propValue");
			properties.put(name, propValue);
		}
		propertyUpdateTime = Calendar.getInstance().getTimeInMillis();
		return properties;
	}

	public Property updateProperty(Property gpProperty) {
		jdbcTemplate.update(UPDATE_PROPERTY, new Object[] {gpProperty.getValue(),gpProperty.getName()});
		properties.put(gpProperty.getName(), gpProperty.getValue());
		init();
		return gpProperty;
	}

	public void removeProperty(Property gpProperty) {
		jdbcTemplate.update(DELETE_PROPERTY, new Object[] { gpProperty.getName() });
		properties.remove(gpProperty.getName());
	}

	public String getProperty(String name) {
		if (properties.isEmpty() || isNeedUpdate()) {
			init();
			logger.info("init properties...");
		}
		return properties.get(name);
	}

	public String getProperty(String name, String defaultValue) {
		String value = getProperty(name);
		if (StringUtils.isBlank(value)) {
			return defaultValue;
		} else {
			return value;
		}
	}

	// update every 5 minute
	private boolean isNeedUpdate() {
		return Calendar.getInstance().getTimeInMillis() - propertyUpdateTime > 1000 * 60 * 5;
	}

	public Map<String, String> getProperty() {
		if (properties.isEmpty() || isNeedUpdate()) {
			init();
			logger.info("init properties...");
		}
		return properties;
	}

	public Map<String, String> getProperties() {
		if (properties.isEmpty() || isNeedUpdate()) {
			init();
			logger.info("init properties...");
		}
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
