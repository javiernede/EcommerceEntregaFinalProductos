package com.ecommerce.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.productos.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}