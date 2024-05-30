package com.saul.service;

import com.saul.entity.Reseña;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

public interface ReseñaService {
    public abstract void insert(Reseña reseña, JwtAuthenticationToken token);
    public abstract void update(Reseña reseña, JwtAuthenticationToken token);
    public abstract void delete(Integer reseñaId, JwtAuthenticationToken token);
    public abstract Reseña findById(Integer reseñaId);
    public abstract Collection<Reseña> findAll();
}
