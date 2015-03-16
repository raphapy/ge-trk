package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evento_tracking database table.
 * 
 */
@Entity
@Table(name="evento_tracking")
@NamedQuery(name="EventoTracking.findAll", query="SELECT e FROM EventoTracking e")
public class EventoTracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_evento_tracking")
	private int idEventoTracking;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to DetalleTrackingCarga
	@OneToMany(mappedBy="eventoTrackingBean")
	private List<DetalleTrackingCarga> detalleTrackingCargas;

	//bi-directional many-to-one association to DetalleTrackingPaquete
	@OneToMany(mappedBy="eventoTrackingBean")
	private List<DetalleTrackingPaquete> detalleTrackingPaquetes;

	public EventoTracking() {
	}

	public int getIdEventoTracking() {
		return this.idEventoTracking;
	}

	public void setIdEventoTracking(int idEventoTracking) {
		this.idEventoTracking = idEventoTracking;
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

	public List<DetalleTrackingCarga> getDetalleTrackingCargas() {
		return this.detalleTrackingCargas;
	}

	public void setDetalleTrackingCargas(List<DetalleTrackingCarga> detalleTrackingCargas) {
		this.detalleTrackingCargas = detalleTrackingCargas;
	}

	public DetalleTrackingCarga addDetalleTrackingCarga(DetalleTrackingCarga detalleTrackingCarga) {
		getDetalleTrackingCargas().add(detalleTrackingCarga);
		detalleTrackingCarga.setEventoTrackingBean(this);

		return detalleTrackingCarga;
	}

	public DetalleTrackingCarga removeDetalleTrackingCarga(DetalleTrackingCarga detalleTrackingCarga) {
		getDetalleTrackingCargas().remove(detalleTrackingCarga);
		detalleTrackingCarga.setEventoTrackingBean(null);

		return detalleTrackingCarga;
	}

	public List<DetalleTrackingPaquete> getDetalleTrackingPaquetes() {
		return this.detalleTrackingPaquetes;
	}

	public void setDetalleTrackingPaquetes(List<DetalleTrackingPaquete> detalleTrackingPaquetes) {
		this.detalleTrackingPaquetes = detalleTrackingPaquetes;
	}

	public DetalleTrackingPaquete addDetalleTrackingPaquete(DetalleTrackingPaquete detalleTrackingPaquete) {
		getDetalleTrackingPaquetes().add(detalleTrackingPaquete);
		detalleTrackingPaquete.setEventoTrackingBean(this);

		return detalleTrackingPaquete;
	}

	public DetalleTrackingPaquete removeDetalleTrackingPaquete(DetalleTrackingPaquete detalleTrackingPaquete) {
		getDetalleTrackingPaquetes().remove(detalleTrackingPaquete);
		detalleTrackingPaquete.setEventoTrackingBean(null);

		return detalleTrackingPaquete;
	}

}