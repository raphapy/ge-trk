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
import javax.persistence.JoinColumns;
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
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByIdCiudad", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.idCiudad = :idCiudad"),
    @NamedQuery(name = "Ciudad.findByLocalidad", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.localidad = :localidad"),
    @NamedQuery(name = "Ciudad.findByPais", query = "SELECT c FROM Ciudad c WHERE c.ciudadPK.pais = :pais"),
    @NamedQuery(name = "Ciudad.findByCodigo", query = "SELECT c FROM Ciudad c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Ciudad.findByNombre", query = "SELECT c FROM Ciudad c WHERE c.nombre = :nombre")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CiudadPK ciudadPK;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<Persona> personaList;
    @JoinColumns({
        @JoinColumn(name = "localidad", referencedColumnName = "id_localidad", insertable = false, updatable = false),
        @JoinColumn(name = "pais", referencedColumnName = "pais", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Localidad localidad1;

    public Ciudad() {
    }

    public Ciudad(CiudadPK ciudadPK) {
        this.ciudadPK = ciudadPK;
    }

    public Ciudad(CiudadPK ciudadPK, String codigo, String nombre) {
        this.ciudadPK = ciudadPK;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Ciudad(short idCiudad, short localidad, short pais) {
        this.ciudadPK = new CiudadPK(idCiudad, localidad, pais);
    }

    public CiudadPK getCiudadPK() {
        return ciudadPK;
    }

    public void setCiudadPK(CiudadPK ciudadPK) {
        this.ciudadPK = ciudadPK;
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
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Localidad getLocalidad1() {
        return localidad1;
    }

    public void setLocalidad1(Localidad localidad1) {
        this.localidad1 = localidad1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ciudadPK != null ? ciudadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.ciudadPK == null && other.ciudadPK != null) || (this.ciudadPK != null && !this.ciudadPK.equals(other.ciudadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.Ciudad[ ciudadPK=" + ciudadPK + " ]";
    }
    
}
