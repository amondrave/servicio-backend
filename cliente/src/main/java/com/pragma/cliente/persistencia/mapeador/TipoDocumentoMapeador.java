package com.pragma.cliente.persistencia.mapeador;

import com.pragma.cliente.dominio.modelo.TipoDocumentoModelo;
import com.pragma.cliente.persistencia.entidad.TipoDocumento;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoDocumentoMapeador {

    TipoDocumentoModelo convertirTipoDocumentoModelo(TipoDocumento tipoDocumento);

    List<TipoDocumentoModelo> convertirListaTipoDocumento(List<TipoDocumento> listaTipoDocumento);

    @InheritInverseConfiguration
    TipoDocumento convertirTipoDocumento (TipoDocumentoModelo tipoDocumentoModelo);

}
