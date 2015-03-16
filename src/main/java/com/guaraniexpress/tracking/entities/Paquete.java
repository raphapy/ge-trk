package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paquete database table.
 * 
 */
@Entity
@Table(name="paquete")
@NamedQuery(name="Paquete.findAll", query="SELECT p FROM Paquete p")
public class Paquete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_paquete")
	private int idPaquete;

	private int altura;

	private int anchura;

	private String descripcion;

	@Column(name="identificacion_tracking_currier_externo")
	private String identificacionTrackingCurrierExterno;

	private int longitud;

	private int peso;

	//bi-directional many-to-one association to Carga
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="carga")
	private Carga cargaBean;

	//bi-directional many-to-one association to CourrierExterno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="courrier_externo")
	private CourrierExterno courrierExternoBean;

	//bi-directional one-to-one association to TrackingPaquete
	@OneToOne(mappedBy="paqueteBean", fetch=FetchType.LAZY)
	private TrackingPaquete trackingPaquete;

	public Paquete() {
	}

	public int getIdPaquete() {
		return this.idPaquete;
	}

	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}

	public int getAltura() {
		return this.altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAnchura() {
		return this.anchura;
	}

	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdentificacionTrackingCurrierExterno() {
		return this.identificacionTrackingCurrierExterno;
	}

	public void setIdentificacionTrackingCurrierExterno(String identificacionTrackingCurrierExterno) {
		this.identificacionTrackingCurrierExterno = identificacionTrackingCurrierExterno;
	}

	public int getLongitud() {
		return this.longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public Carga getCargaBean() {
		return this.cargaBean;
	}

	public void setCargaBean(Carga cargaBean) {
		this.cargaBean = cargaBean;
	}

	public CourrierExterno getCourrierExternoBean() {
		return this.courrierExternoBean;
	}

	public void setCourrierExternoBean(CourrierExterno courrierExternoBean) {
		this.courrierExternoBean = courrierExternoBean;
	}

	public TrackingPaquete getTrackingPaquete() {
		return this.trackingPaquete;
	}

	public void setTrackingPaquete(TrackingPaquete trackingPaquete) {
		this.trackingPaquete = trackingPaquete;
	}

}