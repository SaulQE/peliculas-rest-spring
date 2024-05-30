package com.saul.controller;

import com.saul.entity.Genero;
import com.saul.entity.PeliculaDetalle;
import com.saul.mapper.PeliculaDetalleMapper;
import com.saul.mapper.ReseñaMapper;
import com.saul.service.GeneroService;
import com.saul.service.PeliculaDetalleService;
import com.saul.util.PeliculaDetalleUtil;
import com.saul.util.ReseñaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class PeliculaDetalleController
{
    @Autowired
    private PeliculaDetalleService peliculaDetalleService;

    public PeliculaDetalleController(){}

    @GetMapping("/pelicula-detalles")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> listar_GET()
    {
        Collection<PeliculaDetalle> detallesDb = peliculaDetalleService.findAll();

        Collection<PeliculaDetalleMapper> detalleMappers = PeliculaDetalleUtil.convertList(detallesDb);

        return new ResponseEntity<>(detalleMappers, HttpStatus.OK);
    }

    @PostMapping("/detalle/register")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> registrar_POST(@RequestBody PeliculaDetalle detalle)
    {
        peliculaDetalleService.insert(detalle);
        return new ResponseEntity<>("¡Detalle registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/detalle/update/{detalleId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> editar_PUT(@RequestBody PeliculaDetalle newDetalle,@PathVariable Integer detalleId)
    {
        PeliculaDetalle detalleDb = peliculaDetalleService.findById(detalleId);

        if(detalleDb != null)
        {
            newDetalle.setDetalleId(detalleId);
            peliculaDetalleService.update(newDetalle);

            return new ResponseEntity<>("¡Detalle editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error detalle no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/detalle/delete/{detalleId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer detalleId)
    {
        PeliculaDetalle detalleDb = peliculaDetalleService.findById(detalleId);

        if(detalleDb != null)
        {
            peliculaDetalleService.delete(detalleId);
            return new ResponseEntity<>("¡Detalle borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Error detalle no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/detalle/buscar/{detalleId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer detalleId)
    {
        PeliculaDetalle detalleDb = peliculaDetalleService.findById(detalleId);
        PeliculaDetalleMapper detalleMapper = PeliculaDetalleUtil.convertEntity(detalleDb);

        if(detalleDb != null){
            return new ResponseEntity<>(detalleMapper,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Error detalle no existe!",HttpStatus.NOT_FOUND);
    }

}
