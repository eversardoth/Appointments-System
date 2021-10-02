package com.example.C35.service;

import com.example.C35.dto.PacienteDTO;
import com.example.C35.dto.PacienteUpdateDTO;
import com.example.C35.entity.Paciente;
import com.example.C35.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    List<Paciente> findAll();

    Optional<Paciente> findById(Long id);

    Paciente save(PacienteDTO pacienteDTO);

    Paciente update(PacienteUpdateDTO pacienteUpdateDTO);

    String delete(Long id) throws ResourceNotFoundException;
}
