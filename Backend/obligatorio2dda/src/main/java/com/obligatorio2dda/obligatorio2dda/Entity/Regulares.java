package com.obligatorio2dda.obligatorio2dda.Entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;

@Entity
public class Regulares extends Usuarios{
    
     public Regulares(int id, String nombre, String email, LocalDate fechaRegistro, Set<Compras> compras) {
        super(id, nombre, email,fechaRegistro,compras);
    }
public Regulares(){}

}
