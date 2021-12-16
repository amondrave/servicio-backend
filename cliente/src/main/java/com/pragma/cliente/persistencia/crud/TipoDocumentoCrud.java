package com.pragma.cliente.persistencia.crud;

import com.pragma.cliente.persistencia.entidad.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoCrud extends JpaRepository<TipoDocumento,Long> {
}
