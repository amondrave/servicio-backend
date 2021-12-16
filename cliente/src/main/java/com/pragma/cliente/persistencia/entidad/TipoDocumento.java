package com.pragma.cliente.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tipodocumento")
public class TipoDocumento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "tido_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDocumento;

    @Column(name = "tido_nombre")
    @NotEmpty(message = "El nombre del tipo de documento no puede ser vacio")
    private String nombre;

}
