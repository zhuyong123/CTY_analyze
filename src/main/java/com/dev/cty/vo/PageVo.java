/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.dev.cty.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dev.cty.dao.page.Page;

public class PageVo<T extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long totalSize = 0l;

	private List<?> result = new ArrayList<T>();

	public PageVo() {

	}

	public PageVo(Page<?> page) {
		this.totalSize = page.getTotalSize();
		this.result = page.getResult();
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public List<?> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}
