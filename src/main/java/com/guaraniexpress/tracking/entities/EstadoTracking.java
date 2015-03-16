package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estado_tracking database table.
 * 
 */
@Entity
@Table(name="estado_tracking")
@NamedQuery(name="EstadoTracking.findAll", query="SELECT e FROM EstadoTracking e")
public class EstadoTracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estado_tracking")
	private int idEstadoTracking;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to TrackingCarga
	@OneToMany(mappedBy="estadoTracking")
	private List<TrackingCarga> trackingCargas;

	//bi-directional many-to-one association to TrackingPaquete
	@OneToMany(mappedBy="estadoTracking")
	private List<TrackingPaquete> trackingPaquetes;

	public EstadoTracking() {
	}

	public int getIdEstadoTracking() {
		return this.idEstadoTracking;
	}

	public void setIdEstadoTracking(int idEstadoTracking) {
		this.idEstadoTracking = idEstadoTracking;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<TrackingCarga> getTrackingCargas() {
		return this.trackingCargas;
	}

	public void setTrackingCargas(List<TrackingCarga> trackingCargas) {
		this.trackingCargas = trackingCargas;
	}

	public TrackingCarga addTrackingCarga(TrackingCarga trackingCarga) {
		getTrackingCargas().add(trackingCarga);
		trackingCarga.setEstadoTracking(this);

		return trackingCarga;
	}

	public TrackingCarga removeTrackingCarga(TrackingCarga trackingCarga) {
		getTrackingCargas().remove(trackingCarga);
		trackingCarga.setEstadoTracking(null);

		return trackingCarga;
	}

	public List<TrackingPaquete> getTrackingPaquetes() {
		return this.trackingPaquetes;
	}

	public void setTrackingPaquetes(List<TrackingPaquete> trackingPaquetes) {
		this.trackingPaquetes = trackingPaquetes;
	}

	public TrackingPaquete addTrackingPaquete(TrackingPaquete trackingPaquete) {
		getTrackingPaquetes().add(trackingPaquete);
		trackingPaquete.setEstadoTracking(this);

		return trackingPaquete;
	}

	public TrackingPaquete removeTrackingPaquete(TrackingPaquete trackingPaquete) {
		getTrackingPaquetes().remove(trackingPaquete);
		trackingPaquete.setEstadoTracking(null);

		return trackingPaquete;
	}

}