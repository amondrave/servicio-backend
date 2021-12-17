package com.pragma.cliente.dominio.servicio.impl;

import com.pragma.cliente.dominio.modelo.TipoDocumentoModelo;
import com.pragma.cliente.dominio.repositorio.TipoDocumentoRepositorio;
import com.pragma.cliente.dominio.servicio.interfaces.TipoDocumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoDocumentoServicioImpl implements TipoDocumentoServicio {

    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    @Override
    public TipoDocumentoModelo obtenerPorId(Long id) {
        Optional<TipoDocumentoModelo> tipoDocumentoModeloRetorno = tipoDocumentoRepositorio.obtenerTipoDocumentoPorId(id);
        return tipoDocumentoModeloRetorno.get();
    }
}
