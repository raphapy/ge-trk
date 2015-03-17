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
@Table(name = "evento_tracking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EventoTracking.findAll", query = "SELECT e FROM EventoTracking e"),
    @NamedQuery(name = "EventoTracking.findByIdEventoTracking", query = "SELECT e FROM EventoTracking e WHERE e.idEventoTracking = :idEventoTracking"),
    @NamedQuery(name = "EventoTracking.findByNombre", query = "SELECT e FROM EventoTracking e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EventoTracking.findByDescripcion", query = "SELECT e FROM EventoTracking e WHERE e.descripcion = :descripcion")})
public class EventoTracking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_evento_tracking")
    private Integer idEventoTracking;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoTracking")
    private List<DetalleTrackingPaquete> detalleTrackingPaqueteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventoTracking")
    private List<DetalleTrackingCarga> detalleTrackingCargaList;

    public EventoTracking() {
    }

    public EventoTracking(Integer idEventoTracking) {
        this.idEventoTracking = idEventoTracking;
    }

    public EventoTracking(Integer idEventoTracking, String nombre, String descripcion) {
        this.idEventoTracking = idEventoTracking;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdEventoTracking() {
        return idEventoTracking;
    }

    public void setIdEventoTracking(Integer idEventoTracking) {
        this.idEventoTracking = idEventoTracking;
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
    public List<DetalleTrackingPaquete> getDetalleTrackingPaqueteList() {
        return detalleTrackingPaqueteList;
    }

    public void setDetalleTrackingPaqueteList(List<DetalleTrackingPaquete> detalleTrackingPaqueteList) {
        this.detalleTrackingPaqueteList = detalleTrackingPaqueteList;
    }

    @XmlTransient
    public List<DetalleTrackingCarga> getDetalleTrackingCargaList() {
        return detalleTrackingCargaList;
    }

    public void setDetalleTrackingCargaList(List<DetalleTrackingCarga> detalleTrackingCargaList) {
        this.detalleTrackingCargaList = detalleTrackingCargaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEventoTracking != null ? idEventoTracking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventoTracking)) {
            return false;
        }
        EventoTracking other = (EventoTracking) object;
        if ((this.idEventoTracking == null && other.idEventoTracking != null) || (this.idEventoTracking != null && !this.idEventoTracking.equals(other.idEventoTracking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.EventoTracking[ idEventoTracking=" + idEventoTracking + " ]";
    }
    
}
