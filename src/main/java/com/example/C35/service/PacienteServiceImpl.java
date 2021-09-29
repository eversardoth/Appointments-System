package com.example.C35.service;

import com.example.C35.entity.Paciente;
import com.example.C35.repository.IPacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    private IPacienteRepository pacienteRepository;

    public PacienteServiceImpl(IPacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente save(Paciente paciente) {
        if(paciente != null & findById(paciente.getId()).isEmpty()){
            return pacienteRepository.save(paciente);
        }
        return new Paciente();
    }

    @Override
    public Paciente update(Paciente paciente) {
        Long id = paciente.getId();

        if(findById(id).isPresent() & paciente.getDomicilio() != null){
            return save(paciente);
        }

        return new Paciente();
    }

    @Override
    public String delete(Long id) {
        if(pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return "El paciente con id:"+ id + " ha sido eliminado";
        }

        return "El paciente no ha sido encontrado";
    }
}
