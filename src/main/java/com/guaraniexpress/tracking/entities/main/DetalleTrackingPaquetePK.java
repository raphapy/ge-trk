/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.main;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author raphapy
 */
@Embeddable
public class DetalleTrackingPaquetePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3616915572746456775L;
	@Basic(optional = false)
    @Column(name = "id_detalle_tracking_paquete")
    private short idDetalleTrackingPaquete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tracking_paquete")
    private int trackingPaquete;

    public DetalleTrackingPaquetePK() {
    }

    public DetalleTrackingPaquetePK(short idDetalleTrackingPaquete, int trackingPaquete) {
        this.idDetalleTrackingPaquete = idDetalleTrackingPaquete;
        this.trackingPaquete = trackingPaquete;
    }

    public short getIdDetalleTrackingPaquete() {
        return idDetalleTrackingPaquete;
    }

    public void setIdDetalleTrackingPaquete(short idDetalleTrackingPaquete) {
        this.idDetalleTrackingPaquete = idDetalleTrackingPaquete;
    }

    public int getTrackingPaquete() {
        return trackingPaquete;
    }

    public void setTrackingPaquete(int trackingPaquete) {
        this.trackingPaquete = trackingPaquete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetalleTrackingPaquete;
        hash += (int) trackingPaquete;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTrackingPaquetePK)) {
            return false;
        }
        DetalleTrackingPaquetePK other = (DetalleTrackingPaquetePK) object;
        if (this.idDetalleTrackingPaquete != other.idDetalleTrackingPaquete) {
            return false;
        }
        if (this.trackingPaquete != other.trackingPaquete) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.DetalleTrackingPaquetePK[ idDetalleTrackingPaquete=" + idDetalleTrackingPaquete + ", trackingPaquete=" + trackingPaquete + " ]";
    }
    
}
