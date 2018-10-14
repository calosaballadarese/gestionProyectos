package com.seia.gp.modelo;

import com.seia.gp.modelo.Persona;
import com.seia.gp.modelo.Personaxactividad;
import com.seia.gp.modelo.Proyecto;
import com.seia.gp.modelo.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2018-10-13T22:56:27")
@StaticMetamodel(Personaxproyecto.class)
public class Personaxproyecto_ { 

    public static volatile SingularAttribute<Personaxproyecto, Persona> persona;
    public static volatile SingularAttribute<Personaxproyecto, Proyecto> proyecto;
    public static volatile ListAttribute<Personaxproyecto, Personaxactividad> personaxactividadList;
    public static volatile SingularAttribute<Personaxproyecto, Integer> id;
    public static volatile SingularAttribute<Personaxproyecto, Rol> rol;

}