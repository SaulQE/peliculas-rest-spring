package com.saul.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reseñas")
public class Reseña implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reseñaId;

    private String critico;
    private Double puntuacion;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "pelicula_id", nullable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Reseña() {
    }

    public Reseña(Integer reseñaId, String critico, Double puntuacion, String comentario) {
        this.reseñaId = reseñaId;
        this.critico = critico;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
    }

    public Integer getReseñaId() {
        return reseñaId;
    }

    public void setReseñaId(Integer reseñaId) {
        this.reseñaId = reseñaId;
    }

    public String getCritico() {
        return critico;
    }

    public void setCritico(String critico) {
        this.critico = critico;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
