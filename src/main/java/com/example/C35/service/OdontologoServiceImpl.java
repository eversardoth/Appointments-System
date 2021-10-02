package com.example.C35.service;

import com.example.C35.dto.OdontologoDTO;
import com.example.C35.dto.OdontologoUpdateDTO;
import com.example.C35.entity.Odontologo;
import com.example.C35.entity.Paciente;
import com.example.C35.exception.ResourceNotFoundException;
import com.example.C35.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public Odontologo save(OdontologoDTO odontologoDTO){
        ObjectMapper mapper = new ObjectMapper();
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        return odontologoRepository.save(odontologo);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Odontologo update(OdontologoUpdateDTO odontologoUpdateDTO) {

        Long id = odontologoUpdateDTO.getId();

        ObjectMapper mapper = new ObjectMapper();
        Odontologo odontologo = mapper.convertValue(odontologoUpdateDTO, Odontologo.class);

        if(findById(id).isPresent()){
            return odontologoRepository.save(odontologo);
        }

        return new Odontologo();
    }

    @Override
    public String delete(Long id) throws ResourceNotFoundException {

        if(odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
            return "El odontologo con id: "+ id + " ha sido eliminado";
        }
        throw new ResourceNotFoundException("No existe un odontologo con el id: "+ id);
    }


}
