package com.obligatorio2dda.obligatorio2dda.Entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;

@Entity
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Double monto;

    private LocalDate fecha;
   
    @ManyToOne
    private Usuarios usuario;

    @ManyToMany
    private Set<VideoJuegos> videojuegos;


    public Set<VideoJuegos> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(Set<VideoJuegos> videojuegos) {
        this.videojuegos = videojuegos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Compras(int id, Double monto, LocalDate fecha, Usuarios usuario, Set<VideoJuegos> videoJuegos) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.usuario = usuario;
        this.videojuegos = videoJuegos;
    }

    public Compras(){}
}
