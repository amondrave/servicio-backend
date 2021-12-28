package com.pragma.cliente.dominio.servicio.impl;

import com.pragma.cliente.dominio.modelo.ClienteModelo;
import com.pragma.cliente.dominio.modelo.FotoModelo;
import com.pragma.cliente.dominio.repositorio.ClienteRepositorio;
import com.pragma.cliente.dominio.servicio.interfaces.ClienteServicio;
import com.pragma.cliente.dominio.servicio.interfaces.FotoServicio;
import com.pragma.cliente.dominio.utilidades.error.ErrorMensaje;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private FotoServicio fotoServicio;

    @Override
    public List<ClienteModelo> obtenerTodos() throws NotFoundException{
        List<ClienteModelo> listaClienteModeloRetorno = clienteRepositorio.obtenerTodo();
        listaClienteModeloRetorno.forEach(clienteModelo -> {
            FotoModelo fotoModelo =  fotoServicio.obtenerPorId(clienteModelo.getIdFoto());
            clienteModelo.setFoto(fotoModelo.getFoto());
        });
        return listaClienteModeloRetorno;
    }

    @Override
    public List<ClienteModelo> obtenerListaClientePorEdad(Integer edad) throws NotFoundException{
        List<ClienteModelo> listaClienteModeloRetorno = clienteRepositorio.obtenerListaClientePorEdad(edad);
        if(listaClienteModeloRetorno == null || listaClienteModeloRetorno.size() < 1){
            throw new IllegalArgumentException(ErrorMensaje.sinClientePorEdad(edad));
        }
        listaClienteModeloRetorno.forEach(clienteModelo -> {
            FotoModelo fotoModelo =  fotoServicio.obtenerPorId(clienteModelo.getIdFoto());
            clienteModelo.setFoto(fotoModelo.getFoto());
        });
        return listaClienteModeloRetorno;
    }

    @Override
    public ClienteModelo obtenerPorId(Long id) throws NotFoundException {
        Optional<ClienteModelo> clienteOptional = clienteRepositorio.obtenerClientePorId(id);
        if(clienteOptional != null){
            ClienteModelo clienteModelo = clienteOptional.get();
            FotoModelo fotoModelo = fotoServicio.obtenerPorId(clienteModelo.getIdFoto());
            clienteModelo.setFoto(fotoModelo.getFoto());
            return clienteModelo;
        }else{
            throw new NotFoundException(ErrorMensaje.clienteNoRegistrado(id.intValue()));
        }
    }

    @Override
    public ClienteModelo obtenerPorNumeroDocumento(String numeroDocumento) throws NotFoundException {
        Optional<ClienteModelo> clienteOptional = clienteRepositorio.obtenerClientePorNumeroDocumento(numeroDocumento);
        if(clienteOptional != null){
            ClienteModelo clienteModelo = clienteOptional.get();
            FotoModelo fotoModelo = fotoServicio.obtenerPorId(clienteModelo.getIdFoto());
            clienteModelo.setFoto(fotoModelo.getFoto());
            return clienteModelo;
        }
        return null;
    }

    @Override
    @Transactional
    public ClienteModelo guardar(ClienteModelo clienteModelo) throws NotFoundException {
        if(obtenerPorNumeroDocumento(clienteModelo.getNumeroDocumento())!=null){
            throw new IllegalArgumentException(ErrorMensaje.numeroDocumentoRegsitrado(
                    clienteModelo.getNumeroDocumento()
                    )
            );
        }
        FotoModelo fotoModelo = FotoModelo.builder()
                .foto(clienteModelo.getFoto())
                .build();
        fotoModelo = fotoServicio.guardar(fotoModelo);
        clienteModelo.setIdFoto(fotoModelo.getId());
        return clienteRepositorio.guardar(clienteModelo).get();
    }

    @Override
    @Transactional
    public ClienteModelo actualizar(ClienteModelo clienteModelo) throws NotFoundException {
        ClienteModelo clienteModeloAuxiliar = obtenerPorId(clienteModelo.getIdCliente());
        if(clienteModeloAuxiliar == null)  {
            throw new NotFoundException(ErrorMensaje.clienteNoRegistrado(clienteModelo.getIdCliente().intValue()));
        }
        FotoModelo fotoModelo = FotoModelo.builder()
                .id(clienteModelo.getIdFoto())
                .foto(clienteModelo.getFoto())
                .build();
        fotoModelo = fotoServicio.guardar(fotoModelo);
        clienteModelo.setIdFoto(fotoModelo.getId());
        return clienteRepositorio.guardar(clienteModelo).get();
    }

    @Override
    @Transactional
    public void eliminar(Long id) throws NotFoundException{
        ClienteModelo clienteModelo = obtenerPorId(id);
        if(clienteModelo != null){
            fotoServicio.eliminarPorId(clienteModelo.getIdFoto());
            clienteRepositorio.eliminar(id);
        }else{
            throw new NotFoundException(ErrorMensaje.clienteNoRegistrado(
                    id.intValue()
            )
            );
        }
    }
}
