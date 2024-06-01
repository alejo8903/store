package com.store.store.service;

import com.store.store.entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getAllProductos();
    Producto saveProducto(Producto producto);
    Producto getProductoById(int id);
    void deleteProductoById(int id);
}