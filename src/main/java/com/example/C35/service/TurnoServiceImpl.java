package com.example.C35.service;

import com.example.C35.dto.TurnoDTO;
import com.example.C35.dto.TurnoUpdateDTO;
import com.example.C35.entity.Odontologo;
import com.example.C35.entity.Paciente;
import com.example.C35.entity.Turno;
import com.example.C35.exception.ResourceNotFoundException;
import com.example.C35.repository.ITurnoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements ITurnoService{

    private ITurnoRepository turnoRepository;
    private IPacienteService pacienteService;
    private IOdontologoService odontologoService;

    public TurnoServiceImpl(ITurnoRepository turnoRepository, IPacienteService pacienteService, IOdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @Override
    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }

    @Override
    public Optional<Turno> findById(Long id) {
        return  turnoRepository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Turno save(TurnoDTO turnoDTO) {

        Long odontologoId = turnoDTO.getOdontologoId();
        Long pacienteId = turnoDTO.getPacienteId();

        Odontologo odontologo = odontologoService.findById(odontologoId).get();

        Paciente paciente = pacienteService.findById(pacienteId).get();

        Turno turno = new Turno();

        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        turno.setDate(turnoDTO.getDate());

        return turnoRepository.save(turno);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Turno update(TurnoUpdateDTO turnoUpdateDTO) {
        Long id = turnoUpdateDTO.getId();
        Long odontologoId = turnoUpdateDTO.getOdontologoId();
        Long pacienteId = turnoUpdateDTO.getPacienteId();
        Turno turno = turnoRepository.findById(id).get();
        Odontologo odontologo = odontologoService.findById(odontologoId).get();
        Paciente paciente = pacienteService.findById(pacienteId).get();

        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        turno.setDate(turnoUpdateDTO.getDate());

        return turnoRepository.save(turno);
    }

    @Override
    public String delete(Long id) throws ResourceNotFoundException {
        if(turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
            return "El turno con id: "+ id + " ha sido eliminado";
        }

        throw new ResourceNotFoundException("No existe un turno con el id: "+ id);
    }
}
