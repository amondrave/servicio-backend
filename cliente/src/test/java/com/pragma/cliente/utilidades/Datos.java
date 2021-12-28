package com.pragma.cliente.utilidades;

import com.pragma.cliente.dominio.modelo.CiudadModelo;
import com.pragma.cliente.dominio.modelo.ClienteModelo;
import com.pragma.cliente.dominio.modelo.FotoModelo;
import com.pragma.cliente.dominio.modelo.TipoDocumentoModelo;

import java.util.Arrays;
import java.util.List;

public class Datos {

    public static List<ClienteModelo> obtenerClientes(){
       ClienteModelo clienteModelo1 = ClienteModelo.builder()
               .idCliente(1L)
               .nombre("Angel Yesid")
               .apellido("Mondragon")
               .numeroDocumento("1005038967")
               .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
               .ciudadModelo(CiudadModelo.builder().build())
               .idFoto("1234")
               .foto("FOTO")
               .edad(22)
               .build();

       ClienteModelo clienteModelo2 = ClienteModelo.builder()
               .idCliente(2L)
               .nombre("Nestor Adrian")
               .apellido("Mondragon")
               .numeroDocumento("1005038958")
               .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
               .ciudadModelo(CiudadModelo.builder().build())
               .idFoto("1234")
               .foto("FOTO-Link")
               .edad(18)
               .build();

       ClienteModelo clienteModelo3 =  ClienteModelo.builder()
               .idCliente(3L)
               .nombre("Dariana")
               .apellido("Rico")
               .numeroDocumento("1005038998")
               .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
               .ciudadModelo(CiudadModelo.builder().build())
               .idFoto("1234")
               .foto("FOTO")
               .edad(23)
               .build();

        return Arrays.asList(clienteModelo1,clienteModelo2, clienteModelo3);
    }


    public static List<FotoModelo> obtenerFoto() {
        FotoModelo fotoModelo1 = FotoModelo.builder()
                .id("1234")
                .foto("FOTO")
                .build();
        FotoModelo fotoModelo2 = FotoModelo.builder()
                .id("1234")
                .foto("FOTO-Link")
                .build();
        FotoModelo fotoModelo3 = FotoModelo.builder()
                .id("1234")
                .foto("FOTO")
                .build();
        return Arrays.asList(fotoModelo1,fotoModelo2,fotoModelo3);
    }


    public static ClienteModelo obtenerClienteModelo(){
        return   ClienteModelo.builder()
                .nombre("Dariana")
                .apellido("Rico")
                .numeroDocumento("1005038998")
                .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
                .ciudadModelo(CiudadModelo.builder().build())
                .foto("FOTO")
                .edad(23)
                .build();
    }


    public static FotoModelo obtenerPorId(){
        return FotoModelo.builder()
                .id("1234")
                .foto("foto")
                .build();
    }

    public static FotoModelo guardarFoto(){
        return FotoModelo.builder()
                .id("1234")
                .foto("FOTO")
                .build();
    }


    public static List<ClienteModelo> obtenerClientesPorEdad(){
        ClienteModelo clienteModelo1 = ClienteModelo.builder()
                .idCliente(1L)
                .nombre("Angel Yesid")
                .apellido("Mondragon")
                .numeroDocumento("1005038967")
                .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
                .ciudadModelo(CiudadModelo.builder().build())
                .idFoto("1234")
                .foto("FOTO")
                .edad(22)
                .build();

        ClienteModelo clienteModelo3 =  ClienteModelo.builder()
                .idCliente(3L)
                .nombre("Dariana")
                .apellido("Rico")
                .numeroDocumento("1005038998")
                .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
                .ciudadModelo(CiudadModelo.builder().build())
                .idFoto("1234")
                .foto("FOTO")
                .edad(23)
                .build();

        return Arrays.asList(clienteModelo1, clienteModelo3);
    }


    public static ClienteModelo guardarCliente(){
        return ClienteModelo.builder()
                .idCliente(4L)
                .nombre("Marcelo")
                .apellido("Gallardo")
                .edad(34)
                .ciudadModelo(CiudadModelo.builder().build())
                .numeroDocumento("10023")
                .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
                .idFoto("1234")
                .foto("FOTO")
                .build();
    }


    public static ClienteModelo obtenerClientePorId(){
        return ClienteModelo.builder()
                .idCliente(4L)
                .nombre("Marcelo")
                .apellido("Gallardo")
                .edad(34)
                .ciudadModelo(CiudadModelo.builder().build())
                .numeroDocumento("10023")
                .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
                .idFoto("1234")
                .foto("FOTO")
                .build();
    }



}
