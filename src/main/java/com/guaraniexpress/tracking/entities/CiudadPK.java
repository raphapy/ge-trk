/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities;

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
public class CiudadPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 9159511968324366202L;
	@Basic(optional = false)
    @Column(name = "id_ciudad")
    private short idCiudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "localidad")
    private short localidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pais")
    private short pais;

    public CiudadPK() {
    }

    public CiudadPK(short idCiudad, short localidad, short pais) {
        this.idCiudad = idCiudad;
        this.localidad = localidad;
        this.pais = pais;
    }

    public short getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(short idCiudad) {
        this.idCiudad = idCiudad;
    }

    public short getLocalidad() {
        return localidad;
    }

    public void setLocalidad(short localidad) {
        this.localidad = localidad;
    }

    public short getPais() {
        return pais;
    }

    public void setPais(short pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCiudad;
        hash += (int) localidad;
        hash += (int) pais;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiudadPK)) {
            return false;
        }
        CiudadPK other = (CiudadPK) object;
        if (this.idCiudad != other.idCiudad) {
            return false;
        }
        if (this.localidad != other.localidad) {
            return false;
        }
        if (this.pais != other.pais) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.CiudadPK[ idCiudad=" + idCiudad + ", localidad=" + localidad + ", pais=" + pais + " ]";
    }
    
}
