package com.example.C35.controller;
import com.example.C35.dto.TurnoDTO;
import com.example.C35.dto.TurnoUpdateDTO;
import com.example.C35.entity.Turno;
import com.example.C35.exception.ResourceNotFoundException;
import com.example.C35.service.ITurnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
@CrossOrigin(origins="*")
public class TurnoController {

    private ITurnoService turnoService;

    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }


    @PostMapping("/save")
    @Operation(summary = "Create appointment", security = @SecurityRequirement(name = "bearerAuth"))
    public Turno save(@RequestBody TurnoDTO turnoDTO){
        return turnoService.save(turnoDTO);

    }

    @GetMapping
    @Operation(summary = "List all appointments", security = @SecurityRequirement(name = "bearerAuth"))
    public List<Turno> findAll(){
        return turnoService.findAll();
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete appointment", security = @SecurityRequirement(name = "bearerAuth"))
    public String delete(@PathVariable Long id) throws ResourceNotFoundException {
        return turnoService.delete(id);
    }

    @PutMapping("/update")
    @Operation(summary = "Update appointment", security = @SecurityRequirement(name = "bearerAuth"))
    public Turno update(@RequestBody TurnoUpdateDTO turnoUpdateDTO){
        return turnoService.update(turnoUpdateDTO);
    }

    @GetMapping("/{id}")
    @Operation(summary = "List appointment", security = @SecurityRequirement(name = "bearerAuth"))
    public Optional<Turno> find(@PathVariable Long id){
        return turnoService.findById(id);
    }

}
