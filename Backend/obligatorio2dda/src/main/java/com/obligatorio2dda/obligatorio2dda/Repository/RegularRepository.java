package com.obligatorio2dda.obligatorio2dda.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obligatorio2dda.obligatorio2dda.Entity.Regulares;

public interface RegularRepository extends JpaRepository <Regulares,Integer>{
    boolean existsByNombre(String nombre);
}
    

