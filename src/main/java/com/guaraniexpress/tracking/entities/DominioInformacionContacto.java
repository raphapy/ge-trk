package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dominio_informacion_contacto database table.
 * 
 */
@Entity
@Table(name="dominio_informacion_contacto")
@NamedQuery(name="DominioInformacionContacto.findAll", query="SELECT d FROM DominioInformacionContacto d")
public class DominioInformacionContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dominio_informacion_contacto")
	private int idDominioInformacionContacto;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to InformacionContactoPersona
	@OneToMany(mappedBy="dominioInformacionContactoBean")
	private List<InformacionContactoPersona> informacionContactoPersonas;

	public DominioInformacionContacto() {
	}

	public int getIdDominioInformacionContacto() {
		return this.idDominioInformacionContacto;
	}

	public void setIdDominioInformacionContacto(int idDominioInformacionContacto) {
		this.idDominioInformacionContacto = idDominioInformacionContacto;
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

	public List<InformacionContactoPersona> getInformacionContactoPersonas() {
		return this.informacionContactoPersonas;
	}

	public void setInformacionContactoPersonas(List<InformacionContactoPersona> informacionContactoPersonas) {
		this.informacionContactoPersonas = informacionContactoPersonas;
	}

	public InformacionContactoPersona addInformacionContactoPersona(InformacionContactoPersona informacionContactoPersona) {
		getInformacionContactoPersonas().add(informacionContactoPersona);
		informacionContactoPersona.setDominioInformacionContactoBean(this);

		return informacionContactoPersona;
	}

	public InformacionContactoPersona removeInformacionContactoPersona(InformacionContactoPersona informacionContactoPersona) {
		getInformacionContactoPersonas().remove(informacionContactoPersona);
		informacionContactoPersona.setDominioInformacionContactoBean(null);

		return informacionContactoPersona;
	}

}