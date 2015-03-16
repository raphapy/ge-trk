package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@Table(name="ciudad")
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CiudadPK id;

	private String codigo;

	private String nombre;

	//bi-directional many-to-one association to Localidad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="localidad", referencedColumnName="id_localidad"),
		@JoinColumn(name="pais", referencedColumnName="pais")
		})
	private Localidad localidadBean;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="ciudadBean")
	private List<Persona> personas;

	public Ciudad() {
	}

	public CiudadPK getId() {
		return this.id;
	}

	public void setId(CiudadPK id) {
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

	public Localidad getLocalidadBean() {
		return this.localidadBean;
	}

	public void setLocalidadBean(Localidad localidadBean) {
		this.localidadBean = localidadBean;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setCiudadBean(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setCiudadBean(null);

		return persona;
	}

}