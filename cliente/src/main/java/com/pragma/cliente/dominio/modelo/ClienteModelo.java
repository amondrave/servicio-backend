package com.pragma.cliente.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteModelo {


    private Long idCliente;

    private String nombre;

    private String apellido;

    private Integer edad;

    private CiudadModelo ciudadModelo;

    private TipoDocumentoModelo tipoDocumentoModelo;

    private String idFoto;

    // Atributo para la proyeccion

    private String foto;


}
