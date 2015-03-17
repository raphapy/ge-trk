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
@Table(name = "tracking_carga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrackingCarga.findAll", query = "SELECT t FROM TrackingCarga t"),
    @NamedQuery(name = "TrackingCarga.findByCarga", query = "SELECT t FROM TrackingCarga t WHERE t.carga = :carga"),
    @NamedQuery(name = "TrackingCarga.findByTrackingId", query = "SELECT t FROM TrackingCarga t WHERE t.trackingId = :trackingId"),
    @NamedQuery(name = "TrackingCarga.findByFechaCreacion", query = "SELECT t FROM TrackingCarga t WHERE t.fechaCreacion = :fechaCreacion")})
public class TrackingCarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga")
    private Integer carga;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackingCarga1")
    private List<DetalleTrackingCarga> detalleTrackingCargaList;
    @JoinColumn(name = "estado", referencedColumnName = "id_estado_tracking")
    @ManyToOne(optional = false)
    private EstadoTracking estado;
    @JoinColumn(name = "usuario_creacion", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioCreacion;
    @JoinColumn(name = "carga", referencedColumnName = "id_carga", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Carga carga1;

    public TrackingCarga() {
    }

    public TrackingCarga(Integer carga) {
        this.carga = carga;
    }

    public TrackingCarga(Integer carga, String trackingId, Date fechaCreacion) {
        this.carga = carga;
        this.trackingId = trackingId;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCarga() {
        return carga;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
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
    public List<DetalleTrackingCarga> getDetalleTrackingCargaList() {
        return detalleTrackingCargaList;
    }

    public void setDetalleTrackingCargaList(List<DetalleTrackingCarga> detalleTrackingCargaList) {
        this.detalleTrackingCargaList = detalleTrackingCargaList;
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

    public Carga getCarga1() {
        return carga1;
    }

    public void setCarga1(Carga carga1) {
        this.carga1 = carga1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carga != null ? carga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrackingCarga)) {
            return false;
        }
        TrackingCarga other = (TrackingCarga) object;
        if ((this.carga == null && other.carga != null) || (this.carga != null && !this.carga.equals(other.carga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.TrackingCarga[ carga=" + carga + " ]";
    }
    
}
