package com.store.store.repository;

import com.store.store.model.TipoFlor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFlorRepository extends JpaRepository<TipoFlor, Integer> {

}