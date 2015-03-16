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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "localidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Localidad.findAll", query = "SELECT l FROM Localidad l"),
    @NamedQuery(name = "Localidad.findByIdLocalidad", query = "SELECT l FROM Localidad l WHERE l.localidadPK.idLocalidad = :idLocalidad"),
    @NamedQuery(name = "Localidad.findByPais", query = "SELECT l FROM Localidad l WHERE l.localidadPK.pais = :pais"),
    @NamedQuery(name = "Localidad.findByCodigo", query = "SELECT l FROM Localidad l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "Localidad.findByNombre", query = "SELECT l FROM Localidad l WHERE l.nombre = :nombre")})
public class Localidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocalidadPK localidadPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localidad1")
    private List<Ciudad> ciudadList;
    @JoinColumn(name = "pais", referencedColumnName = "id_pais", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pais pais1;

    public Localidad() {
    }

    public Localidad(LocalidadPK localidadPK) {
        this.localidadPK = localidadPK;
    }

    public Localidad(LocalidadPK localidadPK, String codigo, String nombre) {
        this.localidadPK = localidadPK;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Localidad(short idLocalidad, short pais) {
        this.localidadPK = new LocalidadPK(idLocalidad, pais);
    }

    public LocalidadPK getLocalidadPK() {
        return localidadPK;
    }

    public void setLocalidadPK(LocalidadPK localidadPK) {
        this.localidadPK = localidadPK;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public Pais getPais1() {
        return pais1;
    }

    public void setPais1(Pais pais1) {
        this.pais1 = pais1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (localidadPK != null ? localidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Localidad)) {
            return false;
        }
        Localidad other = (Localidad) object;
        if ((this.localidadPK == null && other.localidadPK != null) || (this.localidadPK != null && !this.localidadPK.equals(other.localidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.Localidad[ localidadPK=" + localidadPK + " ]";
    }
    
}
