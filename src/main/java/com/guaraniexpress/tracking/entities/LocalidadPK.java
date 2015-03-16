package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the localidad database table.
 * 
 */
@Embeddable
public class LocalidadPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_localidad")
	private int idLocalidad;

	@Column(insertable=false, updatable=false)
	private int pais;

	public LocalidadPK() {
	}
	public int getIdLocalidad() {
		return this.idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public int getPais() {
		return this.pais;
	}
	public void setPais(int pais) {
		this.pais = pais;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LocalidadPK)) {
			return false;
		}
		LocalidadPK castOther = (LocalidadPK)other;
		return 
			(this.idLocalidad == castOther.idLocalidad)
			&& (this.pais == castOther.pais);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idLocalidad;
		hash = hash * prime + this.pais;
		
		return hash;
	}
}