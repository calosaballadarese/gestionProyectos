package com.seia.gp.modelo;

import com.seia.gp.modelo.Activdad;
import com.seia.gp.modelo.Estado;
import com.seia.gp.modelo.Personaxproyecto;
import com.seia.gp.modelo.Reunion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2018-10-13T22:56:27")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, String> descripcion;
    public static volatile SingularAttribute<Proyecto, Estado> estado;
    public static volatile SingularAttribute<Proyecto, Date> fechaInicio;
    public static volatile SingularAttribute<Proyecto, Integer> avance;
    public static volatile ListAttribute<Proyecto, Personaxproyecto> personaxproyectoList;
    public static volatile SingularAttribute<Proyecto, String> observaciones;
    public static volatile ListAttribute<Proyecto, Activdad> activdadList;
    public static volatile ListAttribute<Proyecto, Reunion> reunionList;
    public static volatile SingularAttribute<Proyecto, Integer> id;
    public static volatile SingularAttribute<Proyecto, String> nombre;
    public static volatile SingularAttribute<Proyecto, Date> fechaFin;

}