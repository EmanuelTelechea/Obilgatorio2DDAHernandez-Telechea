package com.obligatorio2dda.obligatorio2dda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.obligatorio2dda.obligatorio2dda.Entity.Usuarios;

public interface UsuarioRepository extends JpaRepository <Usuarios, Integer>{
    public List<Usuarios> findById(int id);

}
