/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.globals;

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
@Table(name = "informacion_contacto_persona", catalog = "guaraniexpress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionContactoPersona.findAll", query = "SELECT i FROM InformacionContactoPersona i"),
    @NamedQuery(name = "InformacionContactoPersona.findByIdInformacionContactoPersona", query = "SELECT i FROM InformacionContactoPersona i WHERE i.idInformacionContactoPersona = :idInformacionContactoPersona"),
    @NamedQuery(name = "InformacionContactoPersona.findByValor", query = "SELECT i FROM InformacionContactoPersona i WHERE i.valor = :valor"),
    @NamedQuery(name = "InformacionContactoPersona.findByPersona", query = "SELECT i FROM InformacionContactoPersona i WHERE i.persona = :persona")})
public class InformacionContactoPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_informacion_contacto_persona")
    private Integer idInformacionContactoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "persona")
    private int persona;
    @JoinColumn(name = "tipo_informacion_contacto", referencedColumnName = "id_tipo_informacion_contacto")
    @ManyToOne(optional = false)
    private TipoInformacionContacto tipoInformacionContacto;
    @JoinColumn(name = "dominio_informacion_contacto", referencedColumnName = "id_dominio_informacion_contacto")
    @ManyToOne(optional = false)
    private DominioInformacionContacto dominioInformacionContacto;

    public InformacionContactoPersona() {
    }

    public InformacionContactoPersona(Integer idInformacionContactoPersona) {
        this.idInformacionContactoPersona = idInformacionContactoPersona;
    }

    public InformacionContactoPersona(Integer idInformacionContactoPersona, String valor, int persona) {
        this.idInformacionContactoPersona = idInformacionContactoPersona;
        this.valor = valor;
        this.persona = persona;
    }

    public Integer getIdInformacionContactoPersona() {
        return idInformacionContactoPersona;
    }

    public void setIdInformacionContactoPersona(Integer idInformacionContactoPersona) {
        this.idInformacionContactoPersona = idInformacionContactoPersona;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public TipoInformacionContacto getTipoInformacionContacto() {
        return tipoInformacionContacto;
    }

    public void setTipoInformacionContacto(TipoInformacionContacto tipoInformacionContacto) {
        this.tipoInformacionContacto = tipoInformacionContacto;
    }

    public DominioInformacionContacto getDominioInformacionContacto() {
        return dominioInformacionContacto;
    }

    public void setDominioInformacionContacto(DominioInformacionContacto dominioInformacionContacto) {
        this.dominioInformacionContacto = dominioInformacionContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformacionContactoPersona != null ? idInformacionContactoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionContactoPersona)) {
            return false;
        }
        InformacionContactoPersona other = (InformacionContactoPersona) object;
        if ((this.idInformacionContactoPersona == null && other.idInformacionContactoPersona != null) || (this.idInformacionContactoPersona != null && !this.idInformacionContactoPersona.equals(other.idInformacionContactoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.guaraniexpress.tracking.entities.globals.InformacionContactoPersona[ idInformacionContactoPersona=" + idInformacionContactoPersona + " ]";
    }
    
}
