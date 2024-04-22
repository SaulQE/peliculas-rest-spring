package com.saul.controller;

import com.saul.entity.Pelicula;
import com.saul.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pelicula")
public class PeliculaRestController
{
    @Autowired
    private PeliculaService peliculaService;

    public PeliculaRestController(){}


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Pelicula> peliculasDb = peliculaService.findAll();
        return new ResponseEntity<>(peliculasDb, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Pelicula pelicula)
    {
        peliculaService.insert(pelicula);
        return new ResponseEntity<>("Pelicula creada", HttpStatus.CREATED);
    }


    @PutMapping("/editar/{peliculaId}")
    public ResponseEntity<?> editar_PUT(@RequestBody Pelicula newPelicula, @PathVariable Integer peliculaId)
    {
        Pelicula peliculaDb = peliculaService.findById(peliculaId);

        if(peliculaDb != null)
        {
            newPelicula.setPeliculaId(peliculaId);
            peliculaService.update(newPelicula);
            return new ResponseEntity<>("pelicula editada", HttpStatus.OK);
        }
        return new ResponseEntity<>("¡Error, pelicula no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{peliculaId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer peliculaId)
    {
        Pelicula peliculaDb = peliculaService.findById(peliculaId);

        if(peliculaDb != null)
        {
            peliculaService.delete(peliculaId);
            return new ResponseEntity<>("¡pelicula borrada!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error, pelicula no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{peliculaId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer peliculaId)
    {
        Pelicula peliculaDb = peliculaService.findById(peliculaId);

        if(peliculaDb != null) {
            return new ResponseEntity<>(peliculaDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error, pelicula no existe!",HttpStatus.NOT_FOUND);
    }

}
