package com.saul.repository;

import com.saul.entity.PeliculaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaDetalleRepository extends JpaRepository<PeliculaDetalle, Integer>
{
}
