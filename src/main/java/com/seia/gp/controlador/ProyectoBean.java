/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.controlador;


import com.seia.gp.modelo.Proyecto;
import com.seia.gp.servicio.ProyectoFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named
@ViewScoped
public class ProyectoBean implements Serializable {
        
    @Inject
    private ProyectoFacadeLocal proyectoService;
    private Proyecto proyecto;
    List<Proyecto> proyectos;
    
    
  
    @PostConstruct
    public void inicializar(){
        proyectos = proyectoService.findAll();
        proyecto = new Proyecto(); 

    }
    
    public ProyectoBean (){}

    public ProyectoFacadeLocal getProyectoService() {
        return proyectoService;
    }

    public void setProyectoService(ProyectoFacadeLocal proyectoService) {
        this.proyectoService = proyectoService;
    }

  
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    
     public void registrar(){
        try{
            java.util.Date fecha = new Date();
            proyecto.setFechaInicio(fecha);
            proyecto.setAvance(0);
            proyectoService.create(proyecto);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró exitosamente"));          
       
        }
        catch (Exception e){
            System.out.println(e);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Error", e.toString() + "--" + e.getMessage()));
        } 
    }
}
