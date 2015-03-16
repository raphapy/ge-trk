package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the informacion_contacto_persona database table.
 * 
 */
@Embeddable
public class InformacionContactoPersonaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_informacion_contacto_persona")
	private int idInformacionContactoPersona;

	@Column(insertable=false, updatable=false)
	private int persona;

	public InformacionContactoPersonaPK() {
	}
	public int getIdInformacionContactoPersona() {
		return this.idInformacionContactoPersona;
	}
	public void setIdInformacionContactoPersona(int idInformacionContactoPersona) {
		this.idInformacionContactoPersona = idInformacionContactoPersona;
	}
	public int getPersona() {
		return this.persona;
	}
	public void setPersona(int persona) {
		this.persona = persona;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InformacionContactoPersonaPK)) {
			return false;
		}
		InformacionContactoPersonaPK castOther = (InformacionContactoPersonaPK)other;
		return 
			(this.idInformacionContactoPersona == castOther.idInformacionContactoPersona)
			&& (this.persona == castOther.persona);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idInformacionContactoPersona;
		hash = hash * prime + this.persona;
		
		return hash;
	}
}