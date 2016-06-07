package com.dev.cty.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

/**
 *
 * <BaseDao>
 * 
 * @version <V1.0>
 */
public class BaseDao<T> {
	@Autowired
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// public List<T> queryEntityList(String sql,Class classType,Object ob){
	// return this.jdbcTemplate.query(sql,
	// ParameterizedBeanPropertyRowMapper.newInstance(classType), new
	// BeanPropertySqlParameterSource(ob));
	// }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <T> List<T> queryEntityList(String sql, Class classType, Map param)
			throws Exception {
		return jdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(classType),
				param);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected <T> List<T> queryEntityList(String sql, Class classType, Object[] args)
			throws Exception {
		return jdbcTemplate
				.query(sql, ParameterizedBeanPropertyRowMapper
						.newInstance(classType), args);
	}

	@SuppressWarnings({ "rawtypes" })
	public List queryForList(String sql) {
		return jdbcTemplate.queryForList(sql);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List queryForList(String sql, Class classType, Map param)
			throws Exception {
		return jdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(classType),
				param);
	}

	@SuppressWarnings("rawtypes")
	protected Map queryForMap(String sql) throws Exception {
		return jdbcTemplate.queryForMap(sql);
	}

	@SuppressWarnings("rawtypes")
	protected Map queryForMap(String sql, Object... args) throws Exception {
		try {
			return jdbcTemplate.queryForMap(sql, args);
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			// 其他的异常正常抛出
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	protected Map queryForMap(String sql, Map param) throws Exception {
		return jdbcTemplate.queryForMap(sql, param);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Object queryForObject(String sql, Class classType)
			throws Exception {
		return jdbcTemplate.queryForObject(sql, classType);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Object queryForObject(String sql, Class classType, Map param)
			throws Exception {
		return jdbcTemplate.queryForObject(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(classType),
				param);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T queryForObject(String sql, Class classType, Object ob) {
		try {
			return ((T) this.jdbcTemplate.queryForObject(sql.toString(),
					ParameterizedBeanPropertyRowMapper.newInstance(classType),
					new BeanPropertySqlParameterSource(ob)));
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&& ((IncorrectResultSizeDataAccessException) e)
							.getActualSize() == 0)
				return null;
			// 其他的异常正常抛出
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T queryForObject(String sql, Class classType, Object... org) {
		try {
			return ((T) this.jdbcTemplate.queryForObject(sql.toString(),
					ParameterizedBeanPropertyRowMapper.newInstance(classType), org));
		} catch (Exception e) {
			if ((e instanceof IncorrectResultSizeDataAccessException)
					&&((IncorrectResultSizeDataAccessException)e).getActualSize()==0)
				return null;
			// 其他的异常正常抛出
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes" })
	protected List queryForListMap(String sql, Map param) throws Exception {
		return jdbcTemplate.queryForList(sql, param);
	}

	public int saveObject(String sql, Object obj) {
		SqlParameterSource ps = new BeanPropertySqlParameterSource(obj);
		KeyHolder key = new GeneratedKeyHolder();
		namedParameterJdbcOperations.update(sql, ps, key);
		if (key.getKey() != null) {
			return key.getKey().intValue();
		} else {
			return 0;
		}
	}

	public int updateObject(String sql, Object obj) {
		SqlParameterSource ps = new BeanPropertySqlParameterSource(obj);
		return namedParameterJdbcOperations.update(sql, ps);
	}
	
	public int updateObject(String sql, Object... objs) {
		return jdbcTemplate.update(sql, objs);
	}

	public int saveObject(String sql, Object... objs) {
		return jdbcTemplate.update(sql, objs);
	}

	public int[] batchUpdate(String sql, List<Object[]> batchArgs) {
		return jdbcTemplate.batchUpdate(sql, batchArgs, new int[0]);
	}

	public int[] batchUpdate(String sql, List<Object[]> batchArgs,
			int[] argTypes) {
		return jdbcTemplate.batchUpdate(sql, batchArgs, argTypes);
	}

}
