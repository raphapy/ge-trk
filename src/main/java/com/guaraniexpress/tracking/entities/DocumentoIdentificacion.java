/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "documento_identificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoIdentificacion.findAll", query = "SELECT d FROM DocumentoIdentificacion d"),
    @NamedQuery(name = "DocumentoIdentificacion.findByIdDocumentoIdentificacion", query = "SELECT d FROM DocumentoIdentificacion d WHERE d.documentoIdentificacionPK.idDocumentoIdentificacion = :idDocumentoIdentificacion"),
    @NamedQuery(name = "DocumentoIdentificacion.findByPersonaIdPersona", query = "SELECT d FROM DocumentoIdentificacion d WHERE d.documentoIdentificacionPK.personaIdPersona = :personaIdPersona"),
    @NamedQuery(name = "DocumentoIdentificacion.findByNumero", query = "SELECT d FROM DocumentoIdentificacion d WHERE d.numero = :numero")})
public class DocumentoIdentificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoIdentificacionPK documentoIdentificacionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "tipo_documento_identificacion", referencedColumnName = "id_tipo_documento_identificacion")
    @ManyToOne(optional = false)
    private TipoDocumentoIdentificacion tipoDocumentoIdentificacion;
    @JoinColumn(name = "persona_id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public DocumentoIdentificacion() {
    }

    public DocumentoIdentificacion(DocumentoIdentificacionPK documentoIdentificacionPK) {
        this.documentoIdentificacionPK = documentoIdentificacionPK;
    }

    public DocumentoIdentificacion(DocumentoIdentificacionPK documentoIdentificacionPK, String numero) {
        this.documentoIdentificacionPK = documentoIdentificacionPK;
        this.numero = numero;
    }

    public DocumentoIdentificacion(short idDocumentoIdentificacion, int personaIdPersona) {
        this.documentoIdentificacionPK = new DocumentoIdentificacionPK(idDocumentoIdentificacion, personaIdPersona);
    }

    public DocumentoIdentificacionPK getDocumentoIdentificacionPK() {
        return documentoIdentificacionPK;
    }

    public void setDocumentoIdentificacionPK(DocumentoIdentificacionPK documentoIdentificacionPK) {
        this.documentoIdentificacionPK = documentoIdentificacionPK;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoDocumentoIdentificacion getTipoDocumentoIdentificacion() {
        return tipoDocumentoIdentificacion;
    }

    public void setTipoDocumentoIdentificacion(TipoDocumentoIdentificacion tipoDocumentoIdentificacion) {
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoIdentificacionPK != null ? documentoIdentificacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoIdentificacion)) {
            return false;
        }
        DocumentoIdentificacion other = (DocumentoIdentificacion) object;
        if ((this.documentoIdentificacionPK == null && other.documentoIdentificacionPK != null) || (this.documentoIdentificacionPK != null && !this.documentoIdentificacionPK.equals(other.documentoIdentificacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.DocumentoIdentificacion[ documentoIdentificacionPK=" + documentoIdentificacionPK + " ]";
    }
    
}
