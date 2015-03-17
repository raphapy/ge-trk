package com.guaraniexpress.tracking.utils;

import java.util.List;

import com.google.common.base.Strings;
import com.guaraniexpress.tracking.exceptions.ApplicationException;

/**
 * 
 * @author Ruben López
 *
 */
public final class ServiceUtils {

	private ServiceUtils() {
	}
    
	/**
	 * Valida si el argumento es no nulo o vacio
	 * @param argumento parametro a validar
	 * @param message   mensaje de validacion
	 * @return  argumento si es valido
	 * @throws ApplicationException
	 */
	public static String validarArgumento(String argumento, String message)
			throws ApplicationException {
		if (Strings.isNullOrEmpty(argumento)) {
			throw new ApplicationException.IllegalArgument(message);
		}
		return argumento;
	}
	
	/**
	 * Valida que el argumento no sea nulo
	 * @param argumento parametro a validar
	 * @param message    mensaje de validacion
	 * @return argumento si es valido
	 * @throws ApplicationException
	 */

	public static <T> T validarArgumento(T argumento, String message)
			throws ApplicationException {
		if (argumento == null) {
			throw new ApplicationException.IllegalArgument(message);
		}
		return argumento;
	}

	/**
	 * Valida si la expresion es True o False
	 * @param expression argumeto a validar
	 * @param message   mensaje de validacion
	 * @throws ApplicationException
	 */
	public static void validarArgumento(boolean expression, String message)
			throws ApplicationException {
		if (!expression) {
			throw new ApplicationException.IllegalArgument(message);
		}
	}
	
	
	
	/**
	 * Valida que el parametro no sea Nulo o vacio en caso que el objeto sea un array
	 * @param object argumento a validar si es encontrado
	 * @param message mensaje de validacion
	 * @return   object si es encontrado
	 * @throws ApplicationException
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T validarEncontrado(T object, String message) throws ApplicationException {
		if (object == null) {
			throw new ApplicationException.NotFound(message);
		} else if (object instanceof java.util.Collection) {
			if (((java.util.Collection)object).isEmpty()) {
				throw new ApplicationException.NotFound(message);
			}
		}
		
		return object;
	}
	
	
	/**
	 * Valida si el parametro tiene un unico elemento
	 * @param list el argumento a validar
	 * @param message  mensaje de error
	 * @return retorna el unico objeto en caso que sea unico 
	 * @throws ApplicationException
	 */
	
	public static <T> T validarUnico(List<T> list, String message) throws ApplicationException {
		if (list.size() > 1) {
			throw new ApplicationException.InternalError(message);
		}
		return list.get(0);
	}

}