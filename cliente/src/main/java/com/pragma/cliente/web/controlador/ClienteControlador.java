package com.pragma.cliente.web.controlador;


import com.google.gson.Gson;
import com.pragma.cliente.dominio.modelo.ClienteModelo;
import com.pragma.cliente.dominio.servicio.interfaces.ClienteServicio;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteControlador {

    private final Logger log = LoggerFactory.getLogger(ClienteControlador.class);
    private static  final Gson gson = new Gson();


    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<ClienteModelo>> obtenerTodo(){
        List<ClienteModelo> listaClienteModelo = null;
        try{
            listaClienteModelo = clienteServicio.obtenerTodos();
            return new ResponseEntity<>(listaClienteModelo, HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscarPorEdad/{edad}")
    @ResponseBody
    public ResponseEntity<List<ClienteModelo>> obtenerPorEdad(@PathVariable Integer edad) throws NotFoundException{
        List<ClienteModelo> listaClienteModelo = null;
        listaClienteModelo = clienteServicio.obtenerListaClientePorEdad(edad);
        return new ResponseEntity<>(listaClienteModelo, HttpStatus.OK);

    }

    @GetMapping("{idCliente}")
    public ResponseEntity<ClienteModelo> obtenerClienteModeloPorId(@PathVariable Long idCliente) throws NotFoundException {
        ClienteModelo clienteModelo = null;
        clienteModelo = clienteServicio.obtenerPorId(idCliente);
        return new ResponseEntity<>(clienteModelo, HttpStatus.OK);

    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<ClienteModelo> guardarCliente(@RequestBody ClienteModelo clienteModelo) throws NotFoundException {
        clienteServicio.guardar(clienteModelo);
        return new ResponseEntity<>(clienteModelo,HttpStatus.CREATED);
    }

    @PutMapping()
    @ResponseBody
    public ResponseEntity<ClienteModelo> actualizarCliente(@RequestBody ClienteModelo clienteModelo) throws NotFoundException {
        clienteServicio.actualizar(clienteModelo);
        return new ResponseEntity<>(clienteModelo,HttpStatus.CREATED);
    }

    @DeleteMapping("{idCliente}")
    public ResponseEntity<ClienteModelo> eliminarClientePorId(@PathVariable Long idCliente) throws NotFoundException {
        clienteServicio.eliminar(idCliente.longValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
