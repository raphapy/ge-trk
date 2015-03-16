/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities;

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

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "detalle_tracking_paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleTrackingPaquete.findAll", query = "SELECT d FROM DetalleTrackingPaquete d"),
    @NamedQuery(name = "DetalleTrackingPaquete.findByIdDetalleTrackingPaquete", query = "SELECT d FROM DetalleTrackingPaquete d WHERE d.detalleTrackingPaquetePK.idDetalleTrackingPaquete = :idDetalleTrackingPaquete"),
    @NamedQuery(name = "DetalleTrackingPaquete.findByTrackingPaquete", query = "SELECT d FROM DetalleTrackingPaquete d WHERE d.detalleTrackingPaquetePK.trackingPaquete = :trackingPaquete"),
    @NamedQuery(name = "DetalleTrackingPaquete.findByFechaHora", query = "SELECT d FROM DetalleTrackingPaquete d WHERE d.fechaHora = :fechaHora")})
public class DetalleTrackingPaquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleTrackingPaquetePK detalleTrackingPaquetePK;
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
    @JoinColumn(name = "tracking_paquete", referencedColumnName = "paquete", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TrackingPaquete trackingPaquete1;

    public DetalleTrackingPaquete() {
    }

    public DetalleTrackingPaquete(DetalleTrackingPaquetePK detalleTrackingPaquetePK) {
        this.detalleTrackingPaquetePK = detalleTrackingPaquetePK;
    }

    public DetalleTrackingPaquete(DetalleTrackingPaquetePK detalleTrackingPaquetePK, Date fechaHora) {
        this.detalleTrackingPaquetePK = detalleTrackingPaquetePK;
        this.fechaHora = fechaHora;
    }

    public DetalleTrackingPaquete(short idDetalleTrackingPaquete, int trackingPaquete) {
        this.detalleTrackingPaquetePK = new DetalleTrackingPaquetePK(idDetalleTrackingPaquete, trackingPaquete);
    }

    public DetalleTrackingPaquetePK getDetalleTrackingPaquetePK() {
        return detalleTrackingPaquetePK;
    }

    public void setDetalleTrackingPaquetePK(DetalleTrackingPaquetePK detalleTrackingPaquetePK) {
        this.detalleTrackingPaquetePK = detalleTrackingPaquetePK;
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

    public TrackingPaquete getTrackingPaquete1() {
        return trackingPaquete1;
    }

    public void setTrackingPaquete1(TrackingPaquete trackingPaquete1) {
        this.trackingPaquete1 = trackingPaquete1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleTrackingPaquetePK != null ? detalleTrackingPaquetePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleTrackingPaquete)) {
            return false;
        }
        DetalleTrackingPaquete other = (DetalleTrackingPaquete) object;
        if ((this.detalleTrackingPaquetePK == null && other.detalleTrackingPaquetePK != null) || (this.detalleTrackingPaquetePK != null && !this.detalleTrackingPaquetePK.equals(other.detalleTrackingPaquetePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.DetalleTrackingPaquete[ detalleTrackingPaquetePK=" + detalleTrackingPaquetePK + " ]";
    }
    
}
