package com.pragma.cliente.dominio.servicio.interfaces;

import com.pragma.cliente.dominio.modelo.CiudadModelo;

public interface CiudadServicio {

    public abstract CiudadModelo obtenerCiudadPorId(Long id);

}
