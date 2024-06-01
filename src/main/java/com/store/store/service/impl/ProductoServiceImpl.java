package com.store.store.service.impl;


import com.store.store.model.Producto;
import com.store.store.repository.ProductoRepository;
import com.store.store.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto getProductoById(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProductoById(int id) {
        productoRepository.deleteById(id);
    }
}
