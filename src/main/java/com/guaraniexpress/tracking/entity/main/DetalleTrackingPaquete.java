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
@Table(name = "detalle_tracking_paquete", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleTrackingPaquete.findAll", query = "SELECT d FROM DetalleTrackingPaquete d"),
    @NamedQuery(name = "DetalleTrackingPaquete.findByIdDetalleTrackingPaquete", query = "SELECT d FROM DetalleTrackingPaquete d WHERE d.idDetalleTrackingPaquete = :idDetalleTrackingPaquete"),
    @NamedQuery(name = "DetalleTrackingPaquete.findByFechaHora", query = "SELECT d FROM DetalleTrackingPaquete d WHERE d.fechaHora = :fechaHora")})
public class DetalleTrackingPaquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_tracking_paquete")
    private Short idDetalleTrackingPaquete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinColumn(name = "usuario_evento", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioEvento;
    @JoinColumn(name = "evento_tracking", referencedColumnName = "id_evento_tracking")
    @ManyToOne(optional = false)
    private EventoTracking eventoTracking;
    @JoinColumn(name = "origen", referencedColumnName = "id_sitio_recepcion_envio")
    @ManyToOne
    private SitioRecepcionEnvio origen;
    @JoinColumn(name = "destino", referencedColumnName = "id_sitio_recepcion_envio")
    @ManyToOne
    private SitioRecepcionEnvio destino;
    @JoinColumn(name = "tracking_paquete", referencedColumnName = "id_tracking_paquete")
    @ManyToOne(optional = false)
    private TrackingPaquete trackingPaquete;

    public DetalleTrackingPaquete() {
    }

    public DetalleTrackingPaquete(Short idDetalleTrackingPaquete) {
        this.idDetalleTrackingPaquete = idDetalleTrackingPaquete;
    }

    public DetalleTrackingPaquete(Short idDetalleTrackingPaquete, Date fechaHora) {
        this.idDetalleTrackingPaquete = idDetalleTrackingPaquete;
        this.fechaHora = fechaHora;
    }

    public Short getIdDetalleTrackingPaquete() {
        return idDetalleTrackingPaquete;
    }

    public void setIdDetalleTrackingPaquete(Short idDetalleTrackingPaquete) {
        this.idDetalleTrackingPaquete = idDetalleTrackingPaquete;
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

    public TrackingPaquete getTrackingPaquete() {
        return trackingPaquete;
    }

    public void setTrackingPaquete(TrackingPaquete trackingPaquete) {
        this.trackingPaquete = trackingPaquete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleTrackingPaquete != null ? idDetalleTrackingPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTrackingPaquete)) {
            return false;
        }
        DetalleTrackingPaquete other = (DetalleTrackingPaquete) object;
        if ((this.idDetalleTrackingPaquete == null && other.idDetalleTrackingPaquete != null) || (this.idDetalleTrackingPaquete != null && !this.idDetalleTrackingPaquete.equals(other.idDetalleTrackingPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entity.main.DetalleTrackingPaquete[ idDetalleTrackingPaquete=" + idDetalleTrackingPaquete + " ]";
    }
    
}
