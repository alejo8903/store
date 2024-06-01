package com.store.store.service;

<<<<<<< HEAD
import com.store.store.entity.Producto;
=======


import com.store.store.model.Producto;
>>>>>>> 7e366f98e3e5a4b079156422034c0f51a930b7cc

import java.util.List;

public interface ProductoService {
    List<Producto> getAllProductos();
    Producto saveProducto(Producto producto);
    Producto getProductoById(int id);
    void deleteProductoById(int id);
}