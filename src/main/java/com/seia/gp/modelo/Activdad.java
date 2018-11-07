/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leo
 */
@Entity
@Table(name = "activdad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activdad.findAll", query = "SELECT a FROM Activdad a")
    , @NamedQuery(name = "Activdad.findById", query = "SELECT a FROM Activdad a WHERE a.id = :id")
    , @NamedQuery(name = "Activdad.findByNombre", query = "SELECT a FROM Activdad a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Activdad.findByFechaInicio", query = "SELECT a FROM Activdad a WHERE a.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Activdad.findByFechaFin", query = "SELECT a FROM Activdad a WHERE a.fechaFin = :fechaFin")
    , @NamedQuery(name = "Activdad.findByAvance", query = "SELECT a FROM Activdad a WHERE a.avance = :avance")
    , @NamedQuery(name = "Activdad.findByObservaciones", query = "SELECT a FROM Activdad a WHERE a.observaciones = :observaciones")})
public class Activdad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "avance")
    private String avance;
    @Size(max = 200)
    @Column(name = "Observaciones")
    private String observaciones;

    
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id")
    @ManyToOne
    private Proyecto proyecto;
    @OneToMany(mappedBy = "activdad")
    private List<Reunionactividad> reunionactividadList;

    public Activdad() {
    }

    public Activdad(Integer id) {
        this.id = id;
    }

    public Activdad(Integer id, String nombre, Date fechaInicio, String avance) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.avance = avance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getAvance() {
        return avance;
    }

    public void setAvance(String avance) {
        this.avance = avance;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }


    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @XmlTransient
    public List<Reunionactividad> getReunionactividadList() {
        return reunionactividadList;
    }

    public void setReunionactividadList(List<Reunionactividad> reunionactividadList) {
        this.reunionactividadList = reunionactividadList;
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
        if (!(object instanceof Activdad)) {
            return false;
        }
        Activdad other = (Activdad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.seia.gp.modelo.Activdad[ id=" + id + " ]";
    }
    
}
