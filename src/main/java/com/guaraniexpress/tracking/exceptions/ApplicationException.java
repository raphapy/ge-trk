package com.guaraniexpress.tracking.exceptions;

/**
 * 
 * @author Ruben Lopez
 *
 */
public abstract class ApplicationException extends Exception {

	private static final long serialVersionUID = 4183357516385092326L;
    /**
     * 
     */
	public ApplicationException() {
		super();
	}
    /**
     * 
     * @param message
     */
	public ApplicationException(String message) {
		super(message);
	}
    /**
     * 
     * @param message
     * @param cause
     */
	public ApplicationException(String message,  Throwable cause) {
		super(message, cause);
	}
    /**
     * 
     * @param cause
     */
	public ApplicationException(Throwable cause) {
		super(cause);
	}
  
	public static class InternalError extends ApplicationException {

		private static final long serialVersionUID = -3139036056656795230L;

		public InternalError(String message) {
			super(message);
		}

		public InternalError(String message,  Throwable cause) {
			super(message, cause);
		}

		public InternalError(Throwable cause) {
			super(cause);
		}

	}

	public static class IllegalArgument extends ApplicationException {

		private static final long serialVersionUID = -8765864922699868014L;

		public IllegalArgument(String message) {
			super(message);
		}

	}

	public static class NotFound extends ApplicationException {

		private static final long serialVersionUID = 1149303182428995606L;

		public NotFound(String message) {
			super(message);
		}
	}
	
	public static class NonUniqueResult extends ApplicationException {
		
		private static final long serialVersionUID = 1149303182428995606L;

		public NonUniqueResult(String message) {
			super(message);
		}
	}

    /**
     * Esta excepci&oacute;n se propaga para abortar la transacci&oacute;n
     * activa en un contexto EJB.
     * 
     * @param message
     * @author Rafael E. Benegas - rbenegas@konecta.com.py
     */
    @javax.ejb.ApplicationException(rollback=true)
	public static class AbortException extends ApplicationException {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -6589489222040812501L;

		public AbortException(String message) {
			super(message);
		}
		
		public AbortException(String message,  Throwable cause) {
			super(message, cause);
		}

		public AbortException(Throwable cause) {
			super(cause);
		}
	}
}