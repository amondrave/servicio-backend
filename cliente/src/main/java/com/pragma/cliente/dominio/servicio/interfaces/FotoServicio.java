package com.pragma.cliente.dominio.servicio.interfaces;

import com.pragma.cliente.dominio.modelo.FotoModelo;

public interface FotoServicio {

    public abstract FotoModelo obtenerPorId(String id);

    public abstract FotoModelo guardar(FotoModelo fotoModelo);

    public abstract void eliminarPorId(String id);

}
