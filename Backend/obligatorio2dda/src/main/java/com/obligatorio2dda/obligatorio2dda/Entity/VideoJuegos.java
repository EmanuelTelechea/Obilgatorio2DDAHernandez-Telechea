package com.obligatorio2dda.obligatorio2dda.Entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class VideoJuegos {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(length =30)
    private String nombre;

    private String descripcion;
    
    private double precio;

    private int cantStock;

    private String categoria;

    @ManyToMany(mappedBy = "videojuegos")
    @JsonIgnore
    private Set<Compras> compras;
    
    public Set<Compras> getCompras() {
        return compras;
    }
    public void setCompras(Set<Compras> compras) {
        this.compras = compras;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public int getCantStock() {
        return cantStock;
    }
    public void setCantStock(int cantStock) {
        this.cantStock = cantStock;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public VideoJuegos(int id, String nombre, String descripcion, double precio,  int cantStock, String categoria, Set<Compras> compras) {
        this.Id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantStock = cantStock;
        this.categoria = categoria;
        this.compras = compras;
    }

    public VideoJuegos(){}

}
