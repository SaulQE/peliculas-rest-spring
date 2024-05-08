package com.saul.service;

import com.saul.entity.Reseña;

import java.util.Collection;

public interface ReseñaService {
    public abstract void insert(Reseña reseña);
    public abstract void update(Reseña reseña);
    public abstract void delete(Integer reseñaId);
    public abstract Reseña findById(Integer reseñaId);
    public abstract Collection<Reseña> findAll();
}
