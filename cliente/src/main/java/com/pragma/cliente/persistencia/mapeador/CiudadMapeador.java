package com.pragma.cliente.persistencia.mapeador;

import com.pragma.cliente.dominio.modelo.CiudadModelo;
import com.pragma.cliente.persistencia.entidad.Ciudad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CiudadMapeador {


    CiudadModelo convertirCiudadModelo(Ciudad ciudad);

    List<CiudadModelo> convertirCiudadModelo(List<Ciudad> listaCiudad);

    @InheritInverseConfiguration
    Ciudad convertirCiudad(CiudadModelo ciudadModelo);

}
