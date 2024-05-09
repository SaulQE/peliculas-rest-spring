package com.saul.util;

import com.saul.entity.Pelicula;
import com.saul.entity.PeliculaDetalle;
import com.saul.mapper.PeliculaDetalleMapper;
import com.saul.mapper.PeliculaMapper;

import java.util.ArrayList;
import java.util.Collection;

public class PeliculaDetalleUtil {
    public static Collection<PeliculaDetalleMapper> convertList(Collection<PeliculaDetalle> detalles)
    {
        Collection<PeliculaDetalleMapper> mappers = new ArrayList<>();

        for (PeliculaDetalle detalle:detalles)
        {
            PeliculaDetalleMapper detalleMapper = new PeliculaDetalleMapper(detalle);
            mappers.add(detalleMapper);
        }

        return mappers;
    }

    public static PeliculaDetalleMapper convertEntity(PeliculaDetalle detalle)
    {
        PeliculaDetalleMapper detalleMapper = new PeliculaDetalleMapper(detalle);

        return detalleMapper;
    }

}
