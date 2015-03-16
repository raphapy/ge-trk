package com.guaraniexpress.tracking.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the carga database table.
 * 
 */
@Entity
@Table(name="carga")
@NamedQuery(name="Carga.findAll", query="SELECT c FROM Carga c")
public class Carga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_carga")
	private int idCarga;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_llegada")
	private Date fechaLlegada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_llegada_estimada")
	private Date fechaLlegadaEstimada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_salida_estimada")
	private Date fechaSalidaEstimada;

	@Column(name="identificacion_tracking_currier_externo")
	private String identificacionTrackingCurrierExterno;

	@Column(name="peso_maximo_permitido")
	private String pesoMaximoPermitido;

	//bi-directional many-to-one association to CourrierExterno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="courrier_externo")
	private CourrierExterno courrierExternoBean;

	//bi-directional many-to-one association to MedioTransporte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="medio_transporte")
	private MedioTransporte medioTransporteBean;

	//bi-directional many-to-one association to Paquete
	@OneToMany(mappedBy="cargaBean")
	private List<Paquete> paquetes;

	//bi-directional one-to-one association to TrackingCarga
	@OneToOne(mappedBy="cargaBean", fetch=FetchType.LAZY)
	private TrackingCarga trackingCarga;

	public Carga() {
	}

	public int getIdCarga() {
		return this.idCarga;
	}

	public void setIdCarga(int idCarga) {
		this.idCarga = idCarga;
	}

	public Date getFechaLlegada() {
		return this.fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Date getFechaLlegadaEstimada() {
		return this.fechaLlegadaEstimada;
	}

	public void setFechaLlegadaEstimada(Date fechaLlegadaEstimada) {
		this.fechaLlegadaEstimada = fechaLlegadaEstimada;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaSalidaEstimada() {
		return this.fechaSalidaEstimada;
	}

	public void setFechaSalidaEstimada(Date fechaSalidaEstimada) {
		this.fechaSalidaEstimada = fechaSalidaEstimada;
	}

	public String getIdentificacionTrackingCurrierExterno() {
		return this.identificacionTrackingCurrierExterno;
	}

	public void setIdentificacionTrackingCurrierExterno(String identificacionTrackingCurrierExterno) {
		this.identificacionTrackingCurrierExterno = identificacionTrackingCurrierExterno;
	}

	public String getPesoMaximoPermitido() {
		return this.pesoMaximoPermitido;
	}

	public void setPesoMaximoPermitido(String pesoMaximoPermitido) {
		this.pesoMaximoPermitido = pesoMaximoPermitido;
	}

	public CourrierExterno getCourrierExternoBean() {
		return this.courrierExternoBean;
	}

	public void setCourrierExternoBean(CourrierExterno courrierExternoBean) {
		this.courrierExternoBean = courrierExternoBean;
	}

	public MedioTransporte getMedioTransporteBean() {
		return this.medioTransporteBean;
	}

	public void setMedioTransporteBean(MedioTransporte medioTransporteBean) {
		this.medioTransporteBean = medioTransporteBean;
	}

	public List<Paquete> getPaquetes() {
		return this.paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public Paquete addPaquete(Paquete paquete) {
		getPaquetes().add(paquete);
		paquete.setCargaBean(this);

		return paquete;
	}

	public Paquete removePaquete(Paquete paquete) {
		getPaquetes().remove(paquete);
		paquete.setCargaBean(null);

		return paquete;
	}

	public TrackingCarga getTrackingCarga() {
		return this.trackingCarga;
	}

	public void setTrackingCarga(TrackingCarga trackingCarga) {
		this.trackingCarga = trackingCarga;
	}

}