/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.modelo;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leo
 */
@Entity
@Table(name = "personaxproyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personaxproyecto.findAll", query = "SELECT p FROM Personaxproyecto p")
    , @NamedQuery(name = "Personaxproyecto.findById", query = "SELECT p FROM Personaxproyecto p WHERE p.id = :id")})
public class Personaxproyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rol rol;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proyecto proyecto;
    @OneToMany(mappedBy = "personaxproyecto")
    private List<Personaxactividad> personaxactividadList;

    public Personaxproyecto() {
    }

    public Personaxproyecto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @XmlTransient
    public List<Personaxactividad> getPersonaxactividadList() {
        return personaxactividadList;
    }

    public void setPersonaxactividadList(List<Personaxactividad> personaxactividadList) {
        this.personaxactividadList = personaxactividadList;
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
        if (!(object instanceof Personaxproyecto)) {
            return false;
        }
        Personaxproyecto other = (Personaxproyecto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seia.gp.modelo.Personaxproyecto[ id=" + id + " ]";
    }
    
}
