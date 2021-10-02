package com.example.C35.service;


import com.example.C35.dto.TurnoDTO;
import com.example.C35.dto.TurnoUpdateDTO;
import com.example.C35.entity.Turno;
import com.example.C35.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {

    List<Turno> findAll();

    Optional<Turno> findById(Long id);

    Turno save(TurnoDTO turnoDTO);

    Turno update(TurnoUpdateDTO turnoUpdateDTO);

    String delete(Long id) throws ResourceNotFoundException;
}
