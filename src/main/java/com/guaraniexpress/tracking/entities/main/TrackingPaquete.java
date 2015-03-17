/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.main;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.guaraniexpress.tracking.entities.application.Usuario;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "tracking_paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrackingPaquete.findAll", query = "SELECT t FROM TrackingPaquete t"),
    @NamedQuery(name = "TrackingPaquete.findByPaquete", query = "SELECT t FROM TrackingPaquete t WHERE t.paquete = :paquete"),
    @NamedQuery(name = "TrackingPaquete.findByTrackingId", query = "SELECT t FROM TrackingPaquete t WHERE t.trackingId = :trackingId"),
    @NamedQuery(name = "TrackingPaquete.findByFechaCreacion", query = "SELECT t FROM TrackingPaquete t WHERE t.fechaCreacion = :fechaCreacion")})
public class TrackingPaquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "paquete")
    private Integer paquete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "tracking_id")
    private String trackingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackingPaquete1")
    private List<DetalleTrackingPaquete> detalleTrackingPaqueteList;
    @JoinColumn(name = "estado", referencedColumnName = "id_estado_tracking")
    @ManyToOne(optional = false)
    private EstadoTracking estado;
    @JoinColumn(name = "usuario_creacion", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioCreacion;
    @JoinColumn(name = "paquete", referencedColumnName = "id_paquete", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Paquete paquete1;

    public TrackingPaquete() {
    }

    public TrackingPaquete(Integer paquete) {
        this.paquete = paquete;
    }

    public TrackingPaquete(Integer paquete, String trackingId, Date fechaCreacion) {
        this.paquete = paquete;
        this.trackingId = trackingId;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getPaquete() {
        return paquete;
    }

    public void setPaquete(Integer paquete) {
        this.paquete = paquete;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlTransient
    public List<DetalleTrackingPaquete> getDetalleTrackingPaqueteList() {
        return detalleTrackingPaqueteList;
    }

    public void setDetalleTrackingPaqueteList(List<DetalleTrackingPaquete> detalleTrackingPaqueteList) {
        this.detalleTrackingPaqueteList = detalleTrackingPaqueteList;
    }

    public EstadoTracking getEstado() {
        return estado;
    }

    public void setEstado(EstadoTracking estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Usuario usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Paquete getPaquete1() {
        return paquete1;
    }

    public void setPaquete1(Paquete paquete1) {
        this.paquete1 = paquete1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paquete != null ? paquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrackingPaquete)) {
            return false;
        }
        TrackingPaquete other = (TrackingPaquete) object;
        if ((this.paquete == null && other.paquete != null) || (this.paquete != null && !this.paquete.equals(other.paquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.TrackingPaquete[ paquete=" + paquete + " ]";
    }
    
}
