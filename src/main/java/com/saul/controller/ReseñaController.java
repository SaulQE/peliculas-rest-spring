package com.saul.controller;

import com.saul.entity.Reseña;
import com.saul.mapper.ReseñaMapper;
import com.saul.service.ReseñaService;
import com.saul.util.ReseñaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ReseñaController {

    public ReseñaController() {
    }

    @Autowired
    private ReseñaService reseñaService;

    @GetMapping("/reseñas")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_BASIC') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> list(){

        var reseñas = reseñaService.findAll();

        Collection<ReseñaMapper> reseñaMappers = ReseñaUtil.convertList(reseñas);

        return new ResponseEntity<>(reseñaMappers, HttpStatus.OK);
    }

    @PostMapping("/reseña/create")
    public ResponseEntity<?> create(@RequestBody Reseña reseña, JwtAuthenticationToken token)
    {
        reseñaService.insert(reseña, token);
        return new ResponseEntity<>("Reseña creada correctamente", HttpStatus.CREATED);
    }

    @PutMapping("/reseña/update/{reseñaId}")
    public ResponseEntity<?> update(@PathVariable("reseñaId") Integer reseñaId,
                                    @RequestBody Reseña newReseña,
                                    JwtAuthenticationToken token)
    {
        Reseña reseñaDb = reseñaService.findById(reseñaId);
        if (reseñaDb != null){
            reseñaService.update(newReseña, token);
            return new ResponseEntity<>("Reseña actualizada correctamente", HttpStatus.OK);
        }

        return new ResponseEntity<>("Reseña no encontrada", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reseña/delete/{reseñaId}")
    public ResponseEntity<?> delete(@PathVariable("reseñaId") Integer reseñaId,
                                    JwtAuthenticationToken token)
    {
        Reseña reseña = reseñaService.findById(reseñaId);

        if (reseña != null){
            reseñaService.delete(reseñaId, token);
            return new ResponseEntity<>("Reseña eliminada correctamente", HttpStatus.OK);
        }

        return new ResponseEntity<>("Reseña no encontrada", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reseña/buscar/{reseñaId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_BASIC') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> findById(@PathVariable("reseñaId") Integer reseñaId){
        Reseña reseña = reseñaService.findById(reseñaId);
        ReseñaMapper reseñaMapper = ReseñaUtil.convertEntity(reseña);

        if (reseña != null){
            return new ResponseEntity<>(reseñaMapper, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Reseña no encontrada", HttpStatus.NOT_FOUND);
    }

}
