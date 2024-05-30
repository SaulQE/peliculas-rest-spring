package com.saul.mapper;

import com.saul.entity.Pelicula;
import com.saul.entity.PeliculaDetalle;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class PeliculaDetalleMapper {

    private Integer detalleId;
    private String clasificacion;
    private String formato;
    private Integer peliculaId;

    public PeliculaDetalleMapper() {
    }

    public PeliculaDetalleMapper(PeliculaDetalle detalle){
        this(detalle.getDetalleId(),detalle.getClasificacion(),
                detalle.getFormato(),detalle.getPelicula().getPeliculaId());
    }

    public PeliculaDetalleMapper(Integer detalleId, String clasificacion, String formato, Integer peliculaId) {
        this.detalleId = detalleId;
        this.clasificacion = clasificacion;
        this.formato = formato;
        this.peliculaId = peliculaId;
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

    public Integer getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Integer peliculaId) {
        this.peliculaId = peliculaId;
    }
}
