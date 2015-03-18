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
@Table(name = "tipo_informacion_contacto", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInformacionContacto.findAll", query = "SELECT t FROM TipoInformacionContacto t"),
    @NamedQuery(name = "TipoInformacionContacto.findByIdTipoInformacionContacto", query = "SELECT t FROM TipoInformacionContacto t WHERE t.idTipoInformacionContacto = :idTipoInformacionContacto"),
    @NamedQuery(name = "TipoInformacionContacto.findByDescripcion", query = "SELECT t FROM TipoInformacionContacto t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoInformacionContacto.findByFormato", query = "SELECT t FROM TipoInformacionContacto t WHERE t.formato = :formato"),
    @NamedQuery(name = "TipoInformacionContacto.findByNombre", query = "SELECT t FROM TipoInformacionContacto t WHERE t.nombre = :nombre")})
public class TipoInformacionContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_informacion_contacto")
    private Integer idTipoInformacionContacto;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoInformacionContacto")
    private List<InformacionContactoPersona> informacionContactoPersonaList;

    public TipoInformacionContacto() {
    }

    public TipoInformacionContacto(Integer idTipoInformacionContacto) {
        this.idTipoInformacionContacto = idTipoInformacionContacto;
    }

    public TipoInformacionContacto(Integer idTipoInformacionContacto, String formato, String nombre) {
        this.idTipoInformacionContacto = idTipoInformacionContacto;
        this.formato = formato;
        this.nombre = nombre;
    }

    public Integer getIdTipoInformacionContacto() {
        return idTipoInformacionContacto;
    }

    public void setIdTipoInformacionContacto(Integer idTipoInformacionContacto) {
        this.idTipoInformacionContacto = idTipoInformacionContacto;
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
        return "com.guaraniexpress.tracking.entities.globals.TipoInformacionContacto[ idTipoInformacionContacto=" + idTipoInformacionContacto + " ]";
    }
    
}
