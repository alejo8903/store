package com.store.store.service.impl;

import com.store.store.model.TipoFlor;
import com.store.store.repository.TipoFlorRepository;
import com.store.store.service.TipoFlorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoFlorServiceImpl implements TipoFlorService {

    @Autowired
    private TipoFlorRepository tipoFlorRepository;

    @Override
    public List<TipoFlor> getAllTipoFlor() {
        return tipoFlorRepository.findAll();
    }
}