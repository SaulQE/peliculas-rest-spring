package com.saul.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "generos")
public class Genero implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer generoId;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "genero")
    private Collection<Pelicula> itemsPeliculasGenero = new ArrayList<>();

    public Genero(){}

    public Genero(Integer generoId, String nombre, String descripcion) {
        this.generoId = generoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Pelicula> getItemsPeliculasGenero() {
        return itemsPeliculasGenero;
    }

    public void setItemsPeliculasGenero(Collection<Pelicula> itemsPeliculasGenero) {
        this.itemsPeliculasGenero = itemsPeliculasGenero;
    }
}
