package com.obligatorio2dda.obligatorio2dda.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.obligatorio2dda.obligatorio2dda.Entity.Premium;

public interface PremiumRepository extends JpaRepository<Premium,Integer> {
    boolean existsByNombre(String nombre);
}
