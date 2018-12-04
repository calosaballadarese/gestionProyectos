/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.modelo;

import java.io.Serializable;
import java.util.Objects;
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "recurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recurso.findAll", query = "SELECT r FROM Recurso r")
    , @NamedQuery(name = "Recurso.findById", query = "SELECT r FROM Recurso r WHERE r.id = :id")})
public class Recurso implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne
    private Proyecto persona;
    
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id")
    @ManyToOne
    private Proyecto proyecto;

    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    @ManyToOne
    private Rol rol;
    
    public Recurso() {
    }  

       public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proyecto getPersona() {
        return persona;
    }

    public void setPersona(Proyecto persona) {
        this.persona = persona;
    }
    
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public Rol getRol() {
        return rol;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recurso other = (Recurso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
