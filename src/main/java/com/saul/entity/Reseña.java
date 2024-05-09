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

    public Reseña(Integer reseñaId, Double puntuacion, String comentario, Pelicula pelicula, User user) {
        this.reseñaId = reseñaId;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.pelicula = pelicula;
        this.user = user;
    }

    public Integer getReseñaId() {
        return reseñaId;
    }

    public void setReseñaId(Integer reseñaId) {
        this.reseñaId = reseñaId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
