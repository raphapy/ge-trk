package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tracking_paquete database table.
 * 
 */
@Entity
@Table(name="tracking_paquete")
@NamedQuery(name="TrackingPaquete.findAll", query="SELECT t FROM TrackingPaquete t")
public class TrackingPaquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paquete;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="tracking_id")
	private String trackingId;

	//bi-directional many-to-one association to DetalleTrackingPaquete
	@OneToMany(mappedBy="trackingPaqueteBean")
	private List<DetalleTrackingPaquete> detalleTrackingPaquetes;

	//bi-directional many-to-one association to EstadoTracking
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="estado")
	private EstadoTracking estadoTracking;

	//bi-directional one-to-one association to Paquete
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="paquete")
	private Paquete paqueteBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_creacion")
	private Usuario usuario;

	public TrackingPaquete() {
	}

	public int getPaquete() {
		return this.paquete;
	}

	public void setPaquete(int paquete) {
		this.paquete = paquete;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getTrackingId() {
		return this.trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public List<DetalleTrackingPaquete> getDetalleTrackingPaquetes() {
		return this.detalleTrackingPaquetes;
	}

	public void setDetalleTrackingPaquetes(List<DetalleTrackingPaquete> detalleTrackingPaquetes) {
		this.detalleTrackingPaquetes = detalleTrackingPaquetes;
	}

	public DetalleTrackingPaquete addDetalleTrackingPaquete(DetalleTrackingPaquete detalleTrackingPaquete) {
		getDetalleTrackingPaquetes().add(detalleTrackingPaquete);
		detalleTrackingPaquete.setTrackingPaqueteBean(this);

		return detalleTrackingPaquete;
	}

	public DetalleTrackingPaquete removeDetalleTrackingPaquete(DetalleTrackingPaquete detalleTrackingPaquete) {
		getDetalleTrackingPaquetes().remove(detalleTrackingPaquete);
		detalleTrackingPaquete.setTrackingPaqueteBean(null);

		return detalleTrackingPaquete;
	}

	public EstadoTracking getEstadoTracking() {
		return this.estadoTracking;
	}

	public void setEstadoTracking(EstadoTracking estadoTracking) {
		this.estadoTracking = estadoTracking;
	}

	public Paquete getPaqueteBean() {
		return this.paqueteBean;
	}

	public void setPaqueteBean(Paquete paqueteBean) {
		this.paqueteBean = paqueteBean;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}