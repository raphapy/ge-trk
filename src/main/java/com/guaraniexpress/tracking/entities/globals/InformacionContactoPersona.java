/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guaraniexpress.tracking.entities.globals;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "informacion_contacto_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionContactoPersona.findAll", query = "SELECT i FROM InformacionContactoPersona i"),
    @NamedQuery(name = "InformacionContactoPersona.findByIdInformacionContactoPersona", query = "SELECT i FROM InformacionContactoPersona i WHERE i.informacionContactoPersonaPK.idInformacionContactoPersona = :idInformacionContactoPersona"),
    @NamedQuery(name = "InformacionContactoPersona.findByPersona", query = "SELECT i FROM InformacionContactoPersona i WHERE i.informacionContactoPersonaPK.persona = :persona"),
    @NamedQuery(name = "InformacionContactoPersona.findByValor", query = "SELECT i FROM InformacionContactoPersona i WHERE i.valor = :valor")})
public class InformacionContactoPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InformacionContactoPersonaPK informacionContactoPersonaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "dominio_informacion_contacto", referencedColumnName = "id_dominio_informacion_contacto")
    @ManyToOne(optional = false)
    private DominioInformacionContacto dominioInformacionContacto;
    @JoinColumn(name = "tipo_informacion_contacto", referencedColumnName = "id_tipo_informacion_contacto")
    @ManyToOne(optional = false)
    private TipoInformacionContacto tipoInformacionContacto;
    @JoinColumn(name = "persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona1;

    public InformacionContactoPersona() {
    }

    public InformacionContactoPersona(InformacionContactoPersonaPK informacionContactoPersonaPK) {
        this.informacionContactoPersonaPK = informacionContactoPersonaPK;
    }

    public InformacionContactoPersona(InformacionContactoPersonaPK informacionContactoPersonaPK, String valor) {
        this.informacionContactoPersonaPK = informacionContactoPersonaPK;
        this.valor = valor;
    }

    public InformacionContactoPersona(int idInformacionContactoPersona, int persona) {
        this.informacionContactoPersonaPK = new InformacionContactoPersonaPK(idInformacionContactoPersona, persona);
    }

    public InformacionContactoPersonaPK getInformacionContactoPersonaPK() {
        return informacionContactoPersonaPK;
    }

    public void setInformacionContactoPersonaPK(InformacionContactoPersonaPK informacionContactoPersonaPK) {
        this.informacionContactoPersonaPK = informacionContactoPersonaPK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public DominioInformacionContacto getDominioInformacionContacto() {
        return dominioInformacionContacto;
    }

    public void setDominioInformacionContacto(DominioInformacionContacto dominioInformacionContacto) {
        this.dominioInformacionContacto = dominioInformacionContacto;
    }

    public TipoInformacionContacto getTipoInformacionContacto() {
        return tipoInformacionContacto;
    }

    public void setTipoInformacionContacto(TipoInformacionContacto tipoInformacionContacto) {
        this.tipoInformacionContacto = tipoInformacionContacto;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (informacionContactoPersonaPK != null ? informacionContactoPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionContactoPersona)) {
            return false;
        }
        InformacionContactoPersona other = (InformacionContactoPersona) object;
        if ((this.informacionContactoPersonaPK == null && other.informacionContactoPersonaPK != null) || (this.informacionContactoPersonaPK != null && !this.informacionContactoPersonaPK.equals(other.informacionContactoPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "temp.InformacionContactoPersona[ informacionContactoPersonaPK=" + informacionContactoPersonaPK + " ]";
    }
    
}
