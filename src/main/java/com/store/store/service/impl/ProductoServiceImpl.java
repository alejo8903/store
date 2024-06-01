package com.store.store.service.impl;

<<<<<<< HEAD
import com.store.store.entity.Producto;
=======

import com.store.store.model.Producto;
>>>>>>> 7e366f98e3e5a4b079156422034c0f51a930b7cc
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
