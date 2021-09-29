package com.example.C35.controller;

import com.example.C35.entity.Paciente;
import com.example.C35.service.IPacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    private IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/save")
    public Paciente save(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);

    }

    @GetMapping
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return pacienteService.delete(id);
    }

    @PutMapping("/update")
    public Paciente update(@RequestBody Paciente paciente){
        return pacienteService.update(paciente);
    }

    @GetMapping("/{id}")
    public Optional<Paciente> find(@PathVariable Long id){
        return pacienteService.findById(id);
    }

}
