package com.guaraniexpress.tracking.web;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.guaraniexpress.tracking.dao.GenericDao;
import com.guaraniexpress.tracking.exceptions.ApplicationException;
import com.guaraniexpress.tracking.utils.ServiceUtils;

@SuppressWarnings("rawtypes")
@Produces(CustomMediaType.APPLICATION_JSON_UTF8)
public abstract class ReadableResource<T, ID extends Serializable, DAO extends GenericDao> {

	public static final String USING_LIKE_PARAM_NAME = "using_like";
	public static final String USING_LIKE_PARAM_DEFAUL_VALUE = "false";
	public static final String KEY_PARAM_NAME = "key";
	public static final String FILTERS_PARAM_NAME = "filters";
	public static final String PAGE_START_PARAM_NAME = "page_start";
	public static final String ORDER_PARAM_NAME = "order";
	public static final String PAGE_SIZE_PARAM_NAME = "page_size";
	public static final String PAGE_START_PARAM_DEFAULT_VALUE = "0";
	public static final String PAGE_SIZE_PARAM_DEFAULT_VALUE = "30";
	public static final long PAGINATION_MAX_SIZE = 300;
	public static final String PAGINATION_ALL_ITEM = "-1";
	public static final String ORDER_ELEMENT_REGEXP_PATTERN = ".+\\;(DESC|ASC)";
	public static final String ORDER_LIST_SPLITTER = "!";
	public static final String ORDER_ELEMENT_SPLITTER = ";";

	@QueryParam(ORDER_PARAM_NAME)
	private String order;

	@QueryParam(PAGE_START_PARAM_NAME)
	@DefaultValue(PAGE_START_PARAM_DEFAULT_VALUE)
	private Integer pageStart;

	@QueryParam(PAGE_SIZE_PARAM_NAME)
	@DefaultValue(PAGE_SIZE_PARAM_DEFAULT_VALUE)
	@Max(value = PAGINATION_MAX_SIZE, message = "{ReadableResource.pageSize.Max}")
	private Integer pageSize;
	
	@QueryParam(USING_LIKE_PARAM_NAME)
	@DefaultValue(USING_LIKE_PARAM_DEFAUL_VALUE)
	private Boolean usingLike;

	private String[] orderByAttributesList;
	private String[] orderByAttributesDir;

	private boolean sortable;
	private boolean paginable;
	private boolean filterable;
	private boolean useKeyForQuery;
	
	@QueryParam(FILTERS_PARAM_NAME)
	private String stringifiedFilters;	
	private T filters;
	
	@QueryParam(KEY_PARAM_NAME)
	private String stringifiedKey;
	private ID key;

	protected abstract DAO getDelegatedDao();

	protected abstract Class<T> getEntityBeanType();
	protected abstract Class<ID> getEntityKeyType();
	

	@PostConstruct
	private void setupQuerySettings() {

		// determinig if resource is paginable
		if (this.pageStart != null && this.pageSize != null) {
			this.setPaginable(true);
		} else {
			this.setPaginable(false);
		}
		
		//determinig if resource is filterable by key
		if (!Strings.isNullOrEmpty(stringifiedKey)) {
			//key deserialization
			
			try {
				Gson gson = new Gson();
				this.key = gson.fromJson(this.stringifiedKey,
						getEntityKeyType());
				
				if (this.key!=null) {
					this.setUseKeyForQuery(true);
				} else {
					this.setUseKeyForQuery(false);
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("No se pudo deserializar el parámetro key.", e);
			}
			
			
		} else if (!Strings.isNullOrEmpty(stringifiedFilters)) {
			// determinig if resource is filterable
				try {
					Gson gson = new Gson();
					// getting object to use as filter in the query
					this.filters = gson.fromJson(this.stringifiedFilters,
							getEntityBeanType());
					if (this.filters != null) {
						this.setFilterable(true);
					} else {
						this.setFilterable(false);
					}
				} catch (Exception e) {
					throw new IllegalArgumentException(
							"No se pudo deserializar el parámetro filters.", e);
				}
				
		} else {
			
			this.setFilterable(false);
			this.setUseKeyForQuery(false);
		}

		// determinig if resource is sortable
		if (!Strings.isNullOrEmpty(order)) {
			
			String[] orderByElements = order.split(ORDER_LIST_SPLITTER);
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
						String[] orderClause = element
								.split(ORDER_ELEMENT_SPLITTER);
						orderByAttributesList[i] = orderClause[0];
						orderByAttributesDir[i] = orderClause[1];

					} else {
						throw new IllegalArgumentException(
								"Los elementos de ordenamiento no cumplen con el patron correcto. Patrón esperado "
										+ ORDER_ELEMENT_REGEXP_PATTERN);
					}
				}

				if (orderByAttributesDir != null
						&& orderByAttributesList != null) {
					this.setSortable(true);
				} else {
					this.setSortable(false);
				}
			}
			
		} else {
			this.setSortable(false);
		}

	}

	@SuppressWarnings({ "unchecked" })
	@GET
	@Path("/")
	public Response performQuery() throws ApplicationException {

		if (getDelegatedDao() == null) {
			throw new IllegalArgumentException(
					"Se requiere el objeto de acceso a datos para realizar la búsqueda.");
		}

		List<T> items = null;
		Integer totalCount = 0;
		T item = null;
		
		if (this.isUseKeyForQuery()) {
			
			item = (T) getDelegatedDao().get(key);
			ServiceUtils.validarEncontrado(item, "Recurso no encontrado");
			
		} else if(this.isFilterable()) {
			
			if (this.isSortable() && this.isPaginable()) {
				totalCount = getDelegatedDao().count(this.filters,
						this.pageStart, this.pageSize,
						this.orderByAttributesList, this.orderByAttributesDir);
				items = getDelegatedDao().list(this.filters, this.pageStart,
						this.pageSize, this.orderByAttributesList,
						this.orderByAttributesDir);
			} else if (this.isSortable()) {
				totalCount = getDelegatedDao().count(this.filters,
						this.orderByAttributesList, this.orderByAttributesDir);
				items = getDelegatedDao().list(this.filters,
						this.orderByAttributesList, this.orderByAttributesDir);
			} else if (this.isPaginable()) {
				totalCount = getDelegatedDao().count(this.filters,
						this.pageStart, this.pageSize);
				items = getDelegatedDao().list(this.filters, this.pageStart,
						this.pageSize);
			}
			
		} else {
			if (this.isSortable() && this.isPaginable()) {
				totalCount = getDelegatedDao().count(this.pageStart,
						this.pageSize, this.orderByAttributesList,
						this.orderByAttributesDir);
				items = getDelegatedDao().list(this.pageStart, this.pageSize,
						this.orderByAttributesList, this.orderByAttributesList);
			} else if (this.isSortable()) {
				totalCount = getDelegatedDao().count(
						this.orderByAttributesList, this.orderByAttributesDir);
				items = getDelegatedDao().list(this.orderByAttributesList,
						this.orderByAttributesDir);
			} else if (this.isPaginable()) {
				totalCount = getDelegatedDao().count(this.pageStart,
						this.pageSize);
				items = getDelegatedDao().list(this.pageStart, this.pageSize);
			}
		}
		
		if (this.isUseKeyForQuery()) {
			return Response.ok(item).build();
		} else {
			ServiceUtils.validarEncontrado(items, "No se encontraron datos");
			PagedList<T> pagedList = new PagedList<>(items, totalCount);
			return Response.ok(pagedList).build();
		}
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

	protected boolean isFilterable() {
		return filterable;
	}

	private void setFilterable(boolean filterable) {
		this.filterable = filterable;
	}

	protected boolean isUseKeyForQuery() {
		return useKeyForQuery;
	}

	private void setUseKeyForQuery(boolean useKeyForQuery) {
		this.useKeyForQuery = useKeyForQuery;
	}

	protected Boolean getUsingLike() {
		return usingLike;
	}

	protected void setUsingLike(Boolean usingLike) {
		this.usingLike = usingLike;
	}
}
