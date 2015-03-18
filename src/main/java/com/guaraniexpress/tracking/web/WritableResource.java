package com.guaraniexpress.tracking.web;

import java.io.Serializable;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

import com.guaraniexpress.tracking.dao.GenericDao;
import com.guaraniexpress.tracking.exceptions.ApplicationException;
import com.guaraniexpress.tracking.i18n.Messages;
import com.guaraniexpress.tracking.utils.ServiceUtils;

@SuppressWarnings("rawtypes")
public abstract class WritableResource<T, ID extends Serializable, DAO extends GenericDao> extends ReadableResource<T, ID, DAO> {

	@SuppressWarnings("unchecked")
	@POST
	public Response createItem(T newItem) throws ApplicationException {
		ServiceUtils.validarArgumento(newItem, Messages.getString("WritableResource.REQUIRED_NEW_ENTITY_MESSAGE")); //$NON-NLS-1$
		T createdEntity = null;
		try {
			createdEntity = (T) getDelegatedDao().save(newItem);
		} catch (Exception e) {
			throw new ApplicationException.InternalError(e);
		}
		return Response.ok(createdEntity).build();
	}
	
	@SuppressWarnings("unchecked")
	@PUT
	public Response updateItem(T newState) throws ApplicationException {
		ServiceUtils.validarArgumento(newState, Messages.getString("WritableResource.REQUIRED_NEW_STATE_FOR_ENTITY_MESSAGE")); //$NON-NLS-1$
		T updatedEntity = null;
		try {
			updatedEntity = (T) getDelegatedDao().update(newState);
		} catch (Exception e) {
			throw new ApplicationException.InternalError(e);
		}
		return Response.ok(updatedEntity).build();
	}
	
	@SuppressWarnings("unchecked")
	@DELETE
	public Response deleteItem() throws ApplicationException {
		ServiceUtils.validarArgumento(this.key, Messages.getString("WritableResource.REQUIRED_KEY_FOR_DELETE_MESSAGE")); //$NON-NLS-1$
		try {
			this.getDelegatedDao().delete(this.key);
		} catch (Exception e) {
			throw new ApplicationException.InternalError(e);
		}
		return Response.ok().build();
	}
}
