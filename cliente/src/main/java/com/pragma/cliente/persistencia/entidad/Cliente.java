package com.pragma.cliente.persistencia.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "clie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(name = "clie_nombre")
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;

    @Column(name = "clie_apellido")
    @NotEmpty(message = "El apellido no puede estar vacio")
    private String apellido;

    @Column(name = "clie_edad")
    @NotNull(message = "La edad no puede se nula")
    @Positive(message = "La edad debe ser mayor a cero")
    private Integer edad;

    @Column(name = "clie_numerodocumento", unique = true)
    @NotEmpty(message = "El numero de documento no puede ser vacio")
    private String numeroDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tido_id", referencedColumnName = "tido_id", nullable = false)
    private TipoDocumento tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ciu_id", referencedColumnName = "ciu_id")
    private Ciudad ciudad;

    @Column(name = "clie_idfoto", length = 5000)
    private String idFoto;



}
