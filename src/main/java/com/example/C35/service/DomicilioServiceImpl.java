package com.example.C35.service;

import com.example.C35.entity.Domicilio;
import com.example.C35.repository.IDomicilioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements IDomicilioService {

    private IDomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(IDomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<Domicilio> findAll() {
        return null;
    }

    @Override
    public Optional<Domicilio> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Domicilio save(Domicilio domicilio) {
        return null;
    }

    @Override
    public Domicilio update(Domicilio domicilio) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
