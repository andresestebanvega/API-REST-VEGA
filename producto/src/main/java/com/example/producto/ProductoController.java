package com.example.producto;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api")
public class ProductoController {
    private final ProductoRepository productoRepository;
    // Constructor para inyectar el repositorio
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @GetMapping("/mostrar")
    public List<ProductoEntity> mostrarProductos() {
        return productoRepository.findAll();
    }
    @PostMapping("/crear")
    public ProductoEntity crearPproducto(@RequestBody ProductoEntity producto) {
        return productoRepository.save(producto);
    }
    @PutMapping("/modificar/{id}")
    public ProductoEntity modificarProducto(@PathVariable Long id, @RequestBody ProductoEntity productoAModificar) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(producto.nombre);
                    producto.setDescripcion(productoAModificar.getDescripcion());
                    producto.setPrecio(productoAModificar.getPrecio());
                    producto.setStock(productoAModificar.getStock());

                    return productoRepository.save(producto);
                })
                .orElse(null);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }
}
