package com.example.C35.service;


import com.example.C35.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    List<Odontologo> findAll();

    Optional<Odontologo> findById(Long id);

    Odontologo save(Odontologo odontologo);

    Odontologo update(Odontologo odontologo);

    String delete(Long id);
}
