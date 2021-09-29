package com.example.C35.service;

import com.example.C35.entity.Paciente;
import com.example.C35.entity.Turno;
import com.example.C35.repository.ITurnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements ITurnoService{

    private ITurnoRepository turnoRepository;

    public TurnoServiceImpl(ITurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
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
    public Turno save(Turno turno) {
        if(turno != null){
            turnoRepository.save(turno);
        }
        return new Turno();
    }

    @Override
    public Turno update(Turno turno) {
        Long id = turno.getId();

        if(turnoRepository.findById(id).isPresent() & turno.getOdontologo() != null & turno.getPaciente()!=null){
            delete(id);
            return save(turno);
        }

        return new Turno();
    }

    @Override
    public String delete(Long id) {
        if(turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
            return "El turno con id:"+ id + " ha sido eliminado";
        }

        return "El turno no ha sido encontrado";
    }
}
