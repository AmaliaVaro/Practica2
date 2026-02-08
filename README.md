# Práctica 2 
En la siguiente tabla podrán encontrar una descripción de cada endpoint usado en la práctica.

| **Método** | **Ruta** | **Cuerpo** | **Descripción** | **Posible respuesta** |
|------------|----------|------------|-----------------|-----------------------|
| POST       | /api/carritos | Las propiedades de la clase carrito en formato JSON: idCarrito, idArticulo, descripcion, unidades y precioFinal | Crea un carrito con el id del artículo, la descripción, las unidades y su precio final | 201 Created Te devuelve el carrito que has creado junto a los carritos creados anteriormente |
| GET        | /api/carritos | No piden un cuerpo | Devuelve todos los carritos | 200 OK Te enseña todos los carritos que tienes |
| GET        | /api/carritos/{idCarrito} | No piden un cuerpo | Devuelve el valor del carrito indicado | 200 OK Te enseña el carrito indicado |
| PUT        | /api/carritos/{idCarrito} | Las propiedades de la clase carrito en formato JSON: idCarrito, idArticulo, descripcion, unidades y precioFinal | Actualiza el valor del carrito indicado, ya sea el id del artículo, la descripcion las unidades o el precio final | 200 OK Te devuelve el carrito con su modificación y también devuelve el resto de carritos |
| DELTE      | /api/carritos/{idCarrito} | No piden un cuerpo | Elimina el carrito indicado | 200 OK Te enseña los carritos que quedan y en caso de que no quede ninguno una lista vacía |

Además se han implementado validaciones como @NotBlank, haciendo la descripción del artículo obligatoria y @Min para no tener ningún carrito con 0 unidades. 
