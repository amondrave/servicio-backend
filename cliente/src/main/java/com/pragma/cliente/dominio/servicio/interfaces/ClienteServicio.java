package com.pragma.cliente.dominio.servicio.interfaces;

import com.pragma.cliente.dominio.modelo.ClienteModelo;

import java.util.List;

public interface ClienteServicio {

    public abstract List<ClienteModelo> obtenerTodos();

    public abstract List<ClienteModelo> obtenerListaClientePorEdad(Integer edad);

    public abstract ClienteModelo obtenerPorId(Long id);

    public abstract  ClienteModelo guardar(ClienteModelo clienteModelo);

    public abstract  void eliminar(Long id);

}
