package com.pragma.cliente.dominio.repositorio;

import com.pragma.cliente.persistencia.mapeador.TipoDocumentoMapeador;
import com.pragma.cliente.dominio.modelo.TipoDocumentoModelo;
import com.pragma.cliente.persistencia.crud.TipoDocumentoCrud;
import com.pragma.cliente.persistencia.entidad.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TipoDocumentoRepositorio {

    @Autowired
    private TipoDocumentoCrud tipoDocumentoCrud;

    @Autowired
    private TipoDocumentoMapeador tipoDocumentoMapeador;

    public Optional<TipoDocumentoModelo> obtenerTipoDocumentoPorId(Long id){
        Optional<TipoDocumento> tipoDocumento = tipoDocumentoCrud.findById(id);
        return Optional.of(tipoDocumentoMapeador.convertirTipoDocumentoModelo(tipoDocumento.get()));
    }




}
