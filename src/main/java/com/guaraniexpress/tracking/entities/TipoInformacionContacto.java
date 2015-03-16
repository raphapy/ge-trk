package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_informacion_contacto database table.
 * 
 */
@Entity
@Table(name="tipo_informacion_contacto")
@NamedQuery(name="TipoInformacionContacto.findAll", query="SELECT t FROM TipoInformacionContacto t")
public class TipoInformacionContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_informacion_contacto")
	private int idTipoInformacionContacto;

	private String descripcion;

	private String formato;

	private String nombre;

	//bi-directional many-to-one association to InformacionContactoPersona
	@OneToMany(mappedBy="tipoInformacionContactoBean")
	private List<InformacionContactoPersona> informacionContactoPersonas;

	public TipoInformacionContacto() {
	}

	public int getIdTipoInformacionContacto() {
		return this.idTipoInformacionContacto;
	}

	public void setIdTipoInformacionContacto(int idTipoInformacionContacto) {
		this.idTipoInformacionContacto = idTipoInformacionContacto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFormato() {
		return this.formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
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
		informacionContactoPersona.setTipoInformacionContactoBean(this);

		return informacionContactoPersona;
	}

	public InformacionContactoPersona removeInformacionContactoPersona(InformacionContactoPersona informacionContactoPersona) {
		getInformacionContactoPersonas().remove(informacionContactoPersona);
		informacionContactoPersona.setTipoInformacionContactoBean(null);

		return informacionContactoPersona;
	}

}