package com.seia.gp.modelo;

import com.seia.gp.modelo.Proyecto;
import com.seia.gp.modelo.Reunionactividad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2018-11-11T16:32:58")
@StaticMetamodel(Activdad.class)
public class Activdad_ { 

    public static volatile SingularAttribute<Actividad, Date> fechaInicio;
    public static volatile SingularAttribute<Actividad, String> avance;
    public static volatile SingularAttribute<Actividad, String> observaciones;
    public static volatile SingularAttribute<Actividad, Proyecto> proyecto;
    public static volatile SingularAttribute<Actividad, Integer> id;
    public static volatile SingularAttribute<Actividad, String> nombre;
    public static volatile SingularAttribute<Actividad, Date> fechaFin;
    public static volatile ListAttribute<Actividad, Reunionactividad> reunionactividadList;

}