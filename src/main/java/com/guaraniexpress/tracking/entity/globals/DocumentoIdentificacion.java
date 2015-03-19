/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entity.globals;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "documento_identificacion", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentoIdentificacion.findAll", query = "SELECT d FROM DocumentoIdentificacion d"),
    @NamedQuery(name = "DocumentoIdentificacion.findByIdDocumentoIdentificacion", query = "SELECT d FROM DocumentoIdentificacion d WHERE d.idDocumentoIdentificacion = :idDocumentoIdentificacion"),
    @NamedQuery(name = "DocumentoIdentificacion.findByNumero", query = "SELECT d FROM DocumentoIdentificacion d WHERE d.numero = :numero"),
    @NamedQuery(name = "DocumentoIdentificacion.findByPersona", query = "SELECT d FROM DocumentoIdentificacion d WHERE d.persona = :persona")})
public class DocumentoIdentificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento_identificacion")
    private Short idDocumentoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "persona")
    private int persona;
    @JoinColumn(name = "tipo_documento_identificacion", referencedColumnName = "id_tipo_documento_identificacion")
    @ManyToOne(optional = false)
    private TipoDocumentoIdentificacion tipoDocumentoIdentificacion;

    public DocumentoIdentificacion() {
    }

    public DocumentoIdentificacion(Short idDocumentoIdentificacion) {
        this.idDocumentoIdentificacion = idDocumentoIdentificacion;
    }

    public DocumentoIdentificacion(Short idDocumentoIdentificacion, String numero, int persona) {
        this.idDocumentoIdentificacion = idDocumentoIdentificacion;
        this.numero = numero;
        this.persona = persona;
    }

    public Short getIdDocumentoIdentificacion() {
        return idDocumentoIdentificacion;
    }

    public void setIdDocumentoIdentificacion(Short idDocumentoIdentificacion) {
        this.idDocumentoIdentificacion = idDocumentoIdentificacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public TipoDocumentoIdentificacion getTipoDocumentoIdentificacion() {
        return tipoDocumentoIdentificacion;
    }

    public void setTipoDocumentoIdentificacion(TipoDocumentoIdentificacion tipoDocumentoIdentificacion) {
        this.tipoDocumentoIdentificacion = tipoDocumentoIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocumentoIdentificacion != null ? idDocumentoIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoIdentificacion)) {
            return false;
        }
        DocumentoIdentificacion other = (DocumentoIdentificacion) object;
        if ((this.idDocumentoIdentificacion == null && other.idDocumentoIdentificacion != null) || (this.idDocumentoIdentificacion != null && !this.idDocumentoIdentificacion.equals(other.idDocumentoIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entity.globals.DocumentoIdentificacion[ idDocumentoIdentificacion=" + idDocumentoIdentificacion + " ]";
    }
    
}
