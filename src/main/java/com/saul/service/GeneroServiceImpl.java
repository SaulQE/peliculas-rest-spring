package com.saul.service;

import com.saul.entity.Genero;
import com.saul.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class GeneroServiceImpl implements GeneroService
{

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    @Transactional
    public void insert(Genero genero) {
        generoRepository.save(genero);
    }

    @Override
    @Transactional
    public void update(Genero genero) {
        generoRepository.save(genero);
    }

    @Override
    @Transactional
    public void delete(Integer generoId) {
        generoRepository.deleteById(generoId);
    }

    @Override
    @Transactional(readOnly = true)
    public Genero findById(Integer generoId) {
        return generoRepository.findById(generoId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Genero> findAll() {
        return generoRepository.findAll();
    }
}
