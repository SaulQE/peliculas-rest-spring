package com.saul.controller;

import com.saul.entity.Director;
import com.saul.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class DirectorController
{
    @Autowired
    private DirectorService directorService;

    public DirectorController(){}

    @GetMapping("/directores")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Director> directoresDb = directorService.findAll();
        return new ResponseEntity<>(directoresDb, HttpStatus.OK);
    }

    @PostMapping("/director/register")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> registrar_POST(@RequestBody Director director)
    {
        directorService.insert(director);
        return new ResponseEntity<>("¡Director registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/director/update/{directorId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> editar_PUT(@RequestBody Director newDirector,@PathVariable Integer directorId)
    {
        Director directorDb = directorService.findById(directorId);

        if(directorDb != null)
        {
            newDirector.setDirectorId(directorId);
            directorService.update(newDirector);

            return new ResponseEntity<>("¡Director editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Director no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/director/delete/{directorId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer directorId)
    {
        Director directorDb = directorService.findById(directorId);

        if(directorDb != null)
        {
            directorService.delete(directorId);
            return new ResponseEntity<>("¡Director borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error Director no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/director/buscar/{directorId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer directorId)
    {
        Director directorDb = directorService.findById(directorId);

        if(directorDb != null){
            return new ResponseEntity<>(directorDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error Director no existe!",HttpStatus.NOT_FOUND);
    }

}
