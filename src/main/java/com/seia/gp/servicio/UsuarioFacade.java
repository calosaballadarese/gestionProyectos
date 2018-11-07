/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.servicio;

import com.seia.gp.modelo.Persona;
import com.seia.gp.modelo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Leo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "gpPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public boolean comprobarIngreso(Usuario usuario) {
        boolean var1,var2, var3;
        
        TypedQuery<Usuario> consulta1= em.createNamedQuery("Usuario.findByUsername", Usuario.class);
        consulta1.setParameter("username", usuario.getUsername());
        var1 = consulta1.getResultList().isEmpty();
 
        TypedQuery<Persona> consulta2= em.createNamedQuery("Persona.findByEmail", Persona.class);
        consulta2.setParameter("email", usuario.getEmail());
        var2 = consulta2.getResultList().isEmpty();
        
        TypedQuery<Persona> consulta3= em.createNamedQuery("Persona.findByNombreApellido", Persona.class);
        consulta3.setParameter("nombre", usuario.getNombre());
        consulta3.setParameter("apellido", usuario.getApellido());
        var3 = consulta3.getResultList().isEmpty();
        
        return var1 && var2 && var3;
    }
    
}
