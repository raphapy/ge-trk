package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_persona")
	private int idPersona;

	private String apellidos;

	private byte edad;

	private String genero;

	@Column(name="localizacion_persona")
	private int localizacionPersona;

	private String nombres;

	//bi-directional many-to-one association to DocumentoIdentificacion
	@OneToMany(mappedBy="persona")
	private List<DocumentoIdentificacion> documentoIdentificacions;

	//bi-directional many-to-one association to InformacionContactoPersona
	@OneToMany(mappedBy="personaBean")
	private List<InformacionContactoPersona> informacionContactoPersonas;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="ciudad", referencedColumnName="id_ciudad"),
		@JoinColumn(name="localidad", referencedColumnName="localidad"),
		@JoinColumn(name="pais", referencedColumnName="pais")
		})
	private Ciudad ciudadBean;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="personaBean")
	private List<Usuario> usuarios;

	public Persona() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public byte getEdad() {
		return this.edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getLocalizacionPersona() {
		return this.localizacionPersona;
	}

	public void setLocalizacionPersona(int localizacionPersona) {
		this.localizacionPersona = localizacionPersona;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<DocumentoIdentificacion> getDocumentoIdentificacions() {
		return this.documentoIdentificacions;
	}

	public void setDocumentoIdentificacions(List<DocumentoIdentificacion> documentoIdentificacions) {
		this.documentoIdentificacions = documentoIdentificacions;
	}

	public DocumentoIdentificacion addDocumentoIdentificacion(DocumentoIdentificacion documentoIdentificacion) {
		getDocumentoIdentificacions().add(documentoIdentificacion);
		documentoIdentificacion.setPersona(this);

		return documentoIdentificacion;
	}

	public DocumentoIdentificacion removeDocumentoIdentificacion(DocumentoIdentificacion documentoIdentificacion) {
		getDocumentoIdentificacions().remove(documentoIdentificacion);
		documentoIdentificacion.setPersona(null);

		return documentoIdentificacion;
	}

	public List<InformacionContactoPersona> getInformacionContactoPersonas() {
		return this.informacionContactoPersonas;
	}

	public void setInformacionContactoPersonas(List<InformacionContactoPersona> informacionContactoPersonas) {
		this.informacionContactoPersonas = informacionContactoPersonas;
	}

	public InformacionContactoPersona addInformacionContactoPersona(InformacionContactoPersona informacionContactoPersona) {
		getInformacionContactoPersonas().add(informacionContactoPersona);
		informacionContactoPersona.setPersonaBean(this);

		return informacionContactoPersona;
	}

	public InformacionContactoPersona removeInformacionContactoPersona(InformacionContactoPersona informacionContactoPersona) {
		getInformacionContactoPersonas().remove(informacionContactoPersona);
		informacionContactoPersona.setPersonaBean(null);

		return informacionContactoPersona;
	}

	public Ciudad getCiudadBean() {
		return this.ciudadBean;
	}

	public void setCiudadBean(Ciudad ciudadBean) {
		this.ciudadBean = ciudadBean;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPersonaBean(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPersonaBean(null);

		return usuario;
	}

}