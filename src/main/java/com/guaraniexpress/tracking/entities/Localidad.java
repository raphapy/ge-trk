package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the localidad database table.
 * 
 */
@Entity
@Table(name="localidad")
@NamedQuery(name="Localidad.findAll", query="SELECT l FROM Localidad l")
public class Localidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocalidadPK id;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="localidadBean")
	private List<Ciudad> ciudads;

	//bi-directional many-to-one association to Pais
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pais")
	private Pais pai;

	public Localidad() {
	}

	public LocalidadPK getId() {
		return this.id;
	}

	public void setId(LocalidadPK id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(List<Ciudad> ciudads) {
		this.ciudads = ciudads;
	}

	public Ciudad addCiudad(Ciudad ciudad) {
		getCiudads().add(ciudad);
		ciudad.setLocalidadBean(this);

		return ciudad;
	}

	public Ciudad removeCiudad(Ciudad ciudad) {
		getCiudads().remove(ciudad);
		ciudad.setLocalidadBean(null);

		return ciudad;
	}

	public Pais getPai() {
		return this.pai;
	}

	public void setPai(Pais pai) {
		this.pai = pai;
	}

}