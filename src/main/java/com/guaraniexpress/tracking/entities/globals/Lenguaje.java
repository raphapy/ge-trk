/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.globals;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

import com.guaraniexpress.tracking.entities.application.Usuario;

/**
 *
 * @author raphapy
 */
@Entity
@Table(name = "lenguaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lenguaje.findAll", query = "SELECT l FROM Lenguaje l"),
    @NamedQuery(name = "Lenguaje.findByIdLenguaje", query = "SELECT l FROM Lenguaje l WHERE l.idLenguaje = :idLenguaje"),
    @NamedQuery(name = "Lenguaje.findByCodigo", query = "SELECT l FROM Lenguaje l WHERE l.codigo = :codigo"),
    @NamedQuery(name = "Lenguaje.findByNombre", query = "SELECT l FROM Lenguaje l WHERE l.nombre = :nombre")})
public class Lenguaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lenguaje")
    private Integer idLenguaje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lenguaje")
    private List<Usuario> usuarioList;

    public Lenguaje() {
    }

    public Lenguaje(Integer idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    public Lenguaje(Integer idLenguaje, String codigo, String nombre) {
        this.idLenguaje = idLenguaje;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getIdLenguaje() {
        return idLenguaje;
    }

    public void setIdLenguaje(Integer idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLenguaje != null ? idLenguaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lenguaje)) {
            return false;
        }
        Lenguaje other = (Lenguaje) object;
        if ((this.idLenguaje == null && other.idLenguaje != null) || (this.idLenguaje != null && !this.idLenguaje.equals(other.idLenguaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.Lenguaje[ idLenguaje=" + idLenguaje + " ]";
    }
    
}
