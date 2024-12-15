package com.obligatorio2dda.obligatorio2dda.Entity;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuarios {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    private String nombre;

    private String email;

    private LocalDate fechaRegistro;
   
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private Set<Compras> compras;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Set<Compras> getCompras() {
        return compras;
    }
    public void setCompras(Set<Compras> compras) {
        this.compras = compras;
    }
    public Usuarios(int id, String nombre, String email, LocalDate fechaRegistro, Set<Compras> compras) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.compras = compras;
    }
    public Usuarios(){}
    
}
