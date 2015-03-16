package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the documento_identificacion database table.
 * 
 */
@Embeddable
public class DocumentoIdentificacionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_documento_identificacion")
	private int idDocumentoIdentificacion;

	@Column(name="persona_id_persona", insertable=false, updatable=false)
	private int personaIdPersona;

	public DocumentoIdentificacionPK() {
	}
	public int getIdDocumentoIdentificacion() {
		return this.idDocumentoIdentificacion;
	}
	public void setIdDocumentoIdentificacion(int idDocumentoIdentificacion) {
		this.idDocumentoIdentificacion = idDocumentoIdentificacion;
	}
	public int getPersonaIdPersona() {
		return this.personaIdPersona;
	}
	public void setPersonaIdPersona(int personaIdPersona) {
		this.personaIdPersona = personaIdPersona;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DocumentoIdentificacionPK)) {
			return false;
		}
		DocumentoIdentificacionPK castOther = (DocumentoIdentificacionPK)other;
		return 
			(this.idDocumentoIdentificacion == castOther.idDocumentoIdentificacion)
			&& (this.personaIdPersona == castOther.personaIdPersona);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDocumentoIdentificacion;
		hash = hash * prime + this.personaIdPersona;
		
		return hash;
	}
}