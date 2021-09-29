package com.example.C35.service;

import com.example.C35.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    List<Paciente> findAll();

    Optional<Paciente> findById(Long id);

    Paciente save(Paciente paciente);

    Paciente update(Paciente paciente);

    String delete(Long id);
}
