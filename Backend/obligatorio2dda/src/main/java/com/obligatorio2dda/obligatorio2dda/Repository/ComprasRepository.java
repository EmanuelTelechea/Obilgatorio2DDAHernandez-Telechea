package com.obligatorio2dda.obligatorio2dda.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obligatorio2dda.obligatorio2dda.Entity.Compras;
import com.obligatorio2dda.obligatorio2dda.Entity.Usuarios;

public interface ComprasRepository extends JpaRepository<Compras, Integer>{
    public List<Compras> findByUsuario(Usuarios usuario);
    public List<Compras> findByFecha(LocalDate fecha);

}
