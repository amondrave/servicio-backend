package com.pragma.cliente.dominio.servicio.impl;

import com.pragma.cliente.dominio.modelo.FotoModelo;
import com.pragma.cliente.dominio.repositorio.FotoRepositorio;
import com.pragma.cliente.dominio.servicio.interfaces.FotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FotoServicioImpl implements FotoServicio {

    @Autowired
    private FotoRepositorio fotoRepositorio;

    @Override
    public FotoModelo obtenerPorId(String id) {
        Optional<FotoModelo> fotoModeloRetorno = fotoRepositorio.obtenerFotoPorId(id);
        return fotoModeloRetorno.get();
    }

    @Override
    public FotoModelo guardar(FotoModelo fotoModelo) {
        Optional<FotoModelo> fotoModeloRetorno = fotoRepositorio.guardar(fotoModelo);
        return fotoModeloRetorno.get();
    }

    @Override
    public void eliminarPorId(String id) {
        fotoRepositorio.eliminarPorId(id);
    }
}
