package com.seia.gp.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2018-11-20T23:39:38")
@StaticMetamodel(Usuario.class)
public class Usuario_ extends Persona_ {

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, String> tipo;
    public static volatile SingularAttribute<Usuario, Short> estado;
    public static volatile SingularAttribute<Usuario, String> username;

}