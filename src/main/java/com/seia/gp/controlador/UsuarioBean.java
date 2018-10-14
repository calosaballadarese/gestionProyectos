/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.controlador;

import java.util.List;
import com.seia.gp.modelo.Persona;
import com.seia.gp.modelo.Usuario;
import com.seia.gp.servicio.UsuarioFacadeLocal;
import java.io.Serializable;
import static java.sql.DriverManager.println;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named
@ViewScoped
public class UsuarioBean implements Serializable{
    
    @Inject
    private UsuarioFacadeLocal usuarioService;
    private Usuario usuario;
    private Persona persona;
    List<Usuario> usuarios; 

    
    @PostConstruct
    public void inicializar(){
        usuarios = usuarioService.findAll();
        usuario = new Usuario();
        persona = new Persona();    
    }
    
    public UsuarioBean (){}
    
    
    
    public UsuarioFacadeLocal getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioFacadeLocal usuarioService) {
        this.usuarioService = usuarioService;
    }

   public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
     public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    public void registrar(){
        try{
            this.usuario.setPersona(persona);
            usuarioService.create(usuario);
            System.out.println(persona);
            System.out.println(usuario);            
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Se registró exitosamente"));          
        }catch (Exception e){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Error",e.toString()));
        }
    }
    
     public void reiniciarSeleccionado() {
        this.usuario = new Usuario();
    }
    
    
    public void agregar() {
        usuarioService.create(this.usuario);
        this.usuario = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminar() {
        usuarioService.remove(this.usuario);
        this.usuario = null;
        //actualizamos la lista
        this.inicializar();
    }
    
    public void editListener(RowEditEvent event) {
        Usuario usuario = (Usuario) event.getObject();
        usuarioService.edit(usuario);
    }
}

