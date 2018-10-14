/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seia.gp.servicio;

import com.seia.gp.modelo.Tiporeunion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Leo
 */
@Local
public interface TiporeunionFacadeLocal {

    void create(Tiporeunion tiporeunion);

    void edit(Tiporeunion tiporeunion);

    void remove(Tiporeunion tiporeunion);

    Tiporeunion find(Object id);

    List<Tiporeunion> findAll();

    List<Tiporeunion> findRange(int[] range);

    int count();
    
}
