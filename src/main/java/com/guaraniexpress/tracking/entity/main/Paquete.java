/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entity.main;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "paquete", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquete.findAll", query = "SELECT p FROM Paquete p"),
    @NamedQuery(name = "Paquete.findByIdPaquete", query = "SELECT p FROM Paquete p WHERE p.idPaquete = :idPaquete"),
    @NamedQuery(name = "Paquete.findByDescripcion", query = "SELECT p FROM Paquete p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Paquete.findByPeso", query = "SELECT p FROM Paquete p WHERE p.peso = :peso"),
    @NamedQuery(name = "Paquete.findByLongitud", query = "SELECT p FROM Paquete p WHERE p.longitud = :longitud"),
    @NamedQuery(name = "Paquete.findByAltura", query = "SELECT p FROM Paquete p WHERE p.altura = :altura"),
    @NamedQuery(name = "Paquete.findByAnchura", query = "SELECT p FROM Paquete p WHERE p.anchura = :anchura"),
    @NamedQuery(name = "Paquete.findByIdentificacionTrackingCurrierExterno", query = "SELECT p FROM Paquete p WHERE p.identificacionTrackingCurrierExterno = :identificacionTrackingCurrierExterno")})
public class Paquete implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paquete")
    private Integer idPaquete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "peso")
    private Integer peso;
    @Column(name = "longitud")
    private Integer longitud;
    @Column(name = "altura")
    private Integer altura;
    @Column(name = "anchura")
    private Integer anchura;
    @Size(max = 100)
    @Column(name = "identificacion_tracking_currier_externo")
    private String identificacionTrackingCurrierExterno;
    @JoinColumn(name = "courrier_externo", referencedColumnName = "id_courrier_externo")
    @ManyToOne
    private CourrierExterno courrierExterno;
    @JoinColumn(name = "carga", referencedColumnName = "id_carga")
    @ManyToOne(optional = false)
    private Carga carga;

    public Paquete() {
    }

    public Paquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Paquete(Integer idPaquete, String descripcion) {
        this.idPaquete = idPaquete;
        this.descripcion = descripcion;
    }

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Integer idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getAnchura() {
        return anchura;
    }

    public void setAnchura(Integer anchura) {
        this.anchura = anchura;
    }

    public String getIdentificacionTrackingCurrierExterno() {
        return identificacionTrackingCurrierExterno;
    }

    public void setIdentificacionTrackingCurrierExterno(String identificacionTrackingCurrierExterno) {
        this.identificacionTrackingCurrierExterno = identificacionTrackingCurrierExterno;
    }

    public CourrierExterno getCourrierExterno() {
        return courrierExterno;
    }

    public void setCourrierExterno(CourrierExterno courrierExterno) {
        this.courrierExterno = courrierExterno;
    }

    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaquete != null ? idPaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquete)) {
            return false;
        }
        Paquete other = (Paquete) object;
        if ((this.idPaquete == null && other.idPaquete != null) || (this.idPaquete != null && !this.idPaquete.equals(other.idPaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entity.main.Paquete[ idPaquete=" + idPaquete + " ]";
    }
    
}
