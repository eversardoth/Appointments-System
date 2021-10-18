package com.example.C35.controller;

import com.example.C35.dto.PacienteDTO;
import com.example.C35.dto.PacienteUpdateDTO;
import com.example.C35.entity.Paciente;
import com.example.C35.exception.ResourceNotFoundException;
import com.example.C35.service.IPacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @Operation(summary = "Create patient", security = @SecurityRequirement(name = "bearerAuth"))
    public Paciente save(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.save(pacienteDTO);

    }

    @GetMapping
    @Operation(summary = "List all patients", security = @SecurityRequirement(name = "bearerAuth"))
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete patient", security = @SecurityRequirement(name = "bearerAuth"))
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        return pacienteService.delete(id);
    }

    @PutMapping("/update")
    @Operation(summary = "Update patient", security = @SecurityRequirement(name = "bearerAuth"))
    public Paciente update(@RequestBody PacienteUpdateDTO pacienteUpdateDTO){
        return pacienteService.update(pacienteUpdateDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "List patient", security = @SecurityRequirement(name = "bearerAuth"))
    public Optional<Paciente> find(@PathVariable Long id){
        return pacienteService.findById(id);
    }

}
