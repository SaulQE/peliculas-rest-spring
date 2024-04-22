package com.saul.service;

import com.saul.entity.Director;
import com.saul.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class DirectorServiceImpl implements DirectorService
{

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    @Transactional
    public void insert(Director director) {
        directorRepository.save(director);
    }

    @Override
    @Transactional
    public void update(Director director) {
        directorRepository.save(director);
    }

    @Override
    @Transactional
    public void delete(Integer directorId) {
        directorRepository.deleteById(directorId);
    }

    @Override
    @Transactional(readOnly = true)
    public Director findById(Integer directorId) {
        return directorRepository.findById(directorId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Director> findAll() {
        return directorRepository.findAll();
    }
}
