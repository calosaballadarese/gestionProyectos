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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leo
 */
@Entity
@Table(name = "reunionactividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reunionactividad.findAll", query = "SELECT r FROM Reunionactividad r")
    , @NamedQuery(name = "Reunionactividad.findByIdReunion", query = "SELECT r FROM Reunionactividad r WHERE r.idReunion = :idReunion")
    , @NamedQuery(name = "Reunionactividad.findByQuehizoayer", query = "SELECT r FROM Reunionactividad r WHERE r.quehizoayer = :quehizoayer")
    , @NamedQuery(name = "Reunionactividad.findByQueharahoy", query = "SELECT r FROM Reunionactividad r WHERE r.queharahoy = :queharahoy")
    , @NamedQuery(name = "Reunionactividad.findByQueimpideelavance", query = "SELECT r FROM Reunionactividad r WHERE r.queimpideelavance = :queimpideelavance")
    , @NamedQuery(name = "Reunionactividad.findByObservaciones", query = "SELECT r FROM Reunionactividad r WHERE r.observaciones = :observaciones")})
public class Reunionactividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reunion")
    private Integer idReunion;
    @Size(max = 200)
    @Column(name = "quehizoayer")
    private String quehizoayer;
    @Size(max = 200)
    @Column(name = "queharahoy")
    private String queharahoy;
    @Size(max = 200)
    @Column(name = "queimpideelavance")
    private String queimpideelavance;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_actividad", referencedColumnName = "id")
    @ManyToOne
    private Actividad activdad;
    @JoinColumn(name = "id_reunion", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Reunion reunion;

    public Reunionactividad() {
    }

    public Reunionactividad(Integer idReunion) {
        this.idReunion = idReunion;
    }

    public Integer getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(Integer idReunion) {
        this.idReunion = idReunion;
    }

    public String getQuehizoayer() {
        return quehizoayer;
    }

    public void setQuehizoayer(String quehizoayer) {
        this.quehizoayer = quehizoayer;
    }

    public String getQueharahoy() {
        return queharahoy;
    }

    public void setQueharahoy(String queharahoy) {
        this.queharahoy = queharahoy;
    }

    public String getQueimpideelavance() {
        return queimpideelavance;
    }

    public void setQueimpideelavance(String queimpideelavance) {
        this.queimpideelavance = queimpideelavance;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Actividad getActivdad() {
        return activdad;
    }

    public void setActivdad(Actividad activdad) {
        this.activdad = activdad;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReunion != null ? idReunion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reunionactividad)) {
            return false;
        }
        Reunionactividad other = (Reunionactividad) object;
        if ((this.idReunion == null && other.idReunion != null) || (this.idReunion != null && !this.idReunion.equals(other.idReunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seia.gp.modelo.Reunionactividad[ idReunion=" + idReunion + " ]";
    }
    
}
