package com.example.C35.controller;


import com.example.C35.entity.Odontologo;
import com.example.C35.service.IOdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/save")
    public Odontologo save(@RequestBody Odontologo odontologo){
        return odontologoService.save(odontologo);
    }

    @GetMapping
    public List<Odontologo> findAll(){
        return odontologoService.findAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return odontologoService.delete(id);
    }

    @PutMapping("/update")
    public Odontologo update(@RequestBody Odontologo odontologo){
        return odontologoService.update(odontologo);
    }

    @GetMapping("/{id}")
    public Optional<Odontologo> find(@PathVariable Long id){
        return odontologoService.findById(id);
    }




}
