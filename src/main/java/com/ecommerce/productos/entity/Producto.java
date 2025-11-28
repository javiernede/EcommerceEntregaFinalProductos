package com.ecommerce.productos.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "producto")
@Data   // genera getters, setters, equals, hashCode y toString 💥
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private double precio;
    private int cantidadEnStock;

    // Podés agregar lógica personalizada sin problema
    public void descontarStock(int cantidad) {
        if (cantidad <= 0) throw new IllegalArgumentException("Cantidad inválida");
        if (cantidad > cantidadEnStock) throw new IllegalStateException("Stock insuficiente");
        this.cantidadEnStock -= cantidad;
    }
}
