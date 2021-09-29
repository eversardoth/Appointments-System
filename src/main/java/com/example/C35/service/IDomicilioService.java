package com.example.C35.service;

import com.example.C35.entity.Domicilio;

import java.util.List;
import java.util.Optional;

public interface IDomicilioService {

    List<Domicilio> findAll();

    Optional<Domicilio> findById(Long id);

    Domicilio save(Domicilio domicilio);

    Domicilio update(Domicilio domicilio);

    String delete(Long id);
}
