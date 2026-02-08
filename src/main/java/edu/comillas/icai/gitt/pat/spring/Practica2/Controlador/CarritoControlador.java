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

    @PostMapping("/api/carritos") //Crea un carrito
    @ResponseStatus(HttpStatus.CREATED) //Si se ha creado correctamente devuelve un 201
    public Carrito creaCarrito(@Valid @RequestBody Carrito carrito) { //El requestbody permite convertir el JSON en un objeto de java.
        carritos.put(carrito.getIdCarrito(), carrito); //añadimos el carrito creado al HashMap
        return carrito;
    }

    @GetMapping("/api/carritos")//Quiero que devuelva todos los carritos que hay
    public Collection<Carrito> getCarritos() {
        return carritos.values();
    }

    @GetMapping("/api/carritos/{idCarrito}") //Quiero que me devuelva un carrito determinado
    public Carrito getCarrito(@PathVariable int idCarrito) {//PathVariable nos permite extraer de la URL el idCarrito para poder devolver el indicado.
        return carritos.get(idCarrito);
    }

    @PutMapping("/api/carritos/{idCarrito}")//Para modificar algo del carrito, update
    public Carrito modificarCarrito(@PathVariable int idCarrito, @Valid@RequestBody Carrito carrito){
        carritos.put(idCarrito, carrito);
        return carrito;
    }

    @DeleteMapping("/api/carritos/{idCarrito}") //Para eliminar un carrito
    public void borrarCarrito(@PathVariable int idCarrito) {
        carritos.remove(idCarrito);
    }



}
