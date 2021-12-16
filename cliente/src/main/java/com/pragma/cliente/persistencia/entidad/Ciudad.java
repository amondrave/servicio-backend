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
@Table(name = "ciudad")
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ciu_id")
    private Long idCiudad;

    @Column(name = "ciu_nombre", length = 100)
    @NotEmpty(message = "El nombre de la ciudad no puede ser vacio")
    private String nombreCiudad;
}
