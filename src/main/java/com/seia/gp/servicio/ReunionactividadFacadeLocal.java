/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.servicio;

import com.seia.gp.modelo.Reunionactividad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leo
 */
@Local
public interface ReunionactividadFacadeLocal {

    void create(Reunionactividad reunionactividad);

    void edit(Reunionactividad reunionactividad);

    void remove(Reunionactividad reunionactividad);

    Reunionactividad find(Object id);

    List<Reunionactividad> findAll();

    List<Reunionactividad> findRange(int[] range);

    int count();
    
}
