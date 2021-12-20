package com.pragma.cliente.dominio.utilidades.error;

public class ErrorMensaje {

    private static final String CLIENTE_NO_REGISTRADO = "El cliente con id: %d no esta registrado";

    private static final String SIN_CLIENTE_POR_EDAD = "No existen clientes con edad mayor igual a %d";

    private static  final String NUMERO_DOCUMENTO_REGISTRADO = "Ya existe el numero de documento %s en el sistema";


    public static String clienteNoRegistrado(Integer idCliente){
        return String.format(CLIENTE_NO_REGISTRADO,idCliente);
    }

    public static  String sinClientePorEdad(Integer edad){
        return String.format(SIN_CLIENTE_POR_EDAD,edad);
    }

    public static String numeroDocumentoRegsitrado(String numeroDocumento){
        return String.format(NUMERO_DOCUMENTO_REGISTRADO,numeroDocumento);
    }
}
