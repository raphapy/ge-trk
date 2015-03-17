/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.globals;

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
public class LocalidadPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3854857248738999142L;
	@Basic(optional = false)
    @Column(name = "id_localidad")
    private short idLocalidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pais")
    private short pais;

    public LocalidadPK() {
    }

    public LocalidadPK(short idLocalidad, short pais) {
        this.idLocalidad = idLocalidad;
        this.pais = pais;
    }

    public short getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(short idLocalidad) {
        this.idLocalidad = idLocalidad;
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
        hash += (int) idLocalidad;
        hash += (int) pais;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocalidadPK)) {
            return false;
        }
        LocalidadPK other = (LocalidadPK) object;
        if (this.idLocalidad != other.idLocalidad) {
            return false;
        }
        if (this.pais != other.pais) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.LocalidadPK[ idLocalidad=" + idLocalidad + ", pais=" + pais + " ]";
    }
    
}
