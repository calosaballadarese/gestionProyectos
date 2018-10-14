/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.controlador;


import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import com.seia.gp.modelo.Estado;
import com.seia.gp.servicio.EstadoFacadeLocal;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;

@Named("estadoBean")
@ViewScoped
public class EstadoBean implements Serializable{
   @Inject
    private EstadoFacadeLocal estadoService;
    private Estado estadoSeleccionado;
    List<Estado> estados; 
    
    @PostConstruct
    public void inicializar(){
        estados = estadoService.findAll();
        estadoSeleccionado = new Estado();
    }
    
    public EstadoBean (){}

    public EstadoFacadeLocal getEstadoService() {
        return estadoService;
    }

    public void setEstadoService(EstadoFacadeLocal estadoService) {
        this.estadoService = estadoService;
    }

    public Estado getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(Estado estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }
    
    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
    
    
    public void reiniciarSeleccionado() {
        this.estadoSeleccionado = new Estado();
    }
    
    
    public void agregar() {
        estadoService.create(this.estadoSeleccionado);
        this.estadoSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminar() {
        estadoService.remove(this.estadoSeleccionado);
        this.estadoSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }
    
    public void editListener(RowEditEvent event) {
        Estado estado = (Estado) event.getObject();
        estadoService.edit(estado);
    }
    
}
