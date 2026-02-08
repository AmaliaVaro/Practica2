package edu.comillas.icai.gitt.pat.spring.Practica2.Controlador;

import edu.comillas.icai.gitt.pat.spring.Practica2.Modelo.Carrito;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
//El controlador acepta las peticiones y utiliza el modelo para procesar los datos. Luego los pasa a la vista para generar la respuesta.
@RestController//Estamos indicando que las peticiones y respuestas deben estar en formato JSON.
public class CarritoControlador {
    private final Map<Integer, Carrito> carritos = new HashMap<>();

    @PostMapping("/api/carritos")
    @ResponseStatus(HttpStatus.CREATED)
    public Carrito creaCarrito(@Valid @RequestBody Carrito carrito) {
        carritos.put(carrito.getIdCarrito(), carrito);
        return carrito;
    }

    @GetMapping("/api/carritos")
    public Collection<Carrito> getCarritos() {
        return carritos.values();
    }

    @GetMapping("/api/carritos/{idCarrito}")
    public Carrito getCarrito(@PathVariable int idCarrito) {
        return carritos.get(idCarrito);
    }

    @PutMapping("/api/carritos/{idCarrito}")
    public Carrito modificarCarrito(@PathVariable int idCarrito, @Valid@RequestBody Carrito carrito){
        carritos.put(idCarrito, carrito);
        return carrito;
    }

    @DeleteMapping("/api/carritos/{idCarrito}")
    public void borrarCarrito(@PathVariable int idCarrito) {
        carritos.remove(idCarrito);
    }



}
