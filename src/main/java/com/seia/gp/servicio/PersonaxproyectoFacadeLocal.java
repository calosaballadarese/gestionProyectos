/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.servicio;

import com.seia.gp.modelo.Personaxproyecto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leo
 */
@Local
public interface PersonaxproyectoFacadeLocal {

    void create(Personaxproyecto personaxproyecto);

    void edit(Personaxproyecto personaxproyecto);

    void remove(Personaxproyecto personaxproyecto);

    Personaxproyecto find(Object id);

    List<Personaxproyecto> findAll();

    List<Personaxproyecto> findRange(int[] range);

    int count();
    
}
