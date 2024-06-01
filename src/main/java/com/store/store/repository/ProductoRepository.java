package com.store.store.repository;

<<<<<<< HEAD
import com.store.store.entity.Producto;
=======

import com.store.store.model.Producto;
>>>>>>> 7e366f98e3e5a4b079156422034c0f51a930b7cc
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}