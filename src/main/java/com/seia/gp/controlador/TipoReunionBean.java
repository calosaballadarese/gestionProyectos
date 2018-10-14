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
import com.seia.gp.modelo.Tiporeunion;
import com.seia.gp.servicio.TiporeunionFacadeLocal;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;

@Named("tiporeunionBean")
@ViewScoped
public class TipoReunionBean implements Serializable {
    
    @Inject
    private TiporeunionFacadeLocal tiporeunionService;
    private Tiporeunion tiporeunionSeleccionado;
    List<Tiporeunion> tiporeuniones;
    
    @PostConstruct
    public void inicializar(){
        tiporeuniones = tiporeunionService.findAll();
        tiporeunionSeleccionado = new Tiporeunion();
    }
    
    public TipoReunionBean (){}

    public TiporeunionFacadeLocal getTiporeunionService() {
        return tiporeunionService;
    }

    public void setTiporeunionService(TiporeunionFacadeLocal tiporeunionService) {
        this.tiporeunionService = tiporeunionService;
    }

    public Tiporeunion getTiporeunionSeleccionado() {
        return tiporeunionSeleccionado;
    }

    public void setTiporeunionSeleccionado(Tiporeunion tiporeunionSeleccionado) {
        this.tiporeunionSeleccionado = tiporeunionSeleccionado;
    }

    public List<Tiporeunion> getTiporeuniones() {
        return tiporeuniones;
    }

    public void setTiporeuniones(List<Tiporeunion> tiporeuniones) {
        this.tiporeuniones = tiporeuniones;
    }
    
    
    public void reiniciarSeleccionado() {
        this.tiporeunionSeleccionado = new Tiporeunion();
    }
    
    public void agregar() {
        tiporeunionService.create(this.tiporeunionSeleccionado);
        this.tiporeunionSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminar() {
        tiporeunionService.remove(this.tiporeunionSeleccionado);
        this.tiporeunionSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }
    
    public void editListener(RowEditEvent event) {
        Tiporeunion tiporeunion = (Tiporeunion) event.getObject();
        tiporeunionService.edit(tiporeunion);
    }
    
    
    
    
    
}
