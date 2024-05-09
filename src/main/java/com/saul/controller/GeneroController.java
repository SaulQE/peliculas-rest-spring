package com.saul.controller;

import com.saul.entity.Genero;
import com.saul.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class GeneroController
{
    @Autowired
    private GeneroService generoService;

    public GeneroController(){}

    @GetMapping("/generos")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Genero> generosDb = generoService.findAll();
        return new ResponseEntity<>(generosDb, HttpStatus.OK);
    }

    @PostMapping("/genero/register")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> registrar_POST(@RequestBody Genero genero)
    {
        generoService.insert(genero);
        return new ResponseEntity<>("¡Genero registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/genero/update/{generoId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> editar_PUT(@RequestBody Genero newGenero,@PathVariable Integer generoId)
    {
        Genero generoDb = generoService.findById(generoId);

        if(generoDb != null)
        {
            newGenero.setGeneroId(generoId);
            generoService.update(newGenero);

            return new ResponseEntity<>("¡Genero editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Genero no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/genero/delete/{generoId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer generoId)
    {
        Genero generoDb = generoService.findById(generoId);

        if(generoDb != null)
        {
            generoService.delete(generoId);
            return new ResponseEntity<>("¡Genero borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Genero no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/genero/buscar/{generoId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer generoId)
    {
        Genero generoDb = generoService.findById(generoId);

        if(generoDb != null){
            return new ResponseEntity<>(generoDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error genero no existe!",HttpStatus.NOT_FOUND);
    }

}
