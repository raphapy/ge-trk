/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.main;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "courrier_externo", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourrierExterno.findAll", query = "SELECT c FROM CourrierExterno c"),
    @NamedQuery(name = "CourrierExterno.findByIdCourrierExterno", query = "SELECT c FROM CourrierExterno c WHERE c.idCourrierExterno = :idCourrierExterno"),
    @NamedQuery(name = "CourrierExterno.findByNombre", query = "SELECT c FROM CourrierExterno c WHERE c.nombre = :nombre")})
public class CourrierExterno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_courrier_externo")
    private Short idCourrierExterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "courrierExterno")
    private List<Carga> cargaList;
    @OneToMany(mappedBy = "courrierExterno")
    private List<Paquete> paqueteList;

    public CourrierExterno() {
    }

    public CourrierExterno(Short idCourrierExterno) {
        this.idCourrierExterno = idCourrierExterno;
    }

    public CourrierExterno(Short idCourrierExterno, String nombre) {
        this.idCourrierExterno = idCourrierExterno;
        this.nombre = nombre;
    }

    public Short getIdCourrierExterno() {
        return idCourrierExterno;
    }

    public void setIdCourrierExterno(Short idCourrierExterno) {
        this.idCourrierExterno = idCourrierExterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Carga> getCargaList() {
        return cargaList;
    }

    public void setCargaList(List<Carga> cargaList) {
        this.cargaList = cargaList;
    }

    @XmlTransient
    public List<Paquete> getPaqueteList() {
        return paqueteList;
    }

    public void setPaqueteList(List<Paquete> paqueteList) {
        this.paqueteList = paqueteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCourrierExterno != null ? idCourrierExterno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourrierExterno)) {
            return false;
        }
        CourrierExterno other = (CourrierExterno) object;
        if ((this.idCourrierExterno == null && other.idCourrierExterno != null) || (this.idCourrierExterno != null && !this.idCourrierExterno.equals(other.idCourrierExterno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entities.main.CourrierExterno[ idCourrierExterno=" + idCourrierExterno + " ]";
    }
    
}
