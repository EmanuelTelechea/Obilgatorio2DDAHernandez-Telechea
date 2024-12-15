package com.obligatorio2dda.obligatorio2dda.Entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;

@Entity
public class Premium extends Usuarios {

    private LocalDate inicio;

    public LocalDate getInicio() {
        return inicio;
    }
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
    public Premium(int id, String nombre, String email, LocalDate fechaRegistro, Set<Compras> compras, 
        LocalDate inicio) {
        super(id, nombre, email, fechaRegistro, compras);
        this.inicio = inicio;
    }
    public Premium() {}

}
