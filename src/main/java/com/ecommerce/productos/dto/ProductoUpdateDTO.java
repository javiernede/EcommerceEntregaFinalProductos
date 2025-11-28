package com.ecommerce.productos.dto;



import lombok.Data;

@Data
public class ProductoUpdateDTO {
    private String nombre;
    private Double precio;
    private Integer cantidadEnStock;
}
