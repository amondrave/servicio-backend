package com.pragma.cliente.dominio.repositorio;

import com.pragma.cliente.dominio.modelo.FotoModelo;
import com.pragma.cliente.persistencia.crud.FotoCrud;
import com.pragma.cliente.persistencia.documento.Foto;
import com.pragma.cliente.persistencia.mapeador.FotoMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public class FotoRepositorio {

    @Autowired
    private FotoCrud fotoCrud;

    @Autowired
    private FotoMapeador fotoMapeador;

    public Optional<FotoModelo> obtenerFotoPorId(String id){
        Optional<Foto> foto = fotoCrud.findById(id);
        return Optional.of(fotoMapeador.convertirFotoModelo(foto.get()));
    }

    public Optional<FotoModelo> guardar(FotoModelo fotoModelo){
        Foto foto = fotoMapeador.convertirFoto(fotoModelo);
        return Optional.of(fotoMapeador.convertirFotoModelo(fotoCrud.save(foto)));
    }

    public void eliminarPorId(String id){
        fotoCrud.deleteById(id);
    }

    public void eliminar(FotoModelo fotoModelo){
        Foto foto = fotoMapeador.convertirFoto(fotoModelo);
        fotoCrud.delete(foto);
    }


}
