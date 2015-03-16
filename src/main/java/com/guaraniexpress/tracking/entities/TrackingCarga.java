package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tracking_carga database table.
 * 
 */
@Entity
@Table(name="tracking_carga")
@NamedQuery(name="TrackingCarga.findAll", query="SELECT t FROM TrackingCarga t")
public class TrackingCarga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int carga;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="tracking_id")
	private String trackingId;

	//bi-directional many-to-one association to DetalleTrackingCarga
	@OneToMany(mappedBy="trackingCargaBean")
	private List<DetalleTrackingCarga> detalleTrackingCargas;

	//bi-directional one-to-one association to Carga
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="carga")
	private Carga cargaBean;

	//bi-directional many-to-one association to EstadoTracking
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="estado")
	private EstadoTracking estadoTracking;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_creacion")
	private Usuario usuario;

	public TrackingCarga() {
	}

	public int getCarga() {
		return this.carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
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

	public List<DetalleTrackingCarga> getDetalleTrackingCargas() {
		return this.detalleTrackingCargas;
	}

	public void setDetalleTrackingCargas(List<DetalleTrackingCarga> detalleTrackingCargas) {
		this.detalleTrackingCargas = detalleTrackingCargas;
	}

	public DetalleTrackingCarga addDetalleTrackingCarga(DetalleTrackingCarga detalleTrackingCarga) {
		getDetalleTrackingCargas().add(detalleTrackingCarga);
		detalleTrackingCarga.setTrackingCargaBean(this);

		return detalleTrackingCarga;
	}

	public DetalleTrackingCarga removeDetalleTrackingCarga(DetalleTrackingCarga detalleTrackingCarga) {
		getDetalleTrackingCargas().remove(detalleTrackingCarga);
		detalleTrackingCarga.setTrackingCargaBean(null);

		return detalleTrackingCarga;
	}

	public Carga getCargaBean() {
		return this.cargaBean;
	}

	public void setCargaBean(Carga cargaBean) {
		this.cargaBean = cargaBean;
	}

	public EstadoTracking getEstadoTracking() {
		return this.estadoTracking;
	}

	public void setEstadoTracking(EstadoTracking estadoTracking) {
		this.estadoTracking = estadoTracking;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}