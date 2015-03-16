package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="codigo_activacion")
	private String codigoActivacion;

	private String contrasenha;

	private String email;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_expiracion")
	private Date fechaExpiracion;

	private String nombre;

	//bi-directional many-to-one association to DetalleTrackingCarga
	@OneToMany(mappedBy="usuario")
	private List<DetalleTrackingCarga> detalleTrackingCargas;

	//bi-directional many-to-one association to DetalleTrackingPaquete
	@OneToMany(mappedBy="usuario")
	private List<DetalleTrackingPaquete> detalleTrackingPaquetes;

	//bi-directional many-to-one association to TrackingCarga
	@OneToMany(mappedBy="usuario")
	private List<TrackingCarga> trackingCargas;

	//bi-directional many-to-one association to TrackingPaquete
	@OneToMany(mappedBy="usuario")
	private List<TrackingPaquete> trackingPaquetes;

	//bi-directional many-to-one association to Lenguaje
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lenguaje")
	private Lenguaje lenguajeBean;

	//bi-directional many-to-one association to Persona
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="persona")
	private Persona personaBean;

	//bi-directional many-to-many association to Rol
	@ManyToMany
	@JoinTable(
		name="rol_aplicacion_usuario"
		, joinColumns={
			@JoinColumn(name="usuario")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rol")
			}
		)
	private List<Rol> rols;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodigoActivacion() {
		return this.codigoActivacion;
	}

	public void setCodigoActivacion(String codigoActivacion) {
		this.codigoActivacion = codigoActivacion;
	}

	public String getContrasenha() {
		return this.contrasenha;
	}

	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaExpiracion() {
		return this.fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DetalleTrackingCarga> getDetalleTrackingCargas() {
		return this.detalleTrackingCargas;
	}

	public void setDetalleTrackingCargas(List<DetalleTrackingCarga> detalleTrackingCargas) {
		this.detalleTrackingCargas = detalleTrackingCargas;
	}

	public DetalleTrackingCarga addDetalleTrackingCarga(DetalleTrackingCarga detalleTrackingCarga) {
		getDetalleTrackingCargas().add(detalleTrackingCarga);
		detalleTrackingCarga.setUsuario(this);

		return detalleTrackingCarga;
	}

	public DetalleTrackingCarga removeDetalleTrackingCarga(DetalleTrackingCarga detalleTrackingCarga) {
		getDetalleTrackingCargas().remove(detalleTrackingCarga);
		detalleTrackingCarga.setUsuario(null);

		return detalleTrackingCarga;
	}

	public List<DetalleTrackingPaquete> getDetalleTrackingPaquetes() {
		return this.detalleTrackingPaquetes;
	}

	public void setDetalleTrackingPaquetes(List<DetalleTrackingPaquete> detalleTrackingPaquetes) {
		this.detalleTrackingPaquetes = detalleTrackingPaquetes;
	}

	public DetalleTrackingPaquete addDetalleTrackingPaquete(DetalleTrackingPaquete detalleTrackingPaquete) {
		getDetalleTrackingPaquetes().add(detalleTrackingPaquete);
		detalleTrackingPaquete.setUsuario(this);

		return detalleTrackingPaquete;
	}

	public DetalleTrackingPaquete removeDetalleTrackingPaquete(DetalleTrackingPaquete detalleTrackingPaquete) {
		getDetalleTrackingPaquetes().remove(detalleTrackingPaquete);
		detalleTrackingPaquete.setUsuario(null);

		return detalleTrackingPaquete;
	}

	public List<TrackingCarga> getTrackingCargas() {
		return this.trackingCargas;
	}

	public void setTrackingCargas(List<TrackingCarga> trackingCargas) {
		this.trackingCargas = trackingCargas;
	}

	public TrackingCarga addTrackingCarga(TrackingCarga trackingCarga) {
		getTrackingCargas().add(trackingCarga);
		trackingCarga.setUsuario(this);

		return trackingCarga;
	}

	public TrackingCarga removeTrackingCarga(TrackingCarga trackingCarga) {
		getTrackingCargas().remove(trackingCarga);
		trackingCarga.setUsuario(null);

		return trackingCarga;
	}

	public List<TrackingPaquete> getTrackingPaquetes() {
		return this.trackingPaquetes;
	}

	public void setTrackingPaquetes(List<TrackingPaquete> trackingPaquetes) {
		this.trackingPaquetes = trackingPaquetes;
	}

	public TrackingPaquete addTrackingPaquete(TrackingPaquete trackingPaquete) {
		getTrackingPaquetes().add(trackingPaquete);
		trackingPaquete.setUsuario(this);

		return trackingPaquete;
	}

	public TrackingPaquete removeTrackingPaquete(TrackingPaquete trackingPaquete) {
		getTrackingPaquetes().remove(trackingPaquete);
		trackingPaquete.setUsuario(null);

		return trackingPaquete;
	}

	public Lenguaje getLenguajeBean() {
		return this.lenguajeBean;
	}

	public void setLenguajeBean(Lenguaje lenguajeBean) {
		this.lenguajeBean = lenguajeBean;
	}

	public Persona getPersonaBean() {
		return this.personaBean;
	}

	public void setPersonaBean(Persona personaBean) {
		this.personaBean = personaBean;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}