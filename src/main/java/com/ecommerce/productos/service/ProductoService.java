package com.ecommerce.productos.service;

import com.ecommerce.productos.dto.*;
import java.util.List;

public interface ProductoService {

    List<ProductoDTO> listar();

    ProductoDTO obtenerPorId(Long id);

    ProductoDTO crear(ProductoCreateDTO dto);

    ProductoDTO actualizar(Long id, ProductoUpdateDTO dto);

    void eliminar(Long id);
}
