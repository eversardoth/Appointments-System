package com.example.C35.controller;


import com.example.C35.dto.OdontologoDTO;
import com.example.C35.dto.OdontologoUpdateDTO;
import com.example.C35.entity.Odontologo;
import com.example.C35.exception.ResourceNotFoundException;
import com.example.C35.service.IOdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin(origins="*")
public class OdontologoController {

    private IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/save")
    public Odontologo save(@RequestBody OdontologoDTO odontologoDTO){
        return odontologoService.save(odontologoDTO);
    }

    @GetMapping
    public List<Odontologo> findAll(){
        return odontologoService.findAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        return odontologoService.delete(id);
    }

    @PutMapping("/update")
    public Odontologo update(@RequestBody OdontologoUpdateDTO odontologoUpdateDTO){
        return odontologoService.update(odontologoUpdateDTO);
    }

    @GetMapping("/{id}")
    public Optional<Odontologo> find(@PathVariable Long id){
        return odontologoService.findById(id);
    }




}
