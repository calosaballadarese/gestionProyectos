/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.modelo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leo
 */
@Entity
@Table(name = "personaxactividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personaxactividad.findAll", query = "SELECT p FROM Personaxactividad p")
    , @NamedQuery(name = "Personaxactividad.findById", query = "SELECT p FROM Personaxactividad p WHERE p.id = :id")})
public class Personaxactividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id")
    @ManyToOne
    private Activdad activdad;
    @JoinColumn(name = "id_personaxproyecto", referencedColumnName = "id")
    @ManyToOne
    private Personaxproyecto personaxproyecto;

    public Personaxactividad() {
    }

    public Personaxactividad(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Activdad getActivdad() {
        return activdad;
    }

    public void setActivdad(Activdad activdad) {
        this.activdad = activdad;
    }

    public Personaxproyecto getPersonaxproyecto() {
        return personaxproyecto;
    }

    public void setPersonaxproyecto(Personaxproyecto personaxproyecto) {
        this.personaxproyecto = personaxproyecto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personaxactividad)) {
            return false;
        }
        Personaxactividad other = (Personaxactividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seia.gp.modelo.Personaxactividad[ id=" + id + " ]";
    }
    
}
