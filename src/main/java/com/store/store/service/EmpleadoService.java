package com.store.store.service;

import com.store.store.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmpleadoService {
    List<Empleado> findAll();
}
