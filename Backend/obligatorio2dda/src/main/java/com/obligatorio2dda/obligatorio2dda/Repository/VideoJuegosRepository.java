package com.obligatorio2dda.obligatorio2dda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.obligatorio2dda.obligatorio2dda.Entity.VideoJuegos;
import java.util.List;


public interface VideoJuegosRepository extends JpaRepository<VideoJuegos, Integer>{
    public List<VideoJuegos> findByCantStockLessThan(int cantStock);
    public boolean existsByNombre(String nombre);
}
