package com.example.C35.service;


import com.example.C35.dto.OdontologoDTO;
import com.example.C35.dto.OdontologoUpdateDTO;
import com.example.C35.entity.Odontologo;
import com.example.C35.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    List<Odontologo> findAll();

    Optional<Odontologo> findById(Long id);
    Odontologo save(OdontologoDTO odontologoDTO);

    Odontologo update(OdontologoUpdateDTO odontologoUpdateDTO);

    String delete(Long id) throws ResourceNotFoundException;
}
