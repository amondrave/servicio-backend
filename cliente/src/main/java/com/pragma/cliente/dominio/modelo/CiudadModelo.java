package com.pragma.cliente.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CiudadModelo {

    private Long idCiudad;

    private String nombreCiudad;

}
