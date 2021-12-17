package com.pragma.cliente.dominio.repositorio;

import com.pragma.cliente.persistencia.entidad.Cliente;
import com.pragma.cliente.persistencia.mapeador.ClienteMapeador;
import com.pragma.cliente.dominio.modelo.ClienteModelo;
import com.pragma.cliente.persistencia.crud.ClienteCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositorio {

    @Autowired
    private ClienteCrud clienteCrud;

    @Autowired
    private ClienteMapeador clienteMapeador;


    public List<ClienteModelo> obtenerTodo(){
        List<Cliente> listaClienteRetorno = clienteCrud.findAll();
        return  clienteMapeador.convertirListaClienteModelo(listaClienteRetorno);
    }

    public List<ClienteModelo> obtenerListaClientePorEdad(Integer edad){
        List<Cliente> listaClienteRetorno = clienteCrud.findByEdadGreaterThanEqual(edad).get();
        return clienteMapeador.convertirListaClienteModelo(listaClienteRetorno);
    }

    public Optional<ClienteModelo> obtenerClientePorId(Long id){
        Optional<Cliente> cliente = clienteCrud.findById(id);
        return Optional.of(clienteMapeador.convertirClienteModelo(cliente.get()));
    }

    public Optional<ClienteModelo> guardar(ClienteModelo clienteModelo){
        Cliente cliente = clienteMapeador.convertirCliente(clienteModelo);
        return Optional.of(clienteMapeador.convertirClienteModelo(clienteCrud.save(cliente)));
    }

    public void eliminar(Long id){
        clienteCrud.deleteById(id);
    }



}
