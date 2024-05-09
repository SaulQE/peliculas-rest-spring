package com.saul.service;

import com.saul.entity.Reseña;
import com.saul.repository.ReseñaRepository;
import com.saul.repository.UserRepository;
import com.saul.util.Values;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@Service
public class ReseñaServiceImpl implements ReseñaService {

    @Autowired
    private ReseñaRepository reseñaRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void insert(Reseña reseña, JwtAuthenticationToken token) {
        var user = userRepository.findById(Integer.parseInt(token.getName()));

        reseña.setUser(user.get());
        reseñaRepository.save(reseña);
    }

    @Override
    @Transactional
    public void update(Reseña reseña, JwtAuthenticationToken token)
    {
        var user = userRepository.findById(Integer.parseInt(token.getName()));

        var existingReseña = reseñaRepository.findById(reseña.getReseñaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var isAdmin = user.get().getRoles()
                .stream()
                .anyMatch(role -> role.getName().equalsIgnoreCase(Values.ADMIN.name()));

        var isDba = user.get().getRoles()
                .stream()
                .anyMatch(role -> role.getName().equalsIgnoreCase(Values.DBA.name()));

        if ((isAdmin && isDba) || existingReseña.getUser().getUserId().equals(user.get().getUserId())) {
            BeanUtils.copyProperties(reseña, existingReseña, "reseñaId", "user");
            existingReseña.setUser(user.get());
            reseñaRepository.save(existingReseña);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    @Transactional
    public void delete(Integer reseñaId, JwtAuthenticationToken token) {
        var user = userRepository.findById(Integer.parseInt(token.getName()));
        var reseña = reseñaRepository.findById(reseñaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var isAdmin = user.get().getRoles()
                .stream()
                .anyMatch(role -> role.getName().equalsIgnoreCase(Values.ADMIN.name()));

        var isDba = user.get().getRoles()
                .stream()
                .anyMatch(role -> role.getName().equalsIgnoreCase(Values.DBA.name()));

        if ((isAdmin && isDba) || reseña.getUser().getUserId().equals(Integer.parseInt(token.getName()))) {
            reseñaRepository.deleteById(reseñaId);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Reseña findById(Integer reseñaId) {
        return reseñaRepository.findById(reseñaId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Reseña> findAll() {
        return reseñaRepository.findAll();
    }
}
