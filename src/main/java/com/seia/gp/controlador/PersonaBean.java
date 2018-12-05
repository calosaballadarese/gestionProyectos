/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.controlador;


import java.util.List;
import com.seia.gp.modelo.Persona;
import com.seia.gp.servicio.PersonaFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named
@ViewScoped
public class PersonaBean implements Serializable {
    
    @Inject
    private PersonaFacadeLocal personaService;
    private Persona personaSeleccionado;
    List<Persona> personas;

    public Persona getPersonaSeleccionado() {
        return personaSeleccionado;
    }

    public void setPersonaSeleccionado(Persona personaSeleccionado) {
        this.personaSeleccionado = personaSeleccionado;
    }

    
    @PostConstruct
    public void inicializar(){
        personas = personaService.findAll();
        personaSeleccionado = new Persona();
    }
    
    public PersonaBean (){}
    
    public PersonaFacadeLocal getPersonaService() {
        return personaService;
    }

    public void setPersonaService(PersonaFacadeLocal personaService) {
        this.personaService = personaService;
    }
   
     public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
     public void reiniciarSeleccionado() {
        this.personaSeleccionado = new Persona();
    }
    
    
    public void editListener(RowEditEvent event) {
        Persona persona = (Persona) event.getObject();
        personaService.edit(persona);
    }

}
