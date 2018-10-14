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
import com.seia.gp.modelo.Rol;
import com.seia.gp.servicio.RolFacadeLocal;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import org.primefaces.event.RowEditEvent;

@Named("rolBean")
@ViewScoped
public class RolBean implements Serializable{
   
    @Inject
    private RolFacadeLocal rolService;
    private Rol rolSeleccionado;
    List<Rol> roles;

    @PostConstruct
    public void inicializar(){
        roles = rolService.findAll();
        rolSeleccionado = new Rol();
    }
    
    public RolBean() {
    }
    
    public RolFacadeLocal getRolService() {
        return rolService;
    }

    public void setRolService(RolFacadeLocal rolService) {
        this.rolService = rolService;
    }

    public Rol getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Rol rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    
        
    
    public void reiniciarSeleccionado() {
        this.rolSeleccionado = new Rol();
    }
    
    public void agregar() {
        rolService.create(this.rolSeleccionado);
        this.rolSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminar() {
        rolService.remove(this.rolSeleccionado);
        this.rolSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }
    
    public void editListener(RowEditEvent event) {
        Rol rol = (Rol) event.getObject();
        rolService.edit(rol);
    }
    
}
