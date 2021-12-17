package com.pragma.cliente.dominio.servicio.impl;

import com.pragma.cliente.dominio.modelo.ClienteModelo;
import com.pragma.cliente.dominio.modelo.FotoModelo;
import com.pragma.cliente.dominio.repositorio.ClienteRepositorio;
import com.pragma.cliente.dominio.servicio.interfaces.ClienteServicio;
import com.pragma.cliente.dominio.servicio.interfaces.FotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private FotoServicio fotoServicio;

    @Override
    public List<ClienteModelo> obtenerTodos() {
        List<ClienteModelo> listaClienteModeloRetorno = clienteRepositorio.obtenerTodo();
        listaClienteModeloRetorno.forEach(clienteModelo -> {
            FotoModelo fotoModelo =  fotoServicio.obtenerPorId(clienteModelo.getIdFoto());
            clienteModelo.setFoto(fotoModelo.getFoto());
        });
        return listaClienteModeloRetorno;
    }

    @Override
    public List<ClienteModelo> obtenerListaClientePorEdad(Integer edad) {
        List<ClienteModelo> listaClienteModeloRetorno = clienteRepositorio.obtenerListaClientePorEdad(edad);
        listaClienteModeloRetorno.forEach(clienteModelo -> {
            FotoModelo fotoModelo =  fotoServicio.obtenerPorId(clienteModelo.getIdFoto());
            clienteModelo.setFoto(fotoModelo.getFoto());
        });
        return listaClienteModeloRetorno;
    }

    @Override
    public ClienteModelo obtenerPorId(Long id) {
        ClienteModelo clienteModelo = clienteRepositorio.obtenerClientePorId(id).get();
        FotoModelo fotoModelo = fotoServicio.obtenerPorId(clienteModelo.getIdFoto());
        clienteModelo.setFoto(fotoModelo.getFoto());
        return clienteModelo;
    }

    @Override
    public ClienteModelo guardar(ClienteModelo clienteModelo) {
        FotoModelo fotoModelo = FotoModelo.builder()
                .foto(clienteModelo.getFoto())
                .build();
        fotoModelo = fotoServicio.guardar(fotoModelo);
        clienteModelo.setIdFoto(fotoModelo.getId());
        return clienteRepositorio.guardar(clienteModelo).get();
    }

    @Override
    public void eliminar(Long id) {
        ClienteModelo clienteModelo = obtenerPorId(id);
        if(clienteModelo != null){
            fotoServicio.eliminarPorId(clienteModelo.getIdFoto());
            clienteRepositorio.eliminar(id);
        }
    }
}
