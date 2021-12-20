package com.pragma.cliente.dominio.repositorio;

import com.pragma.cliente.persistencia.entidad.Ciudad;
import com.pragma.cliente.persistencia.mapeador.CiudadMapeador;
import com.pragma.cliente.dominio.modelo.CiudadModelo;
import com.pragma.cliente.persistencia.crud.CiudadCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CiudadRepositorio {

    @Autowired
    private CiudadCrud ciudadCrud;

    @Autowired
    private CiudadMapeador ciudadMapeador;

    public Optional<CiudadModelo> obtenerCiudadPorId(Long id){
        Optional<Ciudad> ciudad = ciudadCrud.findById(id);
        return  Optional.ofNullable(ciudadMapeador.convertirCiudadModelo(ciudad.get()));
    }

}
