package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the detalle_tracking_carga database table.
 * 
 */
@Entity
@Table(name="detalle_tracking_carga")
@NamedQuery(name="DetalleTrackingCarga.findAll", query="SELECT d FROM DetalleTrackingCarga d")
public class DetalleTrackingCarga implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleTrackingCargaPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_hora")
	private Date fechaHora;

	//bi-directional many-to-one association to EventoTracking
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="evento_tracking")
	private EventoTracking eventoTrackingBean;

	//bi-directional many-to-one association to SitioRecepcionEnvio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="destino")
	private SitioRecepcionEnvio sitioRecepcionEnvio1;

	//bi-directional many-to-one association to SitioRecepcionEnvio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="origen")
	private SitioRecepcionEnvio sitioRecepcionEnvio2;

	//bi-directional many-to-one association to TrackingCarga
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tracking_carga")
	private TrackingCarga trackingCargaBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_evento")
	private Usuario usuario;

	public DetalleTrackingCarga() {
	}

	public DetalleTrackingCargaPK getId() {
		return this.id;
	}

	public void setId(DetalleTrackingCargaPK id) {
		this.id = id;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public EventoTracking getEventoTrackingBean() {
		return this.eventoTrackingBean;
	}

	public void setEventoTrackingBean(EventoTracking eventoTrackingBean) {
		this.eventoTrackingBean = eventoTrackingBean;
	}

	public SitioRecepcionEnvio getSitioRecepcionEnvio1() {
		return this.sitioRecepcionEnvio1;
	}

	public void setSitioRecepcionEnvio1(SitioRecepcionEnvio sitioRecepcionEnvio1) {
		this.sitioRecepcionEnvio1 = sitioRecepcionEnvio1;
	}

	public SitioRecepcionEnvio getSitioRecepcionEnvio2() {
		return this.sitioRecepcionEnvio2;
	}

	public void setSitioRecepcionEnvio2(SitioRecepcionEnvio sitioRecepcionEnvio2) {
		this.sitioRecepcionEnvio2 = sitioRecepcionEnvio2;
	}

	public TrackingCarga getTrackingCargaBean() {
		return this.trackingCargaBean;
	}

	public void setTrackingCargaBean(TrackingCarga trackingCargaBean) {
		this.trackingCargaBean = trackingCargaBean;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}