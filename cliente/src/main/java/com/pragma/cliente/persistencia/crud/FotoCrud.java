package com.pragma.cliente.persistencia.crud;

import com.pragma.cliente.persistencia.documento.Foto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FotoCrud extends MongoRepository<Foto,String> {
}
