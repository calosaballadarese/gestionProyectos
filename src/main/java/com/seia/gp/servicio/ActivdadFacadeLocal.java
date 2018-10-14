/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.servicio;

import com.seia.gp.modelo.Activdad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leo
 */
@Local
public interface ActivdadFacadeLocal {

    void create(Activdad activdad);

    void edit(Activdad activdad);

    void remove(Activdad activdad);

    Activdad find(Object id);

    List<Activdad> findAll();

    List<Activdad> findRange(int[] range);

    int count();
    
}
