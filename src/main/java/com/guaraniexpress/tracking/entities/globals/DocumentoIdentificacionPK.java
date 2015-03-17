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
public class DocumentoIdentificacionPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8433023122765970824L;
	@Basic(optional = false)
    @Column(name = "id_documento_identificacion")
    private short idDocumentoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "persona_id_persona")
    private int personaIdPersona;

    public DocumentoIdentificacionPK() {
    }

    public DocumentoIdentificacionPK(short idDocumentoIdentificacion, int personaIdPersona) {
        this.idDocumentoIdentificacion = idDocumentoIdentificacion;
        this.personaIdPersona = personaIdPersona;
    }

    public short getIdDocumentoIdentificacion() {
        return idDocumentoIdentificacion;
    }

    public void setIdDocumentoIdentificacion(short idDocumentoIdentificacion) {
        this.idDocumentoIdentificacion = idDocumentoIdentificacion;
    }

    public int getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(int personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDocumentoIdentificacion;
        hash += (int) personaIdPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoIdentificacionPK)) {
            return false;
        }
        DocumentoIdentificacionPK other = (DocumentoIdentificacionPK) object;
        if (this.idDocumentoIdentificacion != other.idDocumentoIdentificacion) {
            return false;
        }
        if (this.personaIdPersona != other.personaIdPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.DocumentoIdentificacionPK[ idDocumentoIdentificacion=" + idDocumentoIdentificacion + ", personaIdPersona=" + personaIdPersona + " ]";
    }
    
}
