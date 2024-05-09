package com.saul.util;

import com.saul.entity.Reseña;
import com.saul.mapper.ReseñaMapper;

import java.util.ArrayList;
import java.util.Collection;

public class ReseñaUtil {
    public static Collection<ReseñaMapper> convertList(Collection<Reseña> reseñas)
    {
        Collection<ReseñaMapper> mappers = new ArrayList<>();

        for (Reseña reseña:reseñas)
        {
            ReseñaMapper reseñaMapper = new ReseñaMapper(reseña);
            mappers.add(reseñaMapper);
        }

        return mappers;
    }

    public static ReseñaMapper convertEntity(Reseña reseña)
    {
        ReseñaMapper reseñaMapper = new ReseñaMapper(reseña);

        return reseñaMapper;
    }

}
