package com.saul.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pelicula_detalle")
public class PeliculaDetalle implements Serializable
{
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detalleId;
    private String clasificacion;
    private String formato;

    @OneToOne
    @JoinColumn(name = "pelicula_id", nullable = false, unique = true)
    private Pelicula pelicula;

    public PeliculaDetalle() {
    }

    public PeliculaDetalle(Integer detalleId, String clasificacion, String formato) {
        this.detalleId = detalleId;
        this.clasificacion = clasificacion;
        this.formato = formato;
    }

    public Integer getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Integer detalleId) {
        this.detalleId = detalleId;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
