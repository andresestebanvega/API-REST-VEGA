package com.example.producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class ProductoService {
    private ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Creo un nuevo producto
    public ProductoEntity crearPproducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    // Elimino un producto
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    // Mostrar todos los productos
    public List<ProductoEntity> mostrarProductos() {
        return productoRepository.findAll();
    }

    // Busco un producto en particular
    public Optional<ProductoEntity> buscarProducto(Long id) {
        return productoRepository.findById(id);
    }

    // Modificar los datos de un producto existente
    public ProductoEntity modificarProducto(Long id, ProductoEntity productoAModificar) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setDescripcion(productoAModificar.getDescripcion());
                    producto.setPrecio(productoAModificar.getPrecio());
                    producto.setStock(productoAModificar.getStock());

                    return productoRepository.save(producto);
                })
                .orElse(null);
    }
}
