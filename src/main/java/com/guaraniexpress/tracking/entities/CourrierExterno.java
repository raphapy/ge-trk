package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the courrier_externo database table.
 * 
 */
@Entity
@Table(name="courrier_externo")
@NamedQuery(name="CourrierExterno.findAll", query="SELECT c FROM CourrierExterno c")
public class CourrierExterno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_courrier_externo")
	private int idCourrierExterno;

	private String nombre;

	//bi-directional many-to-one association to Carga
	@OneToMany(mappedBy="courrierExternoBean")
	private List<Carga> cargas;

	//bi-directional many-to-one association to Paquete
	@OneToMany(mappedBy="courrierExternoBean")
	private List<Paquete> paquetes;

	public CourrierExterno() {
	}

	public int getIdCourrierExterno() {
		return this.idCourrierExterno;
	}

	public void setIdCourrierExterno(int idCourrierExterno) {
		this.idCourrierExterno = idCourrierExterno;
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
		carga.setCourrierExternoBean(this);

		return carga;
	}

	public Carga removeCarga(Carga carga) {
		getCargas().remove(carga);
		carga.setCourrierExternoBean(null);

		return carga;
	}

	public List<Paquete> getPaquetes() {
		return this.paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Paquete addPaquete(Paquete paquete) {
		getPaquetes().add(paquete);
		paquete.setCourrierExternoBean(this);

		return paquete;
	}

	public Paquete removePaquete(Paquete paquete) {
		getPaquetes().remove(paquete);
		paquete.setCourrierExternoBean(null);

		return paquete;
	}

}