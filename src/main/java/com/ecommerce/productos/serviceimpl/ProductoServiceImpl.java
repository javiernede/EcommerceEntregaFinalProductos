package com.ecommerce.productos.serviceimpl;

import com.ecommerce.productos.dto.*;
import com.ecommerce.productos.entity.Producto;
import com.ecommerce.productos.exception.ProductoNotFoundException;
import com.ecommerce.productos.mapper.ProductoMapper;
import com.ecommerce.productos.repository.ProductoRepository;
import com.ecommerce.productos.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listar() {
        return productoRepository.findAll()
                .stream()
                .map(ProductoMapper::toDTO)
                .toList();
    }

    @Override
    public ProductoDTO obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
        return ProductoMapper.toDTO(producto);
    }

    @Override
    public ProductoDTO crear(ProductoCreateDTO dto) {
        Producto producto = ProductoMapper.toEntity(dto);
        productoRepository.save(producto);
        return ProductoMapper.toDTO(producto);
    }

    @Override
    public ProductoDTO actualizar(Long id, ProductoUpdateDTO dto) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));

        ProductoMapper.updateEntityFromDTO(dto, producto);

        productoRepository.save(producto);

        return ProductoMapper.toDTO(producto);
    }

    @Override
    public void eliminar(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ProductoNotFoundException(id);
        }
        productoRepository.deleteById(id);
    }
}

