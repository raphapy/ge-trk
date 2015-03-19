/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entity.main;

import com.guaraniexpress.tracking.entity.application.Usuario;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "detalle_tracking_carga", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleTrackingCarga.findAll", query = "SELECT d FROM DetalleTrackingCarga d"),
    @NamedQuery(name = "DetalleTrackingCarga.findByIdDetalleTrackingCarga", query = "SELECT d FROM DetalleTrackingCarga d WHERE d.idDetalleTrackingCarga = :idDetalleTrackingCarga"),
    @NamedQuery(name = "DetalleTrackingCarga.findByFechaHora", query = "SELECT d FROM DetalleTrackingCarga d WHERE d.fechaHora = :fechaHora")})
public class DetalleTrackingCarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_tracking_carga")
    private Short idDetalleTrackingCarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinColumn(name = "usuario_evento", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioEvento;
    @JoinColumn(name = "tracking_carga", referencedColumnName = "id_tracking_carga")
    @ManyToOne(optional = false)
    private TrackingCarga trackingCarga;
    @JoinColumn(name = "evento_tracking", referencedColumnName = "id_evento_tracking")
    @ManyToOne(optional = false)
    private EventoTracking eventoTracking;
    @JoinColumn(name = "origen", referencedColumnName = "id_sitio_recepcion_envio")
    @ManyToOne
    private SitioRecepcionEnvio origen;
    @JoinColumn(name = "destino", referencedColumnName = "id_sitio_recepcion_envio")
    @ManyToOne
    private SitioRecepcionEnvio destino;

    public DetalleTrackingCarga() {
    }

    public DetalleTrackingCarga(Short idDetalleTrackingCarga) {
        this.idDetalleTrackingCarga = idDetalleTrackingCarga;
    }

    public DetalleTrackingCarga(Short idDetalleTrackingCarga, Date fechaHora) {
        this.idDetalleTrackingCarga = idDetalleTrackingCarga;
        this.fechaHora = fechaHora;
    }

    public Short getIdDetalleTrackingCarga() {
        return idDetalleTrackingCarga;
    }

    public void setIdDetalleTrackingCarga(Short idDetalleTrackingCarga) {
        this.idDetalleTrackingCarga = idDetalleTrackingCarga;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Usuario getUsuarioEvento() {
        return usuarioEvento;
    }

    public void setUsuarioEvento(Usuario usuarioEvento) {
        this.usuarioEvento = usuarioEvento;
    }

    public TrackingCarga getTrackingCarga() {
        return trackingCarga;
    }

    public void setTrackingCarga(TrackingCarga trackingCarga) {
        this.trackingCarga = trackingCarga;
    }

    public EventoTracking getEventoTracking() {
        return eventoTracking;
    }

    public void setEventoTracking(EventoTracking eventoTracking) {
        this.eventoTracking = eventoTracking;
    }

    public SitioRecepcionEnvio getOrigen() {
        return origen;
    }

    public void setOrigen(SitioRecepcionEnvio origen) {
        this.origen = origen;
    }

    public SitioRecepcionEnvio getDestino() {
        return destino;
    }

    public void setDestino(SitioRecepcionEnvio destino) {
        this.destino = destino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleTrackingCarga != null ? idDetalleTrackingCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTrackingCarga)) {
            return false;
        }
        DetalleTrackingCarga other = (DetalleTrackingCarga) object;
        if ((this.idDetalleTrackingCarga == null && other.idDetalleTrackingCarga != null) || (this.idDetalleTrackingCarga != null && !this.idDetalleTrackingCarga.equals(other.idDetalleTrackingCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entity.main.DetalleTrackingCarga[ idDetalleTrackingCarga=" + idDetalleTrackingCarga + " ]";
    }
    
}
