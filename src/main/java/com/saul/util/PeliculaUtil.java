package com.saul.util;

import com.saul.entity.Pelicula;
import com.saul.entity.Reseña;
import com.saul.mapper.PeliculaMapper;
import com.saul.mapper.ReseñaMapper;

import java.util.ArrayList;
import java.util.Collection;

public class PeliculaUtil {
    public static Collection<PeliculaMapper> convertList(Collection<Pelicula> peliculas)
    {
        Collection<PeliculaMapper> mappers = new ArrayList<>();

        for (Pelicula pelicula:peliculas)
        {
            PeliculaMapper peliculaMapper = new PeliculaMapper(pelicula);
            mappers.add(peliculaMapper);
        }

        return mappers;
    }

    public static PeliculaMapper convertEntity(Pelicula pelicula)
    {
        PeliculaMapper peliculaMapper = new PeliculaMapper(pelicula);

        return peliculaMapper;
    }

}
