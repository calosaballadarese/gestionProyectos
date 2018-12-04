/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.controlador;

import com.seia.gp.modelo.Recurso;
import com.seia.gp.servicio.RecursoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Leo
 */
@Named("recursoBean")
@ViewScoped
public class RecursoBean implements Serializable {

   
    @Inject
    private RecursoFacadeLocal recursoService;
    private Recurso recursoSeleccionado;
    List<Recurso> recursos;

    @PostConstruct
    public void inicializar(){
        recursos = recursoService.findAll();
        recursoSeleccionado = new Recurso();
    }
    
    public RecursoBean() {
    }

    public RecursoFacadeLocal getRecursoService() {
        return recursoService;
    }

    public void setRecursoService(RecursoFacadeLocal recursoService) {
        this.recursoService = recursoService;
    }

    public Recurso getRecursoSeleccionado() {
        return recursoSeleccionado;
    }

    public void setRecursoSeleccionado(Recurso recursoSeleccionado) {
        this.recursoSeleccionado = recursoSeleccionado;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }
    
    
    
    public void reiniciarSeleccionado() {
        this.recursoSeleccionado = new Recurso();
    }
    
    public void agregar() {
        recursoService.create(this.recursoSeleccionado);
        this.recursoSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminar() {
        recursoService.remove(this.recursoSeleccionado);
        this.recursoSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }
    
    public void editListener(RowEditEvent event) {
        Recurso recurso = (Recurso) event.getObject();
        recursoService.edit(recurso);
    }
    
}

