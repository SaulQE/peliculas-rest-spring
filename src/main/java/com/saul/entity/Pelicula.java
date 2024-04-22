package com.saul.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "peliculas")
public class Pelicula implements Serializable
{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer peliculaId;

    private String titulo;
    private String protagonista;
    private String idioma;
    @DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
    private LocalDate estreno;
    private Integer durMinutos;
    private Double puntuacion;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;

    public Pelicula(){}

    public Pelicula(Integer peliculaId, String titulo, String protagonista, String idioma, LocalDate estreno, Integer durMinutos, Double puntuacion) {
        this.peliculaId = peliculaId;
        this.titulo = titulo;
        this.protagonista = protagonista;
        this.idioma = idioma;
        this.estreno = estreno;
        this.durMinutos = durMinutos;
        this.puntuacion = puntuacion;
    }

    public Integer getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(String protagonista) {
        this.protagonista = protagonista;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public LocalDate getEstreno() {
        return estreno;
    }

    public void setEstreno(LocalDate estreno) {
        this.estreno = estreno;
    }

    public Integer getDurMinutos() {
        return durMinutos;
    }

    public void setDurMinutos(Integer durMinutos) {
        this.durMinutos = durMinutos;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
