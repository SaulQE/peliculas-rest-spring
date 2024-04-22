package com.saul.controller;

import com.saul.entity.Director;
import com.saul.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/director")
public class DirectorRestController
{
    @Autowired
    private DirectorService directorService;

    public DirectorRestController(){}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Director> directoresDb = directorService.findAll();
        return new ResponseEntity<>(directoresDb, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Director director)
    {
        directorService.insert(director);
        return new ResponseEntity<>("¡Director registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{directorId}")
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

    @DeleteMapping("/borrar/{directorId}")
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

    @GetMapping("/buscar/{directorId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer directorId)
    {
        Director directorDb = directorService.findById(directorId);

        if(directorDb != null){
            return new ResponseEntity<>(directorDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error categoría no existe!",HttpStatus.NOT_FOUND);
    }

}
