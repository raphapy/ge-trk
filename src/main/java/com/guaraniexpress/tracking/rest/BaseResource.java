package com.guaraniexpress.tracking.rest;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import com.google.common.base.Strings;
import com.guaraniexpress.tracking.dao.GuaraniExpressDAO;

public abstract class BaseResource<T, ID extends Serializable> {

	public static final String PAGE_START_PARAM_NAME = "page_start";
	public static final String ORDER_PARAM_NAME = "order";
	public static final String PAGE_SIZE_PARAM_NAME = "page_size";
	public static final String PAGE_START_PARAM_DEFAULT_VALUE = "0";
	public static final String PAGE_SIZE_PARAM_DEFAULT_VALUE = "30";
	public static final long PAGINATION_MAX_SIZE = 300;
	public static final String PAGINATION_ALL_ITEM = "-1";
	public static final String ORDER_ELEMENT_REGEXP_PATTERN = ".+\\;(DESC|ASC)";
	public static final String ORDER_ELEMENT_SPLITTER = "!";
	
	@QueryParam(ORDER_PARAM_NAME)
	private String order;
	
	@QueryParam(PAGE_START_PARAM_NAME)
	@DefaultValue(PAGE_START_PARAM_DEFAULT_VALUE)
	private Integer pageStart;
	
	@QueryParam(PAGE_SIZE_PARAM_NAME)
	@DefaultValue(PAGE_SIZE_PARAM_DEFAULT_VALUE)
	@Max(value=PAGINATION_MAX_SIZE, message="")
	private Integer pageSize;
	
	private String[] orderByAttributesList;
	private String[] orderByAttributesDir;
	
	private boolean sortable;
	private boolean paginable;

	@PostConstruct
	private void setupResource() {
		
		//determinig if resource is paginable
		if (this.pageStart!=null && this.pageSize!=null) {	
			this.setPaginable(true);
		} else {
			this.setPaginable(false);
		}
		
		//determinig is resource is sortable
		try {
			if (!Strings.isNullOrEmpty(order)) {
				String[] orderByElements = order.split(ORDER_ELEMENT_SPLITTER);
				Pattern elementPattern = Pattern
						.compile(ORDER_ELEMENT_REGEXP_PATTERN);

				if (orderByElements != null && orderByElements.length > 0) {

					orderByAttributesDir = new String[orderByElements.length];
					orderByAttributesList = new String[orderByElements.length];

					for (int i = 0; i < orderByElements.length; i++) {
						String element = orderByElements[i];

						Matcher elementPatternMatcher = elementPattern
								.matcher(element);
						if (elementPatternMatcher.matches()) {

						} else {
							throw new IllegalArgumentException(
									"Los elementos de ordenamiento no cumplen con el patron correcto. Patrón esperado "
											+ ORDER_ELEMENT_REGEXP_PATTERN);
						}

						if (orderByAttributesDir != null
								&& orderByAttributesList != null) {
							this.setSortable(true);
						} else {
							this.setSortable(false);
						}

					}
				}

			} else {
				;// Continue
			}
		} catch (Exception e) {
			// TODO: handle exception
			;
		}
	}

	protected List<T> listItems(T example,
			GuaraniExpressDAO<T, Serializable> delegatedService) {

		if (example == null) {

			if (this.isSortable() && this.isPaginable()) {
				return delegatedService.list(example, this.pageStart,
						this.pageSize, this.orderByAttributesList,
						this.orderByAttributesDir);
			} else if (this.isSortable()) {
				return delegatedService.list(example,
						this.orderByAttributesList, this.orderByAttributesDir);
			} else if (this.isPaginable()) {
				return delegatedService.list(example, this.pageStart,
						this.pageSize);
			}

		} else {
			if (this.isSortable() && this.isPaginable()) {
				return delegatedService.list(this.pageStart, this.pageSize,
						this.orderByAttributesList, this.orderByAttributesList);
			} else if (this.isSortable()) {
				return delegatedService.list(this.orderByAttributesList,
						this.orderByAttributesDir);
			} else if (this.isPaginable()) {
				return delegatedService.list(this.pageStart, this.pageSize);
			} else {
				return null;
			}
		}

		return delegatedService.list();
	}

	protected boolean isSortable() {
		return sortable;
	}

	private void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	protected boolean isPaginable() {
		return paginable;
	}

	private void setPaginable(boolean paginable) {
		this.paginable = paginable;
	}
}
