package com.pragma.cliente.persistencia.mapeador;


import com.pragma.cliente.dominio.modelo.ClienteModelo;
import com.pragma.cliente.persistencia.entidad.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CiudadMapeador.class, TipoDocumentoMapeador.class})
public interface ClienteMapeador {

    @Mappings({
            @Mapping(source = "cliente.ciudad", target = "ciudadModelo"),
            @Mapping(source = "cliente.tipoDocumento", target = "tipoDocumentoModelo")
    })
    ClienteModelo convertirClienteModelo(Cliente cliente);

    List<ClienteModelo> convertirListaClienteModelo(List<Cliente> listaCliente);

    @InheritInverseConfiguration
    Cliente convertirCliente(ClienteModelo clienteModelo);

}
