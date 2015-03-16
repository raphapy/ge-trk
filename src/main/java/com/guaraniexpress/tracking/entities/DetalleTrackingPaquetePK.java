package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detalle_tracking_paquete database table.
 * 
 */
@Embeddable
public class DetalleTrackingPaquetePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_detalle_tracking_paquete")
	private int idDetalleTrackingPaquete;

	@Column(name="tracking_paquete", insertable=false, updatable=false)
	private int trackingPaquete;

	public DetalleTrackingPaquetePK() {
	}
	public int getIdDetalleTrackingPaquete() {
		return this.idDetalleTrackingPaquete;
	}
	public void setIdDetalleTrackingPaquete(int idDetalleTrackingPaquete) {
		this.idDetalleTrackingPaquete = idDetalleTrackingPaquete;
	}
	public int getTrackingPaquete() {
		return this.trackingPaquete;
	}
	public void setTrackingPaquete(int trackingPaquete) {
		this.trackingPaquete = trackingPaquete;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleTrackingPaquetePK)) {
			return false;
		}
		DetalleTrackingPaquetePK castOther = (DetalleTrackingPaquetePK)other;
		return 
			(this.idDetalleTrackingPaquete == castOther.idDetalleTrackingPaquete)
			&& (this.trackingPaquete == castOther.trackingPaquete);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDetalleTrackingPaquete;
		hash = hash * prime + this.trackingPaquete;
		
		return hash;
	}
}