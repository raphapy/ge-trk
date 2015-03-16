package com.guaraniexpress.tracking.rest;

import java.io.Serializable;
import java.util.List;

public class PagedList<T> implements Serializable {

	private static final long serialVersionUID = -2366042160958516678L;

	private List<T> items;
	private Integer totalCount;

	public PagedList() {
	}

	public PagedList(List<T> items, Integer totalCount) {
		this.setItems(items);
		this.setTotalCount(totalCount);
	}

	public PagedList(List<T> items) {
		this.setItems(items);
		this.setTotalCount(items != null ? items.size() : null);
	}

	public List<T> getItems() {
		return items;
	}

	private void setItems(List<T> items) {
		this.items = items;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	private void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
