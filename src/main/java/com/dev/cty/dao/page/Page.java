/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */
package com.dev.cty.dao.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dev.cty.utils.ConstantUtils;



public class Page<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = 4697148875530269878L;

	private Integer pageNumber = ConstantUtils.DEFAULT_PAGE_NUMBER;

	private Integer pageSize = ConstantUtils.DEFAULT_PAGE_SIZE;

	private Calendar createTime = Calendar.getInstance();

	private PageFilter pageFilter = new PageFilter();

	private PageOrder pageOrder = new PageOrder();

	private Long totalSize = 0l;

	private List<T> result = new ArrayList<T>();

	private String queryStr;

	public Page(){
		
	}
	
	public Page(Page<?> page) {
		this.pageFilter = page.pageFilter;
		this.pageOrder = page.pageOrder;
		this.pageSize = page.pageSize;
		this.pageNumber = page.pageNumber;
		this.totalSize = page.totalSize;
	}

	public Page(Integer pageNumber, Integer pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
		if (pageNumber < 1) {
			this.pageNumber = ConstantUtils.DEFAULT_PAGE_NUMBER;
		}
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		if (pageSize < 1) {
			this.pageSize = ConstantUtils.DEFAULT_PAGE_SIZE;
		}
	}

	public PageFilter getPageFilter() {
		return pageFilter;
	}

	public void setPageFilter(PageFilter pageFilter) {
		this.pageFilter = pageFilter;
	}

	public PageOrder getPageOrder() {
		return pageOrder;
	}

	public void setPageOrder(PageOrder pageOrder) {
		this.pageOrder = pageOrder;
	}

	public List<T> getResult() {
		return this.result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public Long getTotalSize() {
		return this.totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = (long) totalSize;
	}

	public Long getTotalPages() {
		if (totalSize < 0) {
			return 0L;
		}
		long count = totalSize / pageSize;
		if (totalSize % pageSize > 0) {
			count++;
		}
		return count;
	}

	public Integer getStartPosition() {
		return (pageNumber - 1) * pageSize;
	}

	public Integer getEndPosition() {
		return pageNumber * pageSize;
	}

	public Boolean isFirstPage() {
		return pageNumber == 1;
	}

	public Boolean isLastPage() {
		return pageNumber == getTotalPages().longValue();
	}

	public Boolean hasPreviousPage() {
		return pageNumber - 1 >= 1;
	}

	public Boolean hasNextPage() {
		return pageNumber + 1 <= getTotalPages();
	}

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	public List<Long> getSlider(int count) {
		long halfSize = count / 2;
		long totalPage = getTotalPages();

		long startPageNumber = Math.max(pageNumber - halfSize, 1);
		long endPageNumber = Math.min(startPageNumber + count - 1, totalPage);

		if (endPageNumber - startPageNumber < count) {
			startPageNumber = Math.max(endPageNumber - count, 1);
		}

		List<Long> result = new ArrayList<Long>();
		for (long i = startPageNumber; i < endPageNumber; i++) {
			result.add(new Long(i));
		}
		return result;
	}

	public boolean isPageable() {
		return pageNumber != null && pageSize != null;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
}
