/**
 * @Copyright: Copyright (c) 2010 TelenavSoftware, Inc. All rights reserved.
 */

package com.dev.cty.dto;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.dev.cty.dao.page.Page;
import com.dev.cty.dao.page.PageFilter;
import com.dev.cty.dao.page.PageOrder;
import com.dev.cty.dto.parent.TransferObject;
import com.dev.cty.utils.ConstantUtils;


public class PagingDto<T extends Serializable> extends TransferObject<Page<T>> {

	private static final long serialVersionUID = 2862328890550410415L;

	private Integer pageNumber = ConstantUtils.DEFAULT_PAGE_NUMBER;

	private Integer pageSize = ConstantUtils.DEFAULT_PAGE_SIZE;

	private Long createTime = Calendar.getInstance().getTimeInMillis();

	private String pageFilter;
	
	private PageFilter pageFilterObj = new PageFilter();
	
	private PageOrder pageOrderObj = new PageOrder();

	private String pageOrder;

	public Integer getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageFilter() {
		return pageFilter;
	}

	public void setPageFilter(String pageFilter) {
		this.pageFilter=pageFilter;
	}

	public String getPageOrder() {
		return pageOrder;
	}

	public void setPageOrder(String pageOrder) {
		this.pageOrder = pageOrder;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	@Override
	public Page<T> toObject(Page<T> page) {
		if (pageNumber != null) {
			page.setPageNumber(pageNumber);
		}
		if (pageSize != null) {
			page.setPageSize(pageSize);
		}
		if (createTime != null) {
			Calendar time = Calendar.getInstance();
			time.setTimeInMillis(createTime);
			page.setCreateTime(time);
		}
		if (pageFilter != null) {
			if (StringUtils.isNotBlank(pageFilter)) {
				pageFilterObj.parser(pageFilter);
			}
			page.setPageFilter(pageFilterObj);
		}
		if (pageOrder != null) {
			if (StringUtils.isNotBlank(pageOrder)) {
				pageOrderObj.parser(pageOrder);
			}
			page.setPageOrder(pageOrderObj);
		}

		return page;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("pageOrder", this.pageOrder).append("pageNumber", this.pageNumber).append("pageFilter", this.pageFilter).append("pageSize", this.pageSize).toString();
	}
}
