package com.seia.gp.modelo;

import com.seia.gp.modelo.Proyecto;
import com.seia.gp.modelo.Reunionactividad;
import com.seia.gp.modelo.Tiporeunion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2018-11-20T23:39:38")
@StaticMetamodel(Reunion.class)
public class Reunion_ { 

    public static volatile SingularAttribute<Reunion, Date> fecha;
    public static volatile SingularAttribute<Reunion, Reunionactividad> reunionactividad;
    public static volatile SingularAttribute<Reunion, String> observaciones;
    public static volatile SingularAttribute<Reunion, Proyecto> proyecto;
    public static volatile SingularAttribute<Reunion, Integer> id;
    public static volatile SingularAttribute<Reunion, Tiporeunion> tiporeunion;

}