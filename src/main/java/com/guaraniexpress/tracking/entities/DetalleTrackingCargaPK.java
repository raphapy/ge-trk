package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_tracking_carga database table.
 * 
 */
@Embeddable
public class DetalleTrackingCargaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_detalle_tracking_carga")
	private int idDetalleTrackingCarga;

	@Column(name="tracking_carga", insertable=false, updatable=false)
	private int trackingCarga;

	public DetalleTrackingCargaPK() {
	}
	public int getIdDetalleTrackingCarga() {
		return this.idDetalleTrackingCarga;
	}
	public void setIdDetalleTrackingCarga(int idDetalleTrackingCarga) {
		this.idDetalleTrackingCarga = idDetalleTrackingCarga;
	}
	public int getTrackingCarga() {
		return this.trackingCarga;
	}
	public void setTrackingCarga(int trackingCarga) {
		this.trackingCarga = trackingCarga;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleTrackingCargaPK)) {
			return false;
		}
		DetalleTrackingCargaPK castOther = (DetalleTrackingCargaPK)other;
		return 
			(this.idDetalleTrackingCarga == castOther.idDetalleTrackingCarga)
			&& (this.trackingCarga == castOther.trackingCarga);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDetalleTrackingCarga;
		hash = hash * prime + this.trackingCarga;
		
		return hash;
	}
}