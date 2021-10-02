package com.example.C35.service;

import com.example.C35.dto.PacienteDTO;
import com.example.C35.dto.PacienteUpdateDTO;
import com.example.C35.entity.Domicilio;
import com.example.C35.entity.Paciente;
import com.example.C35.exception.ResourceNotFoundException;
import com.example.C35.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public Paciente save(PacienteDTO pacienteDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        return pacienteRepository.save(paciente);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Paciente update(PacienteUpdateDTO pacienteUpdateDTO) {
        Long id = pacienteUpdateDTO.getId();

        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = mapper.convertValue(pacienteUpdateDTO, Paciente.class);

        Domicilio domicilio = paciente.getDomicilio();
        domicilio.setId(pacienteRepository.findById(id).get().getDomicilio().getId());
        paciente.setDomicilio(domicilio);

        if(findById(id).isPresent() & pacienteUpdateDTO.getDomicilio() != null){
            return pacienteRepository.save(paciente);
        }

        return new Paciente();
    }

    @Override
    public String delete(Long id) throws ResourceNotFoundException{
        if(pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return "El paciente con id: "+ id + " ha sido eliminado";
        }

        throw new ResourceNotFoundException("No existe un paciente con el id: "+ id);
    }
}
