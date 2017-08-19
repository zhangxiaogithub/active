package com.active.base;

import java.io.Serializable;

public class Pagination implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pageIndex;// 当前页数
	private Integer pageSize;// 每页显示数量
	private Long total;// 总数量

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}


}
