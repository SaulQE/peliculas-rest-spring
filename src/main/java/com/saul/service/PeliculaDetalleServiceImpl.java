package com.saul.service;

import com.saul.entity.PeliculaDetalle;
import com.saul.repository.PeliculaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class PeliculaDetalleServiceImpl implements PeliculaDetalleService
{

    @Autowired
    private PeliculaDetalleRepository peliculaDetalleRepository;

    @Override
    @Transactional
    public void insert(PeliculaDetalle detalle) {
        peliculaDetalleRepository.save(detalle);
    }

    @Override
    @Transactional
    public void update(PeliculaDetalle detalle) {
        peliculaDetalleRepository.save(detalle);
    }

    @Override
    @Transactional
    public void delete(Integer detalleId) {
        peliculaDetalleRepository.deleteById(detalleId);
    }

    @Override
    @Transactional(readOnly = true)
    public PeliculaDetalle findById(Integer detalleId) {
        return peliculaDetalleRepository.findById(detalleId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<PeliculaDetalle> findAll() {
        return peliculaDetalleRepository.findAll();
    }
}
