package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the informacion_contacto_persona database table.
 * 
 */
@Entity
@Table(name="informacion_contacto_persona")
@NamedQuery(name="InformacionContactoPersona.findAll", query="SELECT i FROM InformacionContactoPersona i")
public class InformacionContactoPersona implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InformacionContactoPersonaPK id;

	private String valor;

	//bi-directional many-to-one association to DominioInformacionContacto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dominio_informacion_contacto")
	private DominioInformacionContacto dominioInformacionContactoBean;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="persona")
	private Persona personaBean;

	//bi-directional many-to-one association to TipoInformacionContacto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_informacion_contacto")
	private TipoInformacionContacto tipoInformacionContactoBean;

	public InformacionContactoPersona() {
	}

	public InformacionContactoPersonaPK getId() {
		return this.id;
	}

	public void setId(InformacionContactoPersonaPK id) {
		this.id = id;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public DominioInformacionContacto getDominioInformacionContactoBean() {
		return this.dominioInformacionContactoBean;
	}

	public void setDominioInformacionContactoBean(DominioInformacionContacto dominioInformacionContactoBean) {
		this.dominioInformacionContactoBean = dominioInformacionContactoBean;
	}

	public Persona getPersonaBean() {
		return this.personaBean;
	}

	public void setPersonaBean(Persona personaBean) {
		this.personaBean = personaBean;
	}

	public TipoInformacionContacto getTipoInformacionContactoBean() {
		return this.tipoInformacionContactoBean;
	}

	public void setTipoInformacionContactoBean(TipoInformacionContacto tipoInformacionContactoBean) {
		this.tipoInformacionContactoBean = tipoInformacionContactoBean;
	}

}