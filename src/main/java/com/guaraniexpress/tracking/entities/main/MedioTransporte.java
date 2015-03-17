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
@Table(name = "medio_transporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioTransporte.findAll", query = "SELECT m FROM MedioTransporte m"),
    @NamedQuery(name = "MedioTransporte.findByIdMedioTransporte", query = "SELECT m FROM MedioTransporte m WHERE m.idMedioTransporte = :idMedioTransporte"),
    @NamedQuery(name = "MedioTransporte.findByNombre", query = "SELECT m FROM MedioTransporte m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "MedioTransporte.findByDescripcion", query = "SELECT m FROM MedioTransporte m WHERE m.descripcion = :descripcion")})
public class MedioTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medio_transporte")
    private Integer idMedioTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "medioTransporte")
    private List<Carga> cargaList;

    public MedioTransporte() {
    }

    public MedioTransporte(Integer idMedioTransporte) {
        this.idMedioTransporte = idMedioTransporte;
    }

    public MedioTransporte(Integer idMedioTransporte, String nombre) {
        this.idMedioTransporte = idMedioTransporte;
        this.nombre = nombre;
    }

    public Integer getIdMedioTransporte() {
        return idMedioTransporte;
    }

    public void setIdMedioTransporte(Integer idMedioTransporte) {
        this.idMedioTransporte = idMedioTransporte;
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
    public List<Carga> getCargaList() {
        return cargaList;
    }

    public void setCargaList(List<Carga> cargaList) {
        this.cargaList = cargaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedioTransporte != null ? idMedioTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioTransporte)) {
            return false;
        }
        MedioTransporte other = (MedioTransporte) object;
        if ((this.idMedioTransporte == null && other.idMedioTransporte != null) || (this.idMedioTransporte != null && !this.idMedioTransporte.equals(other.idMedioTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.MedioTransporte[ idMedioTransporte=" + idMedioTransporte + " ]";
    }
    
}
