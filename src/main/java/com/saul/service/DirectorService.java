package com.saul.service;

import com.saul.entity.Director;

import java.util.Collection;

public interface DirectorService
{
    //Servicios
    public abstract void insert(Director director);
    public abstract void update(Director director);
    public abstract void delete(Integer directorId);
    public abstract Director findById(Integer directorId);
    public abstract Collection<Director> findAll();
}
