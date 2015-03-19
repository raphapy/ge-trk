/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entity.main;

import com.guaraniexpress.tracking.entity.application.Usuario;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "tracking_paquete", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrackingPaquete.findAll", query = "SELECT t FROM TrackingPaquete t"),
    @NamedQuery(name = "TrackingPaquete.findByIdTrackingPaquete", query = "SELECT t FROM TrackingPaquete t WHERE t.idTrackingPaquete = :idTrackingPaquete"),
    @NamedQuery(name = "TrackingPaquete.findByFechaCreacion", query = "SELECT t FROM TrackingPaquete t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TrackingPaquete.findByTrackingId", query = "SELECT t FROM TrackingPaquete t WHERE t.trackingId = :trackingId"),
    @NamedQuery(name = "TrackingPaquete.findByPaquete", query = "SELECT t FROM TrackingPaquete t WHERE t.paquete = :paquete")})
public class TrackingPaquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tracking_paquete")
    private Integer idTrackingPaquete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "tracking_id")
    private String trackingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paquete")
    private int paquete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackingPaquete")
    private List<DetalleTrackingPaquete> detalleTrackingPaqueteList;
    @JoinColumn(name = "usuario_creacion", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioCreacion;
    @JoinColumn(name = "estado", referencedColumnName = "id_estado_tracking")
    @ManyToOne(optional = false)
    private EstadoTracking estado;

    public TrackingPaquete() {
    }

    public TrackingPaquete(Integer idTrackingPaquete) {
        this.idTrackingPaquete = idTrackingPaquete;
    }

    public TrackingPaquete(Integer idTrackingPaquete, Date fechaCreacion, String trackingId, int paquete) {
        this.idTrackingPaquete = idTrackingPaquete;
        this.fechaCreacion = fechaCreacion;
        this.trackingId = trackingId;
        this.paquete = paquete;
    }

    public Integer getIdTrackingPaquete() {
        return idTrackingPaquete;
    }

    public void setIdTrackingPaquete(Integer idTrackingPaquete) {
        this.idTrackingPaquete = idTrackingPaquete;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public int getPaquete() {
        return paquete;
    }

    public void setPaquete(int paquete) {
        this.paquete = paquete;
    }

    @XmlTransient
    public List<DetalleTrackingPaquete> getDetalleTrackingPaqueteList() {
        return detalleTrackingPaqueteList;
    }

    public void setDetalleTrackingPaqueteList(List<DetalleTrackingPaquete> detalleTrackingPaqueteList) {
        this.detalleTrackingPaqueteList = detalleTrackingPaqueteList;
    }

    public Usuario getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Usuario usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public EstadoTracking getEstado() {
        return estado;
    }

    public void setEstado(EstadoTracking estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrackingPaquete != null ? idTrackingPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrackingPaquete)) {
            return false;
        }
        TrackingPaquete other = (TrackingPaquete) object;
        if ((this.idTrackingPaquete == null && other.idTrackingPaquete != null) || (this.idTrackingPaquete != null && !this.idTrackingPaquete.equals(other.idTrackingPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entity.main.TrackingPaquete[ idTrackingPaquete=" + idTrackingPaquete + " ]";
    }
    
}
