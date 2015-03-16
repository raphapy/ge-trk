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
public class InformacionContactoPersonaPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6882493488184104325L;
	@Basic(optional = false)
    @Column(name = "id_informacion_contacto_persona")
    private int idInformacionContactoPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "persona")
    private int persona;

    public InformacionContactoPersonaPK() {
    }

    public InformacionContactoPersonaPK(int idInformacionContactoPersona, int persona) {
        this.idInformacionContactoPersona = idInformacionContactoPersona;
        this.persona = persona;
    }

    public int getIdInformacionContactoPersona() {
        return idInformacionContactoPersona;
    }

    public void setIdInformacionContactoPersona(int idInformacionContactoPersona) {
        this.idInformacionContactoPersona = idInformacionContactoPersona;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInformacionContactoPersona;
        hash += (int) persona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionContactoPersonaPK)) {
            return false;
        }
        InformacionContactoPersonaPK other = (InformacionContactoPersonaPK) object;
        if (this.idInformacionContactoPersona != other.idInformacionContactoPersona) {
            return false;
        }
        if (this.persona != other.persona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.InformacionContactoPersonaPK[ idInformacionContactoPersona=" + idInformacionContactoPersona + ", persona=" + persona + " ]";
    }
    
}
