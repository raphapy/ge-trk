package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sitio_recepcion_envio database table.
 * 
 */
@Entity
@Table(name="sitio_recepcion_envio")
@NamedQuery(name="SitioRecepcionEnvio.findAll", query="SELECT s FROM SitioRecepcionEnvio s")
public class SitioRecepcionEnvio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sitio_recepcion_envio")
	private int idSitioRecepcionEnvio;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to DetalleTrackingCarga
	@OneToMany(mappedBy="sitioRecepcionEnvio1")
	private List<DetalleTrackingCarga> detalleTrackingCargas1;

	//bi-directional many-to-one association to DetalleTrackingCarga
	@OneToMany(mappedBy="sitioRecepcionEnvio2")
	private List<DetalleTrackingCarga> detalleTrackingCargas2;

	//bi-directional many-to-one association to DetalleTrackingPaquete
	@OneToMany(mappedBy="sitioRecepcionEnvio1")
	private List<DetalleTrackingPaquete> detalleTrackingPaquetes1;

	//bi-directional many-to-one association to DetalleTrackingPaquete
	@OneToMany(mappedBy="sitioRecepcionEnvio2")
	private List<DetalleTrackingPaquete> detalleTrackingPaquetes2;

	public SitioRecepcionEnvio() {
	}

	public int getIdSitioRecepcionEnvio() {
		return this.idSitioRecepcionEnvio;
	}

	public void setIdSitioRecepcionEnvio(int idSitioRecepcionEnvio) {
		this.idSitioRecepcionEnvio = idSitioRecepcionEnvio;
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

	public List<DetalleTrackingCarga> getDetalleTrackingCargas1() {
		return this.detalleTrackingCargas1;
	}

	public void setDetalleTrackingCargas1(List<DetalleTrackingCarga> detalleTrackingCargas1) {
		this.detalleTrackingCargas1 = detalleTrackingCargas1;
	}

	public DetalleTrackingCarga addDetalleTrackingCargas1(DetalleTrackingCarga detalleTrackingCargas1) {
		getDetalleTrackingCargas1().add(detalleTrackingCargas1);
		detalleTrackingCargas1.setSitioRecepcionEnvio1(this);

		return detalleTrackingCargas1;
	}

	public DetalleTrackingCarga removeDetalleTrackingCargas1(DetalleTrackingCarga detalleTrackingCargas1) {
		getDetalleTrackingCargas1().remove(detalleTrackingCargas1);
		detalleTrackingCargas1.setSitioRecepcionEnvio1(null);

		return detalleTrackingCargas1;
	}

	public List<DetalleTrackingCarga> getDetalleTrackingCargas2() {
		return this.detalleTrackingCargas2;
	}

	public void setDetalleTrackingCargas2(List<DetalleTrackingCarga> detalleTrackingCargas2) {
		this.detalleTrackingCargas2 = detalleTrackingCargas2;
	}

	public DetalleTrackingCarga addDetalleTrackingCargas2(DetalleTrackingCarga detalleTrackingCargas2) {
		getDetalleTrackingCargas2().add(detalleTrackingCargas2);
		detalleTrackingCargas2.setSitioRecepcionEnvio2(this);

		return detalleTrackingCargas2;
	}

	public DetalleTrackingCarga removeDetalleTrackingCargas2(DetalleTrackingCarga detalleTrackingCargas2) {
		getDetalleTrackingCargas2().remove(detalleTrackingCargas2);
		detalleTrackingCargas2.setSitioRecepcionEnvio2(null);

		return detalleTrackingCargas2;
	}

	public List<DetalleTrackingPaquete> getDetalleTrackingPaquetes1() {
		return this.detalleTrackingPaquetes1;
	}

	public void setDetalleTrackingPaquetes1(List<DetalleTrackingPaquete> detalleTrackingPaquetes1) {
		this.detalleTrackingPaquetes1 = detalleTrackingPaquetes1;
	}

	public DetalleTrackingPaquete addDetalleTrackingPaquetes1(DetalleTrackingPaquete detalleTrackingPaquetes1) {
		getDetalleTrackingPaquetes1().add(detalleTrackingPaquetes1);
		detalleTrackingPaquetes1.setSitioRecepcionEnvio1(this);

		return detalleTrackingPaquetes1;
	}

	public DetalleTrackingPaquete removeDetalleTrackingPaquetes1(DetalleTrackingPaquete detalleTrackingPaquetes1) {
		getDetalleTrackingPaquetes1().remove(detalleTrackingPaquetes1);
		detalleTrackingPaquetes1.setSitioRecepcionEnvio1(null);

		return detalleTrackingPaquetes1;
	}

	public List<DetalleTrackingPaquete> getDetalleTrackingPaquetes2() {
		return this.detalleTrackingPaquetes2;
	}

	public void setDetalleTrackingPaquetes2(List<DetalleTrackingPaquete> detalleTrackingPaquetes2) {
		this.detalleTrackingPaquetes2 = detalleTrackingPaquetes2;
	}

	public DetalleTrackingPaquete addDetalleTrackingPaquetes2(DetalleTrackingPaquete detalleTrackingPaquetes2) {
		getDetalleTrackingPaquetes2().add(detalleTrackingPaquetes2);
		detalleTrackingPaquetes2.setSitioRecepcionEnvio2(this);

		return detalleTrackingPaquetes2;
	}

	public DetalleTrackingPaquete removeDetalleTrackingPaquetes2(DetalleTrackingPaquete detalleTrackingPaquetes2) {
		getDetalleTrackingPaquetes2().remove(detalleTrackingPaquetes2);
		detalleTrackingPaquetes2.setSitioRecepcionEnvio2(null);

		return detalleTrackingPaquetes2;
	}

}