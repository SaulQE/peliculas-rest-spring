package com.saul.service;

import com.saul.entity.Pelicula;
import com.saul.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class PeliculaServiceImpl implements PeliculaService
{

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    @Transactional
    public void insert(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    @Transactional
    public void update(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    @Transactional
    public void delete(Integer peliculaId) {
        peliculaRepository.deleteById(peliculaId);
    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula findById(Integer peliculaId) {
        return peliculaRepository.findById(peliculaId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }
}
