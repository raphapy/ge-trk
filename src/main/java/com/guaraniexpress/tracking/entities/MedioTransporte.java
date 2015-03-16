package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medio_transporte database table.
 * 
 */
@Entity
@Table(name="medio_transporte")
@NamedQuery(name="MedioTransporte.findAll", query="SELECT m FROM MedioTransporte m")
public class MedioTransporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medio_transporte")
	private int idMedioTransporte;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Carga
	@OneToMany(mappedBy="medioTransporteBean")
	private List<Carga> cargas;

	public MedioTransporte() {
	}

	public int getIdMedioTransporte() {
		return this.idMedioTransporte;
	}

	public void setIdMedioTransporte(int idMedioTransporte) {
		this.idMedioTransporte = idMedioTransporte;
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

	public List<Carga> getCargas() {
		return this.cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public Carga addCarga(Carga carga) {
		getCargas().add(carga);
		carga.setMedioTransporteBean(this);

		return carga;
	}

	public Carga removeCarga(Carga carga) {
		getCargas().remove(carga);
		carga.setMedioTransporteBean(null);

		return carga;
	}

}