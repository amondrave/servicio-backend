package com.pragma.cliente.persistencia.crud;

import com.pragma.cliente.persistencia.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrud extends JpaRepository<Cliente,Long> {
    Optional<List<Cliente>> findByEdadGreaterThanEqual(Integer age);

    Optional<Cliente> findByNumeroDocumento(String numeroDocumento);
}
