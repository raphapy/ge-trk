package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documento_identificacion database table.
 * 
 */
@Entity
@Table(name="documento_identificacion")
@NamedQuery(name="DocumentoIdentificacion.findAll", query="SELECT d FROM DocumentoIdentificacion d")
public class DocumentoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DocumentoIdentificacionPK id;

	private String numero;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	private Persona persona;

	//bi-directional many-to-one association to TipoDocumentoIdentificacion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_documento_identificacion")
	private TipoDocumentoIdentificacion tipoDocumentoIdentificacionBean;

	public DocumentoIdentificacion() {
	}

	public DocumentoIdentificacionPK getId() {
		return this.id;
	}

	public void setId(DocumentoIdentificacionPK id) {
		this.id = id;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public TipoDocumentoIdentificacion getTipoDocumentoIdentificacionBean() {
		return this.tipoDocumentoIdentificacionBean;
	}

	public void setTipoDocumentoIdentificacionBean(TipoDocumentoIdentificacion tipoDocumentoIdentificacionBean) {
		this.tipoDocumentoIdentificacionBean = tipoDocumentoIdentificacionBean;
	}

}