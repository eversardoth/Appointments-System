package com.example.C35.repository;

import com.example.C35.entity.Odontologo;
import com.example.C35.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {

    Optional<Odontologo> findByMatricula(String matricula);


}
