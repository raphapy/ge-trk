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
public class DetalleTrackingCargaPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4871752008436994445L;
	@Basic(optional = false)
    @Column(name = "id_detalle_tracking_carga")
    private short idDetalleTrackingCarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tracking_carga")
    private int trackingCarga;

    public DetalleTrackingCargaPK() {
    }

    public DetalleTrackingCargaPK(short idDetalleTrackingCarga, int trackingCarga) {
        this.idDetalleTrackingCarga = idDetalleTrackingCarga;
        this.trackingCarga = trackingCarga;
    }

    public short getIdDetalleTrackingCarga() {
        return idDetalleTrackingCarga;
    }

    public void setIdDetalleTrackingCarga(short idDetalleTrackingCarga) {
        this.idDetalleTrackingCarga = idDetalleTrackingCarga;
    }

    public int getTrackingCarga() {
        return trackingCarga;
    }

    public void setTrackingCarga(int trackingCarga) {
        this.trackingCarga = trackingCarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetalleTrackingCarga;
        hash += (int) trackingCarga;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTrackingCargaPK)) {
            return false;
        }
        DetalleTrackingCargaPK other = (DetalleTrackingCargaPK) object;
        if (this.idDetalleTrackingCarga != other.idDetalleTrackingCarga) {
            return false;
        }
        if (this.trackingCarga != other.trackingCarga) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.DetalleTrackingCargaPK[ idDetalleTrackingCarga=" + idDetalleTrackingCarga + ", trackingCarga=" + trackingCarga + " ]";
    }
    
}
