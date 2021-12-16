package com.pragma.cliente.persistencia.mapeador;

import com.pragma.cliente.dominio.modelo.FotoModelo;
import com.pragma.cliente.persistencia.documento.Foto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FotoMapeador {

    FotoModelo convertirFotoModelo(Foto foto);

    @InheritInverseConfiguration
    Foto convertirFoto(FotoModelo fotoModelo);

}
