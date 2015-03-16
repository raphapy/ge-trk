package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ciudad database table.
 * 
 */
@Embeddable
public class CiudadPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_ciudad")
	private int idCiudad;

	@Column(insertable=false, updatable=false)
	private int localidad;

	@Column(insertable=false, updatable=false)
	private int pais;

	public CiudadPK() {
	}
	public int getIdCiudad() {
		return this.idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public int getLocalidad() {
		return this.localidad;
	}
	public void setLocalidad(int localidad) {
		this.localidad = localidad;
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
		if (!(other instanceof CiudadPK)) {
			return false;
		}
		CiudadPK castOther = (CiudadPK)other;
		return 
			(this.idCiudad == castOther.idCiudad)
			&& (this.localidad == castOther.localidad)
			&& (this.pais == castOther.pais);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCiudad;
		hash = hash * prime + this.localidad;
		hash = hash * prime + this.pais;
		
		return hash;
	}
}