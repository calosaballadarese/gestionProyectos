package com.seia.gp.modelo;

import com.seia.gp.modelo.Proyecto;
import com.seia.gp.modelo.Reunionactividad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2018-11-06T23:33:01")
@StaticMetamodel(Activdad.class)
public class Activdad_ { 

    public static volatile SingularAttribute<Activdad, Date> fechaInicio;
    public static volatile SingularAttribute<Activdad, String> avance;
    public static volatile SingularAttribute<Activdad, String> observaciones;
    public static volatile SingularAttribute<Activdad, Proyecto> proyecto;
    public static volatile SingularAttribute<Activdad, Integer> id;
    public static volatile SingularAttribute<Activdad, String> nombre;
    public static volatile SingularAttribute<Activdad, Date> fechaFin;
    public static volatile ListAttribute<Activdad, Reunionactividad> reunionactividadList;

}