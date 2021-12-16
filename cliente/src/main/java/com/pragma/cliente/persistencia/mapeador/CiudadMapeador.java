package com.pragma.cliente.persistencia.mapeador;

import com.pragma.cliente.dominio.modelo.CiudadModelo;
import com.pragma.cliente.persistencia.entidad.Ciudad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CiudadMapeador {


    CiudadModelo convertirCiudadModelo(Ciudad ciudad);

    @InheritInverseConfiguration
    Ciudad convertirCiudad(CiudadModelo ciudadModelo);

}
