/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.main;

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
@Table(name = "estado_tracking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoTracking.findAll", query = "SELECT e FROM EstadoTracking e"),
    @NamedQuery(name = "EstadoTracking.findByIdEstadoTracking", query = "SELECT e FROM EstadoTracking e WHERE e.idEstadoTracking = :idEstadoTracking"),
    @NamedQuery(name = "EstadoTracking.findByNombre", query = "SELECT e FROM EstadoTracking e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoTracking.findByDescripcion", query = "SELECT e FROM EstadoTracking e WHERE e.descripcion = :descripcion")})
public class EstadoTracking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_estado_tracking")
    private Integer idEstadoTracking;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private List<TrackingCarga> trackingCargaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private List<TrackingPaquete> trackingPaqueteList;

    public EstadoTracking() {
    }

    public EstadoTracking(Integer idEstadoTracking) {
        this.idEstadoTracking = idEstadoTracking;
    }

    public EstadoTracking(Integer idEstadoTracking, String nombre, String descripcion) {
        this.idEstadoTracking = idEstadoTracking;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoTracking() {
        return idEstadoTracking;
    }

    public void setIdEstadoTracking(Integer idEstadoTracking) {
        this.idEstadoTracking = idEstadoTracking;
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
    public List<TrackingCarga> getTrackingCargaList() {
        return trackingCargaList;
    }

    public void setTrackingCargaList(List<TrackingCarga> trackingCargaList) {
        this.trackingCargaList = trackingCargaList;
    }

    @XmlTransient
    public List<TrackingPaquete> getTrackingPaqueteList() {
        return trackingPaqueteList;
    }

    public void setTrackingPaqueteList(List<TrackingPaquete> trackingPaqueteList) {
        this.trackingPaqueteList = trackingPaqueteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoTracking != null ? idEstadoTracking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoTracking)) {
            return false;
        }
        EstadoTracking other = (EstadoTracking) object;
        if ((this.idEstadoTracking == null && other.idEstadoTracking != null) || (this.idEstadoTracking != null && !this.idEstadoTracking.equals(other.idEstadoTracking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.EstadoTracking[ idEstadoTracking=" + idEstadoTracking + " ]";
    }
    
}
