package com.guaraniexpress.tracking.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Strings;

/**
 * Excepcion a propagar cuando ocurra alguna exccepcion de regla de negocio.
 * @author Rafael Benegas
 *
 */
public abstract class BusinessException extends Exception {
	
	private static final long serialVersionUID = 9122458587681754074L;
	
	public BusinessException(String message) {
		super(message);
	}
	
	/**
	 * Esta clase representa a una violacion de una o mas reglas de negocio relacionadas a
	 * restricciones del modelo
	 * @author Rafael Benegas
	 *
	 */
	public static class ModelValidationException extends BusinessException {

		private static final long serialVersionUID = 1149303182428995606L;
		
		/**
		 * 
		 * @param message Mensaje general de la excepcion.
		 * @param violationMessages representa la lista de violaciones o contraints que fueron violadas.
		 */
		public ModelValidationException(String message, List<String> violationMessages) {
			
			super(message);
			
			if (violationMessages!=null && violationMessages.size()>0) {
				this.violationMessages = violationMessages;
			} else {
				this.violationMessages = new ArrayList<String>();
			}
		}
		
		/**
		 * 
		 * @param message Mensaje general de la excepcion.
		 * @param violationMessages representa la lista de violaciones o contraints que fueron violadas.
		 */
		public ModelValidationException(String message, String violation) {
			
			super(message);
			
			if (!Strings.isNullOrEmpty(violation)) {
				
				this.violationMessages = new ArrayList<String>();
				this.violationMessages.add(violation);
				
			} else {
				
				this.violationMessages = new ArrayList<String>();
				
			}
		}
		
		private List<String> violationMessages;
		
		public List<String> getViolationMessages() {
			return violationMessages;
		}
		
		public void setViolationMessages(List<String> violationMessages) {
			this.violationMessages = violationMessages;
		}
	}
	
	/**
	 * Esta clase representa a una violacion de una regla de negocios.
	 * 
	 * @author Rafael Benegas
	 *
	 */
	public static class RuleValidationException extends BusinessException {

		private static final long serialVersionUID = 1149303182428995606L;
		
		/**
		 * 
		 * @param message Mensaje general de la excepcion.
		 * @param violation representa la violacion cometida sobre una regla de negocio.
		 */
		public RuleValidationException(String violation) {
			super(violation);
		}
	}
}
