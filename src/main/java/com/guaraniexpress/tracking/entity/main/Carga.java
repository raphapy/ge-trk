/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entity.main;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "carga", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carga.findAll", query = "SELECT c FROM Carga c"),
    @NamedQuery(name = "Carga.findByIdCarga", query = "SELECT c FROM Carga c WHERE c.idCarga = :idCarga"),
    @NamedQuery(name = "Carga.findByFechaSalidaEstimada", query = "SELECT c FROM Carga c WHERE c.fechaSalidaEstimada = :fechaSalidaEstimada"),
    @NamedQuery(name = "Carga.findByFechaSalida", query = "SELECT c FROM Carga c WHERE c.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "Carga.findByFechaLlegadaEstimada", query = "SELECT c FROM Carga c WHERE c.fechaLlegadaEstimada = :fechaLlegadaEstimada"),
    @NamedQuery(name = "Carga.findByFechaLlegada", query = "SELECT c FROM Carga c WHERE c.fechaLlegada = :fechaLlegada"),
    @NamedQuery(name = "Carga.findByPesoMaximoPermitido", query = "SELECT c FROM Carga c WHERE c.pesoMaximoPermitido = :pesoMaximoPermitido"),
    @NamedQuery(name = "Carga.findByIdentificacionTrackingCurrierExterno", query = "SELECT c FROM Carga c WHERE c.identificacionTrackingCurrierExterno = :identificacionTrackingCurrierExterno")})
public class Carga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carga")
    private Integer idCarga;
    @Column(name = "fecha_salida_estimada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalidaEstimada;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Column(name = "fecha_llegada_estimada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegadaEstimada;
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    @Size(max = 45)
    @Column(name = "peso_maximo_permitido")
    private String pesoMaximoPermitido;
    @Size(max = 100)
    @Column(name = "identificacion_tracking_currier_externo")
    private String identificacionTrackingCurrierExterno;
    @JoinColumn(name = "medio_transporte", referencedColumnName = "id_medio_transporte")
    @ManyToOne
    private MedioTransporte medioTransporte;
    @JoinColumn(name = "courrier_externo", referencedColumnName = "id_courrier_externo")
    @ManyToOne
    private CourrierExterno courrierExterno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carga")
    private List<Paquete> paqueteList;

    public Carga() {
    }

    public Carga(Integer idCarga) {
        this.idCarga = idCarga;
    }

    public Integer getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(Integer idCarga) {
        this.idCarga = idCarga;
    }

    public Date getFechaSalidaEstimada() {
        return fechaSalidaEstimada;
    }

    public void setFechaSalidaEstimada(Date fechaSalidaEstimada) {
        this.fechaSalidaEstimada = fechaSalidaEstimada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegadaEstimada() {
        return fechaLlegadaEstimada;
    }

    public void setFechaLlegadaEstimada(Date fechaLlegadaEstimada) {
        this.fechaLlegadaEstimada = fechaLlegadaEstimada;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getPesoMaximoPermitido() {
        return pesoMaximoPermitido;
    }

    public void setPesoMaximoPermitido(String pesoMaximoPermitido) {
        this.pesoMaximoPermitido = pesoMaximoPermitido;
    }

    public String getIdentificacionTrackingCurrierExterno() {
        return identificacionTrackingCurrierExterno;
    }

    public void setIdentificacionTrackingCurrierExterno(String identificacionTrackingCurrierExterno) {
        this.identificacionTrackingCurrierExterno = identificacionTrackingCurrierExterno;
    }

    public MedioTransporte getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(MedioTransporte medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public CourrierExterno getCourrierExterno() {
        return courrierExterno;
    }

    public void setCourrierExterno(CourrierExterno courrierExterno) {
        this.courrierExterno = courrierExterno;
    }

    @XmlTransient
    public List<Paquete> getPaqueteList() {
        return paqueteList;
    }

    public void setPaqueteList(List<Paquete> paqueteList) {
        this.paqueteList = paqueteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarga != null ? idCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carga)) {
            return false;
        }
        Carga other = (Carga) object;
        if ((this.idCarga == null && other.idCarga != null) || (this.idCarga != null && !this.idCarga.equals(other.idCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entity.main.Carga[ idCarga=" + idCarga + " ]";
    }
    
}
