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
@Table(name = "tracking_carga", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrackingCarga.findAll", query = "SELECT t FROM TrackingCarga t"),
    @NamedQuery(name = "TrackingCarga.findByIdTrackingCarga", query = "SELECT t FROM TrackingCarga t WHERE t.idTrackingCarga = :idTrackingCarga"),
    @NamedQuery(name = "TrackingCarga.findByFechaCreacion", query = "SELECT t FROM TrackingCarga t WHERE t.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "TrackingCarga.findByTrackingId", query = "SELECT t FROM TrackingCarga t WHERE t.trackingId = :trackingId"),
    @NamedQuery(name = "TrackingCarga.findByCarga", query = "SELECT t FROM TrackingCarga t WHERE t.carga = :carga")})
public class TrackingCarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tracking_carga")
    private Integer idTrackingCarga;
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
    @Column(name = "carga")
    private int carga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackingCarga")
    private List<DetalleTrackingCarga> detalleTrackingCargaList;
    @JoinColumn(name = "usuario_creacion", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioCreacion;
    @JoinColumn(name = "estado", referencedColumnName = "id_estado_tracking")
    @ManyToOne(optional = false)
    private EstadoTracking estado;

    public TrackingCarga() {
    }

    public TrackingCarga(Integer idTrackingCarga) {
        this.idTrackingCarga = idTrackingCarga;
    }

    public TrackingCarga(Integer idTrackingCarga, Date fechaCreacion, String trackingId, int carga) {
        this.idTrackingCarga = idTrackingCarga;
        this.fechaCreacion = fechaCreacion;
        this.trackingId = trackingId;
        this.carga = carga;
    }

    public Integer getIdTrackingCarga() {
        return idTrackingCarga;
    }

    public void setIdTrackingCarga(Integer idTrackingCarga) {
        this.idTrackingCarga = idTrackingCarga;
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

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @XmlTransient
    public List<DetalleTrackingCarga> getDetalleTrackingCargaList() {
        return detalleTrackingCargaList;
    }

    public void setDetalleTrackingCargaList(List<DetalleTrackingCarga> detalleTrackingCargaList) {
        this.detalleTrackingCargaList = detalleTrackingCargaList;
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
        hash += (idTrackingCarga != null ? idTrackingCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrackingCarga)) {
            return false;
        }
        TrackingCarga other = (TrackingCarga) object;
        if ((this.idTrackingCarga == null && other.idTrackingCarga != null) || (this.idTrackingCarga != null && !this.idTrackingCarga.equals(other.idTrackingCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entity.main.TrackingCarga[ idTrackingCarga=" + idTrackingCarga + " ]";
    }
    
}
