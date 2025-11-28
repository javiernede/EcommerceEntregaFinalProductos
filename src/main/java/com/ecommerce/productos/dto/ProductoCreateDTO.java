package com.ecommerce.productos.dto;


import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Data
public class ProductoCreateDTO {

    @NotBlank
    private String nombre;

    @Min(1)
    private double precio;

    @Min(0)
    private int cantidadEnStock;
}
