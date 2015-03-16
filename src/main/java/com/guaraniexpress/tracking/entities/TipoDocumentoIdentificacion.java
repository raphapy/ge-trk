package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_documento_identificacion database table.
 * 
 */
@Entity
@Table(name="tipo_documento_identificacion")
@NamedQuery(name="TipoDocumentoIdentificacion.findAll", query="SELECT t FROM TipoDocumentoIdentificacion t")
public class TipoDocumentoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_documento_identificacion")
	private int idTipoDocumentoIdentificacion;

	private String descripcion;

	private String formato;

	private String nombre;

	//bi-directional many-to-one association to DocumentoIdentificacion
	@OneToMany(mappedBy="tipoDocumentoIdentificacionBean")
	private List<DocumentoIdentificacion> documentoIdentificacions;

	public TipoDocumentoIdentificacion() {
	}

	public int getIdTipoDocumentoIdentificacion() {
		return this.idTipoDocumentoIdentificacion;
	}

	public void setIdTipoDocumentoIdentificacion(int idTipoDocumentoIdentificacion) {
		this.idTipoDocumentoIdentificacion = idTipoDocumentoIdentificacion;
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

	public List<DocumentoIdentificacion> getDocumentoIdentificacions() {
		return this.documentoIdentificacions;
	}

	public void setDocumentoIdentificacions(List<DocumentoIdentificacion> documentoIdentificacions) {
		this.documentoIdentificacions = documentoIdentificacions;
	}

	public DocumentoIdentificacion addDocumentoIdentificacion(DocumentoIdentificacion documentoIdentificacion) {
		getDocumentoIdentificacions().add(documentoIdentificacion);
		documentoIdentificacion.setTipoDocumentoIdentificacionBean(this);

		return documentoIdentificacion;
	}

	public DocumentoIdentificacion removeDocumentoIdentificacion(DocumentoIdentificacion documentoIdentificacion) {
		getDocumentoIdentificacions().remove(documentoIdentificacion);
		documentoIdentificacion.setTipoDocumentoIdentificacionBean(null);

		return documentoIdentificacion;
	}

}