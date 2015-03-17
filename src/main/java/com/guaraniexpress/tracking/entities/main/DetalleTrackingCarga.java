/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.main;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.guaraniexpress.tracking.entities.application.Usuario;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "detalle_tracking_carga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleTrackingCarga.findAll", query = "SELECT d FROM DetalleTrackingCarga d"),
    @NamedQuery(name = "DetalleTrackingCarga.findByIdDetalleTrackingCarga", query = "SELECT d FROM DetalleTrackingCarga d WHERE d.detalleTrackingCargaPK.idDetalleTrackingCarga = :idDetalleTrackingCarga"),
    @NamedQuery(name = "DetalleTrackingCarga.findByTrackingCarga", query = "SELECT d FROM DetalleTrackingCarga d WHERE d.detalleTrackingCargaPK.trackingCarga = :trackingCarga"),
    @NamedQuery(name = "DetalleTrackingCarga.findByFechaHora", query = "SELECT d FROM DetalleTrackingCarga d WHERE d.fechaHora = :fechaHora")})
public class DetalleTrackingCarga implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleTrackingCargaPK detalleTrackingCargaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinColumn(name = "evento_tracking", referencedColumnName = "id_evento_tracking")
    @ManyToOne(optional = false)
    private EventoTracking eventoTracking;
    @JoinColumn(name = "usuario_evento", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioEvento;
    @JoinColumn(name = "origen", referencedColumnName = "id_sitio_recepcion_envio")
    @ManyToOne
    private SitioRecepcionEnvio origen;
    @JoinColumn(name = "destino", referencedColumnName = "id_sitio_recepcion_envio")
    @ManyToOne
    private SitioRecepcionEnvio destino;
    @JoinColumn(name = "tracking_carga", referencedColumnName = "carga", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrackingCarga trackingCarga1;

    public DetalleTrackingCarga() {
    }

    public DetalleTrackingCarga(DetalleTrackingCargaPK detalleTrackingCargaPK) {
        this.detalleTrackingCargaPK = detalleTrackingCargaPK;
    }

    public DetalleTrackingCarga(DetalleTrackingCargaPK detalleTrackingCargaPK, Date fechaHora) {
        this.detalleTrackingCargaPK = detalleTrackingCargaPK;
        this.fechaHora = fechaHora;
    }

    public DetalleTrackingCarga(short idDetalleTrackingCarga, int trackingCarga) {
        this.detalleTrackingCargaPK = new DetalleTrackingCargaPK(idDetalleTrackingCarga, trackingCarga);
    }

    public DetalleTrackingCargaPK getDetalleTrackingCargaPK() {
        return detalleTrackingCargaPK;
    }

    public void setDetalleTrackingCargaPK(DetalleTrackingCargaPK detalleTrackingCargaPK) {
        this.detalleTrackingCargaPK = detalleTrackingCargaPK;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EventoTracking getEventoTracking() {
        return eventoTracking;
    }

    public void setEventoTracking(EventoTracking eventoTracking) {
        this.eventoTracking = eventoTracking;
    }

    public Usuario getUsuarioEvento() {
        return usuarioEvento;
    }

    public void setUsuarioEvento(Usuario usuarioEvento) {
        this.usuarioEvento = usuarioEvento;
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

    public TrackingCarga getTrackingCarga1() {
        return trackingCarga1;
    }

    public void setTrackingCarga1(TrackingCarga trackingCarga1) {
        this.trackingCarga1 = trackingCarga1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleTrackingCargaPK != null ? detalleTrackingCargaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTrackingCarga)) {
            return false;
        }
        DetalleTrackingCarga other = (DetalleTrackingCarga) object;
        if ((this.detalleTrackingCargaPK == null && other.detalleTrackingCargaPK != null) || (this.detalleTrackingCargaPK != null && !this.detalleTrackingCargaPK.equals(other.detalleTrackingCargaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.DetalleTrackingCarga[ detalleTrackingCargaPK=" + detalleTrackingCargaPK + " ]";
    }
    
}
