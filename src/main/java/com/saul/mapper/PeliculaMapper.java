package com.saul.mapper;
import com.saul.entity.Pelicula;

import java.time.LocalDate;

public class PeliculaMapper {

    private Integer peliculaId;
    private String titulo;
    private String protagonista;
    private String idioma;
    private LocalDate estreno;
    private Integer durMinutos;
    private Double puntuacion;
    private Integer directorId;
    private Integer generoId;

    public PeliculaMapper() {
    }

    public PeliculaMapper(Integer peliculaId, String titulo, String protagonista, String idioma, LocalDate estreno, Integer durMinutos, Double puntuacion, Integer directorId, Integer generoId) {
        this.peliculaId = peliculaId;
        this.titulo = titulo;
        this.protagonista = protagonista;
        this.idioma = idioma;
        this.estreno = estreno;
        this.durMinutos = durMinutos;
        this.puntuacion = puntuacion;
        this.directorId = directorId;
        this.generoId = generoId;
    }

    public PeliculaMapper(Pelicula pelicula) {
        this(pelicula.getPeliculaId(), pelicula.getTitulo(), pelicula.getProtagonista(),
                pelicula.getIdioma(), pelicula.getEstreno(), pelicula.getDurMinutos(), pelicula.getPuntuacion(),
                pelicula.getDirector().getDirectorId(), pelicula.getGenero().getGeneroId());
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

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public void setGeneroId(Integer generoId) {
        this.generoId = generoId;
    }
}
