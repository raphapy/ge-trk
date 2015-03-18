/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.globals;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "tipo_documento_identificacion", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDocumentoIdentificacion.findAll", query = "SELECT t FROM TipoDocumentoIdentificacion t"),
    @NamedQuery(name = "TipoDocumentoIdentificacion.findByIdTipoDocumentoIdentificacion", query = "SELECT t FROM TipoDocumentoIdentificacion t WHERE t.idTipoDocumentoIdentificacion = :idTipoDocumentoIdentificacion"),
    @NamedQuery(name = "TipoDocumentoIdentificacion.findByDescripcion", query = "SELECT t FROM TipoDocumentoIdentificacion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoDocumentoIdentificacion.findByFormato", query = "SELECT t FROM TipoDocumentoIdentificacion t WHERE t.formato = :formato"),
    @NamedQuery(name = "TipoDocumentoIdentificacion.findByNombre", query = "SELECT t FROM TipoDocumentoIdentificacion t WHERE t.nombre = :nombre")})
public class TipoDocumentoIdentificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_documento_identificacion")
    private Short idTipoDocumentoIdentificacion;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "formato")
    private String formato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumentoIdentificacion")
    private List<DocumentoIdentificacion> documentoIdentificacionList;

    public TipoDocumentoIdentificacion() {
    }

    public TipoDocumentoIdentificacion(Short idTipoDocumentoIdentificacion) {
        this.idTipoDocumentoIdentificacion = idTipoDocumentoIdentificacion;
    }

    public TipoDocumentoIdentificacion(Short idTipoDocumentoIdentificacion, String formato, String nombre) {
        this.idTipoDocumentoIdentificacion = idTipoDocumentoIdentificacion;
        this.formato = formato;
        this.nombre = nombre;
    }

    public Short getIdTipoDocumentoIdentificacion() {
        return idTipoDocumentoIdentificacion;
    }

    public void setIdTipoDocumentoIdentificacion(Short idTipoDocumentoIdentificacion) {
        this.idTipoDocumentoIdentificacion = idTipoDocumentoIdentificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<DocumentoIdentificacion> getDocumentoIdentificacionList() {
        return documentoIdentificacionList;
    }

    public void setDocumentoIdentificacionList(List<DocumentoIdentificacion> documentoIdentificacionList) {
        this.documentoIdentificacionList = documentoIdentificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDocumentoIdentificacion != null ? idTipoDocumentoIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDocumentoIdentificacion)) {
            return false;
        }
        TipoDocumentoIdentificacion other = (TipoDocumentoIdentificacion) object;
        if ((this.idTipoDocumentoIdentificacion == null && other.idTipoDocumentoIdentificacion != null) || (this.idTipoDocumentoIdentificacion != null && !this.idTipoDocumentoIdentificacion.equals(other.idTipoDocumentoIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entities.globals.TipoDocumentoIdentificacion[ idTipoDocumentoIdentificacion=" + idTipoDocumentoIdentificacion + " ]";
    }
    
}
