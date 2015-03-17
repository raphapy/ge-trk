/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.main;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "sitio_recepcion_envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitioRecepcionEnvio.findAll", query = "SELECT s FROM SitioRecepcionEnvio s"),
    @NamedQuery(name = "SitioRecepcionEnvio.findByIdSitioRecepcionEnvio", query = "SELECT s FROM SitioRecepcionEnvio s WHERE s.idSitioRecepcionEnvio = :idSitioRecepcionEnvio"),
    @NamedQuery(name = "SitioRecepcionEnvio.findByNombre", query = "SELECT s FROM SitioRecepcionEnvio s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SitioRecepcionEnvio.findByDescripcion", query = "SELECT s FROM SitioRecepcionEnvio s WHERE s.descripcion = :descripcion")})
public class SitioRecepcionEnvio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sitio_recepcion_envio")
    private Integer idSitioRecepcionEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "origen")
    private List<DetalleTrackingPaquete> detalleTrackingPaqueteList;
    @OneToMany(mappedBy = "destino")
    private List<DetalleTrackingPaquete> detalleTrackingPaqueteList1;
    @OneToMany(mappedBy = "origen")
    private List<DetalleTrackingCarga> detalleTrackingCargaList;
    @OneToMany(mappedBy = "destino")
    private List<DetalleTrackingCarga> detalleTrackingCargaList1;

    public SitioRecepcionEnvio() {
    }

    public SitioRecepcionEnvio(Integer idSitioRecepcionEnvio) {
        this.idSitioRecepcionEnvio = idSitioRecepcionEnvio;
    }

    public SitioRecepcionEnvio(Integer idSitioRecepcionEnvio, String nombre) {
        this.idSitioRecepcionEnvio = idSitioRecepcionEnvio;
        this.nombre = nombre;
    }

    public Integer getIdSitioRecepcionEnvio() {
        return idSitioRecepcionEnvio;
    }

    public void setIdSitioRecepcionEnvio(Integer idSitioRecepcionEnvio) {
        this.idSitioRecepcionEnvio = idSitioRecepcionEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DetalleTrackingPaquete> getDetalleTrackingPaqueteList() {
        return detalleTrackingPaqueteList;
    }

    public void setDetalleTrackingPaqueteList(List<DetalleTrackingPaquete> detalleTrackingPaqueteList) {
        this.detalleTrackingPaqueteList = detalleTrackingPaqueteList;
    }

    @XmlTransient
    public List<DetalleTrackingPaquete> getDetalleTrackingPaqueteList1() {
        return detalleTrackingPaqueteList1;
    }

    public void setDetalleTrackingPaqueteList1(List<DetalleTrackingPaquete> detalleTrackingPaqueteList1) {
        this.detalleTrackingPaqueteList1 = detalleTrackingPaqueteList1;
    }

    @XmlTransient
    public List<DetalleTrackingCarga> getDetalleTrackingCargaList() {
        return detalleTrackingCargaList;
    }

    public void setDetalleTrackingCargaList(List<DetalleTrackingCarga> detalleTrackingCargaList) {
        this.detalleTrackingCargaList = detalleTrackingCargaList;
    }

    @XmlTransient
    public List<DetalleTrackingCarga> getDetalleTrackingCargaList1() {
        return detalleTrackingCargaList1;
    }

    public void setDetalleTrackingCargaList1(List<DetalleTrackingCarga> detalleTrackingCargaList1) {
        this.detalleTrackingCargaList1 = detalleTrackingCargaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSitioRecepcionEnvio != null ? idSitioRecepcionEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SitioRecepcionEnvio)) {
            return false;
        }
        SitioRecepcionEnvio other = (SitioRecepcionEnvio) object;
        if ((this.idSitioRecepcionEnvio == null && other.idSitioRecepcionEnvio != null) || (this.idSitioRecepcionEnvio != null && !this.idSitioRecepcionEnvio.equals(other.idSitioRecepcionEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.SitioRecepcionEnvio[ idSitioRecepcionEnvio=" + idSitioRecepcionEnvio + " ]";
    }
    
}
