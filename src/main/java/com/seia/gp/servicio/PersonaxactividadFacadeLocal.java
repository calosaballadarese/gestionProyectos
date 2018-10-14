/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.servicio;

import com.seia.gp.modelo.Personaxactividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leo
 */
@Local
public interface PersonaxactividadFacadeLocal {

    void create(Personaxactividad personaxactividad);

    void edit(Personaxactividad personaxactividad);

    void remove(Personaxactividad personaxactividad);

    Personaxactividad find(Object id);

    List<Personaxactividad> findAll();

    List<Personaxactividad> findRange(int[] range);

    int count();
    
}
