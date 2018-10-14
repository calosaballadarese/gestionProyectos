/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leo
 */
@Entity
@Table(name = "reunion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reunion.findAll", query = "SELECT r FROM Reunion r")
    , @NamedQuery(name = "Reunion.findById", query = "SELECT r FROM Reunion r WHERE r.id = :id")
    , @NamedQuery(name = "Reunion.findByFecha", query = "SELECT r FROM Reunion r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Reunion.findByObservaciones", query = "SELECT r FROM Reunion r WHERE r.observaciones = :observaciones")})
public class Reunion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 200)
    @Column(name = "observaciones")
    private String observaciones;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reunion")
    private Reunionactividad reunionactividad;
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id")
    @ManyToOne
    private Proyecto proyecto;
    @JoinColumn(name = "id_tiporeunion", referencedColumnName = "id")
    @ManyToOne
    private Tiporeunion tiporeunion;

    public Reunion() {
    }

    public Reunion(Integer id) {
        this.id = id;
    }

    public Reunion(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Reunionactividad getReunionactividad() {
        return reunionactividad;
    }

    public void setReunionactividad(Reunionactividad reunionactividad) {
        this.reunionactividad = reunionactividad;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Tiporeunion getTiporeunion() {
        return tiporeunion;
    }

    public void setTiporeunion(Tiporeunion tiporeunion) {
        this.tiporeunion = tiporeunion;
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
        if (!(object instanceof Reunion)) {
            return false;
        }
        Reunion other = (Reunion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seia.gp.modelo.Reunion[ id=" + id + " ]";
    }
    
}
