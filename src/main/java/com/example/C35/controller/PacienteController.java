package com.example.C35.controller;

import com.example.C35.dto.PacienteDTO;
import com.example.C35.dto.PacienteUpdateDTO;
import com.example.C35.entity.Paciente;
import com.example.C35.exception.ResourceNotFoundException;
import com.example.C35.service.IPacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins="*")
public class PacienteController {


    private IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/save")
    public Paciente save(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.save(pacienteDTO);

    }

    @GetMapping
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        return pacienteService.delete(id);
    }

    @PutMapping("/update")
    public Paciente update(@RequestBody PacienteUpdateDTO pacienteUpdateDTO){
        return pacienteService.update(pacienteUpdateDTO);
    }

    @GetMapping("/{id}")
    public Optional<Paciente> find(@PathVariable Long id){
        return pacienteService.findById(id);
    }

}
