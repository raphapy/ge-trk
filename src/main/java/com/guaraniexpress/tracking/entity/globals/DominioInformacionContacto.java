/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entity.globals;

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
@Table(name = "dominio_informacion_contacto", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DominioInformacionContacto.findAll", query = "SELECT d FROM DominioInformacionContacto d"),
    @NamedQuery(name = "DominioInformacionContacto.findByIdDominioInformacionContacto", query = "SELECT d FROM DominioInformacionContacto d WHERE d.idDominioInformacionContacto = :idDominioInformacionContacto"),
    @NamedQuery(name = "DominioInformacionContacto.findByNombre", query = "SELECT d FROM DominioInformacionContacto d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DominioInformacionContacto.findByDescripcion", query = "SELECT d FROM DominioInformacionContacto d WHERE d.descripcion = :descripcion")})
public class DominioInformacionContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_dominio_informacion_contacto")
    private Integer idDominioInformacionContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dominioInformacionContacto")
    private List<InformacionContactoPersona> informacionContactoPersonaList;

    public DominioInformacionContacto() {
    }

    public DominioInformacionContacto(Integer idDominioInformacionContacto) {
        this.idDominioInformacionContacto = idDominioInformacionContacto;
    }

    public DominioInformacionContacto(Integer idDominioInformacionContacto, String nombre) {
        this.idDominioInformacionContacto = idDominioInformacionContacto;
        this.nombre = nombre;
    }

    public Integer getIdDominioInformacionContacto() {
        return idDominioInformacionContacto;
    }

    public void setIdDominioInformacionContacto(Integer idDominioInformacionContacto) {
        this.idDominioInformacionContacto = idDominioInformacionContacto;
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
        hash += (idDominioInformacionContacto != null ? idDominioInformacionContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DominioInformacionContacto)) {
            return false;
        }
        DominioInformacionContacto other = (DominioInformacionContacto) object;
        if ((this.idDominioInformacionContacto == null && other.idDominioInformacionContacto != null) || (this.idDominioInformacionContacto != null && !this.idDominioInformacionContacto.equals(other.idDominioInformacionContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entity.globals.DominioInformacionContacto[ idDominioInformacionContacto=" + idDominioInformacionContacto + " ]";
    }
    
}
