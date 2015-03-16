/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tipo_informacion_contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInformacionContacto.findAll", query = "SELECT t FROM TipoInformacionContacto t"),
    @NamedQuery(name = "TipoInformacionContacto.findByIdTipoInformacionContacto", query = "SELECT t FROM TipoInformacionContacto t WHERE t.idTipoInformacionContacto = :idTipoInformacionContacto"),
    @NamedQuery(name = "TipoInformacionContacto.findByNombre", query = "SELECT t FROM TipoInformacionContacto t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoInformacionContacto.findByDescripcion", query = "SELECT t FROM TipoInformacionContacto t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoInformacionContacto.findByFormato", query = "SELECT t FROM TipoInformacionContacto t WHERE t.formato = :formato")})
public class TipoInformacionContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_informacion_contacto")
    private Integer idTipoInformacionContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "formato")
    private String formato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoInformacionContacto")
    private List<InformacionContactoPersona> informacionContactoPersonaList;

    public TipoInformacionContacto() {
    }

    public TipoInformacionContacto(Integer idTipoInformacionContacto) {
        this.idTipoInformacionContacto = idTipoInformacionContacto;
    }

    public TipoInformacionContacto(Integer idTipoInformacionContacto, String nombre, String formato) {
        this.idTipoInformacionContacto = idTipoInformacionContacto;
        this.nombre = nombre;
        this.formato = formato;
    }

    public Integer getIdTipoInformacionContacto() {
        return idTipoInformacionContacto;
    }

    public void setIdTipoInformacionContacto(Integer idTipoInformacionContacto) {
        this.idTipoInformacionContacto = idTipoInformacionContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @XmlTransient
    public List<InformacionContactoPersona> getInformacionContactoPersonaList() {
        return informacionContactoPersonaList;
    }

    public void setInformacionContactoPersonaList(List<InformacionContactoPersona> informacionContactoPersonaList) {
        this.informacionContactoPersonaList = informacionContactoPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoInformacionContacto != null ? idTipoInformacionContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInformacionContacto)) {
            return false;
        }
        TipoInformacionContacto other = (TipoInformacionContacto) object;
        if ((this.idTipoInformacionContacto == null && other.idTipoInformacionContacto != null) || (this.idTipoInformacionContacto != null && !this.idTipoInformacionContacto.equals(other.idTipoInformacionContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.TipoInformacionContacto[ idTipoInformacionContacto=" + idTipoInformacionContacto + " ]";
    }
    
}
