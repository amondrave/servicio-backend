package com.pragma.cliente.dominio.servicio.interfaces;

import com.pragma.cliente.dominio.modelo.TipoDocumentoModelo;

public interface TipoDocumentoServicio {

    public abstract TipoDocumentoModelo obtenerPorId(Long id);

}
