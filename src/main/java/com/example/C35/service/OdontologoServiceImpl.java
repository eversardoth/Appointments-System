package com.example.C35.service;

import com.example.C35.entity.Odontologo;
import com.example.C35.entity.Paciente;
import com.example.C35.repository.IOdontologoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements IOdontologoService {

    private IOdontologoRepository odontologoRepository;

    public OdontologoServiceImpl(IOdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public List<Odontologo> findAll() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> findById(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Odontologo save(Odontologo odontologo) {
        if(odontologo != null & findById(odontologo.getId()).isEmpty()){
            return odontologoRepository.save(odontologo);
        }
        return new Odontologo();
    }

    @Override
    public Odontologo update(Odontologo odontologo) {

        Long id = odontologo.getId();

        if(findById(id).isPresent()){
            return save(odontologo);
        }

        return new Odontologo();
    }

    @Override
    public String delete(Long id) {

        if(odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
            return "El odontologo con id:"+ id + " ha sido eliminado";
        }

        return "El odontologo no ha sido encontrado";
    }


}
