package com.example.C35.service;


import com.example.C35.entity.Turno;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {

    List<Turno> findAll();

    Optional<Turno> findById(Long id);

    Turno save(Turno turno);

    Turno update(Turno turno);

    String delete(Long id);
}
