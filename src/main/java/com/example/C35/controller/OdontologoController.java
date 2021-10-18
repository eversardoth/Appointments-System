package com.example.C35.controller;


import com.example.C35.dto.OdontologoDTO;
import com.example.C35.dto.OdontologoUpdateDTO;
import com.example.C35.entity.Odontologo;
import com.example.C35.exception.ResourceNotFoundException;
import com.example.C35.service.IOdontologoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    @Operation(summary = "Create dentist", security = @SecurityRequirement(name = "bearerAuth"))
    public Odontologo save(@RequestBody OdontologoDTO odontologoDTO){
        return odontologoService.save(odontologoDTO);
    }

    @GetMapping
    @Operation(summary = "List all dentists", security = @SecurityRequirement(name = "bearerAuth"))
    public List<Odontologo> findAll(){
        return odontologoService.findAll();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete dentist", security = @SecurityRequirement(name = "bearerAuth"))
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        return odontologoService.delete(id);
    }

    @PutMapping("/update")
    @Operation(summary = "Update dentist", security = @SecurityRequirement(name = "bearerAuth"))
    public Odontologo update(@RequestBody OdontologoUpdateDTO odontologoUpdateDTO){
        return odontologoService.update(odontologoUpdateDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "List dentist", security = @SecurityRequirement(name = "bearerAuth"))
    public Optional<Odontologo> find(@PathVariable Long id){
        return odontologoService.findById(id);
    }




}
