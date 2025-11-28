package com.ecommerce.productos.mapper;


import com.ecommerce.productos.dto.*;
import com.ecommerce.productos.entity.Producto;

public class ProductoMapper {

    public static ProductoDTO toDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setCantidadEnStock(producto.getCantidadEnStock());
        return dto;
    }

    public static Producto toEntity(ProductoCreateDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setCantidadEnStock(dto.getCantidadEnStock());
        return producto;
    }

    public static void updateEntityFromDTO(ProductoUpdateDTO dto, Producto producto) {
        if (dto.getNombre() != null) producto.setNombre(dto.getNombre());
        if (dto.getPrecio() != null) producto.setPrecio(dto.getPrecio());
        if (dto.getCantidadEnStock() != null) producto.setCantidadEnStock(dto.getCantidadEnStock());
    }
}

