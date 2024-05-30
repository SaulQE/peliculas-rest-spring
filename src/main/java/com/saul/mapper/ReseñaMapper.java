package com.saul.mapper;


import com.saul.entity.Reseña;

public class ReseñaMapper {
    private Integer reseñaId;
    private Double puntuacion;
    private String comentario;
    private Integer peliculaId;
    private Integer userId;

    public ReseñaMapper() {
    }

    public ReseñaMapper(Integer reseñaId, Double puntuacion, String comentario, Integer peliculaId, Integer userId) {
        this.reseñaId = reseñaId;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.peliculaId = peliculaId;
        this.userId = userId;
    }

    public ReseñaMapper(Reseña reseña) {
        this(reseña.getReseñaId(), reseña.getPuntuacion(), reseña.getComentario(),
                reseña.getPelicula().getPeliculaId(), reseña.getUser().getUserId());
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

    public Integer getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
