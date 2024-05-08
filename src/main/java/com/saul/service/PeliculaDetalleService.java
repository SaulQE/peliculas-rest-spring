package com.saul.service;

import com.saul.entity.PeliculaDetalle;

import java.util.Collection;

public interface PeliculaDetalleService {
    public abstract void insert(PeliculaDetalle detalle);
    public abstract void update(PeliculaDetalle detalle);
    public abstract void delete(Integer detalleId);
    public abstract PeliculaDetalle findById(Integer detalleId);
    public abstract Collection<PeliculaDetalle> findAll();
}
