package com.pragma.cliente.persistencia.documento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "foto")
public class Foto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field
    private String foto;

}
