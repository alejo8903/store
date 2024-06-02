package com.store.store.service.impl;

import com.store.store.model.Empleado;
import com.store.store.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.store.store.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();

    }
}
