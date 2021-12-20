package com.pragma.cliente.dominio.servicio.interfaces;

import com.pragma.cliente.dominio.modelo.ClienteModelo;
import javassist.NotFoundException;

import java.util.List;

public interface ClienteServicio {

    public abstract List<ClienteModelo> obtenerTodos() throws NotFoundException;

    public abstract List<ClienteModelo> obtenerListaClientePorEdad(Integer edad) throws NotFoundException;

    public abstract ClienteModelo obtenerPorId(Long id) throws NotFoundException;

    public abstract ClienteModelo obtenerPorNumeroDocumento(String numeroDocumento) throws NotFoundException;

    public abstract  ClienteModelo guardar(ClienteModelo clienteModelo) throws NotFoundException;

    public abstract ClienteModelo actualizar(ClienteModelo clienteModelo) throws NotFoundException;

    public abstract  void eliminar(Long id) throws NotFoundException;

}
