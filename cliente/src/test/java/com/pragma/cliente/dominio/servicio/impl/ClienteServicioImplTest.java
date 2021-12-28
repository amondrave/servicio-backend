package com.pragma.cliente.dominio.servicio.impl;

import com.pragma.cliente.dominio.modelo.CiudadModelo;
import com.pragma.cliente.dominio.modelo.ClienteModelo;
import com.pragma.cliente.dominio.modelo.TipoDocumentoModelo;
import com.pragma.cliente.dominio.repositorio.ClienteRepositorio;
import com.pragma.cliente.dominio.servicio.interfaces.FotoServicio;
import com.pragma.cliente.persistencia.crud.ClienteCrud;
import com.pragma.cliente.utilidades.Datos;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteServicioImplTest {

    @Mock
    FotoServicio fotoServicio;

    @Mock
    ClienteRepositorio clienteRepositorio;

    @Mock
    ClienteCrud clienteCrud;

    @InjectMocks
    ClienteServicioImpl clienteServicio;


    @BeforeEach
    public void config(){
        clienteServicio = new ClienteServicioImpl(clienteRepositorio,fotoServicio);

    }


    @Test
    void obtenerTodos() throws NotFoundException {
        Mockito.when(clienteRepositorio.obtenerTodo()).thenReturn(Datos.obtenerClientes());
        Mockito.when(fotoServicio.obtenerPorId(Mockito.any())).thenReturn(Datos.obtenerPorId());

        List<ClienteModelo> listaCliente = clienteServicio.obtenerTodos();

        assertNotNull(listaCliente);
        assertEquals(3,listaCliente.size());


    }

    @Test
    void obtenerListaClientePorEdad() throws NotFoundException {
        Mockito.when(clienteRepositorio.obtenerListaClientePorEdad(22))
                .thenReturn(Datos.obtenerClientesPorEdad());
        Mockito.when(fotoServicio.obtenerPorId(Mockito.any())).thenReturn(Datos.obtenerPorId());
        List<ClienteModelo> listaCliente = clienteServicio.obtenerListaClientePorEdad(22);

        assertNotNull(listaCliente);
        assertEquals(2,listaCliente.size());
        assertEquals("Angel Yesid",listaCliente.get(0).getNombre());
    }

    @Test
    void obtenerPorId() throws NotFoundException {
       Mockito.when(clienteRepositorio.obtenerClientePorId(3L)).thenReturn(Optional.ofNullable(Datos.obtenerClienteModelo()));
       Mockito.when(fotoServicio.obtenerPorId(Mockito.any())).thenReturn(Datos.obtenerPorId());

       ClienteModelo clienteModelo = clienteServicio.obtenerPorId(3L);

       assertNotNull(clienteModelo);
       assertEquals("Dariana",clienteModelo.getNombre());
       assertEquals("1005038998",clienteModelo.getNumeroDocumento());


    }

    @Test
    void guardarCliente() throws NotFoundException {
       ClienteModelo clienteModelo = ClienteModelo.builder()
               .nombre("Marcelo")
               .apellido("Gallardo")
               .edad(34)
               .ciudadModelo(CiudadModelo.builder().build())
               .numeroDocumento("10023")
               .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
               .foto("FOTO")
               .build();

       Mockito.when(clienteRepositorio.guardar(clienteModelo)).thenReturn(Optional.ofNullable(Datos.guardarCliente()));
       Mockito.when(clienteRepositorio.obtenerClientePorNumeroDocumento(Mockito.any())).thenReturn(null);
      // Mockito.when(fotoServicio.obtenerPorId(Mockito.any())).thenReturn(Datos.guardarFoto());
       Mockito.when(fotoServicio.guardar(Mockito.any())).thenReturn(Datos.guardarFoto());

       ClienteModelo clienteModelo1Return = clienteServicio.guardar(clienteModelo);

       assertEquals(4L,clienteModelo1Return.getIdCliente());
       assertEquals("Marcelo",clienteModelo1Return.getNombre());
       assertNotNull(clienteModelo1Return);

    }

    @Test
    void actualizarCliente() throws NotFoundException {
        ClienteModelo clienteModelo = ClienteModelo.builder()
                .idCliente(4L)
                .nombre("Marcelo")
                .apellido("Gallardo")
                .edad(34)
                .ciudadModelo(CiudadModelo.builder().build())
                .numeroDocumento("10023")
                .tipoDocumentoModelo(TipoDocumentoModelo.builder().build())
                .foto("FOTO")
                .build();

        Mockito.when(clienteRepositorio.obtenerClientePorId(4L)).thenReturn(Optional.ofNullable(Datos.obtenerClientePorId()));
        Mockito.when(fotoServicio.guardar(Mockito.any())).thenReturn(Datos.guardarFoto());
        Mockito.when(clienteRepositorio.guardar(clienteModelo)).thenReturn(Optional.ofNullable(Datos.guardarCliente()));
        Mockito.when(fotoServicio.obtenerPorId(Mockito.any())).thenReturn(Datos.obtenerPorId());

        ClienteModelo clienteModelo1Return = clienteServicio.actualizar(clienteModelo);

        assertEquals(4L,clienteModelo1Return.getIdCliente());
        assertEquals("Marcelo",clienteModelo1Return.getNombre());
        assertEquals("FOTO", clienteModelo1Return.getFoto());
        assertNotNull(clienteModelo1Return);

    }



}