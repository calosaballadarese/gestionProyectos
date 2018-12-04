/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.controlador;

import com.seia.gp.modelo.Actividad;
import com.seia.gp.modelo.Proyecto;
import com.seia.gp.modelo.Estado;
import com.seia.gp.modelo.Recurso;
import com.seia.gp.servicio.ProyectoFacadeLocal;
import com.seia.gp.servicio.RecursoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@ViewScoped
public class ProyectoBean implements Serializable {
        
    @Inject
    private ProyectoFacadeLocal proyectoService;
    private RecursoFacadeLocal recursoService;
    private Proyecto proyecto;
    private Estado estado;
    private Actividad actividad;
    private Recurso recurso;
    
    List<Proyecto> proyectos;
    List<Actividad> actividades;
    List<Recurso> recursos;
  
    @PostConstruct
    public void inicializar(){
        proyectos = proyectoService.findAll();
        proyecto = new Proyecto(); 
        estado = new Estado();
        estado.setId(1);
        proyecto.setEstado(estado);
        recursos = recursoService.findAll();
    }
    
    public ProyectoBean (){}
    
}
