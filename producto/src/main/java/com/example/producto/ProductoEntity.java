package com.example.producto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    public long id;
    public String nombre;
    public String descripcion;
    public double precio;
    public int stock;
}
