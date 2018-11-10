package com.seia.gp.modelo;

import com.seia.gp.modelo.Activdad;
import com.seia.gp.modelo.Reunion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2018-11-07T23:52:37")
@StaticMetamodel(Reunionactividad.class)
public class Reunionactividad_ { 

    public static volatile SingularAttribute<Reunionactividad, Integer> idReunion;
    public static volatile SingularAttribute<Reunionactividad, String> queharahoy;
    public static volatile SingularAttribute<Reunionactividad, Activdad> activdad;
    public static volatile SingularAttribute<Reunionactividad, String> observaciones;
    public static volatile SingularAttribute<Reunionactividad, Reunion> reunion;
    public static volatile SingularAttribute<Reunionactividad, String> quehizoayer;
    public static volatile SingularAttribute<Reunionactividad, String> queimpideelavance;

}