package com.pragma.cliente.dominio.servicio.impl;

import com.pragma.cliente.dominio.modelo.CiudadModelo;
import com.pragma.cliente.dominio.repositorio.CiudadRepositorio;
import com.pragma.cliente.dominio.servicio.interfaces.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CiudadServicioImpl implements CiudadServicio {

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    @Override
    public CiudadModelo obtenerCiudadPorId(Long id) {
         Optional<CiudadModelo> ciudadModeloRetorno = ciudadRepositorio.obtenerCiudadPorId(id);
        return ciudadModeloRetorno.get();
    }
}
