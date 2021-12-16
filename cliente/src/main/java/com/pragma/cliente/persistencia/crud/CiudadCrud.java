package com.pragma.cliente.persistencia.crud;

import com.pragma.cliente.persistencia.entidad.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadCrud extends JpaRepository<Ciudad,Long> {
}
