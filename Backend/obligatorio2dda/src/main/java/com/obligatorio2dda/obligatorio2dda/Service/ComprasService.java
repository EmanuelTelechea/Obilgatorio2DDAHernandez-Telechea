package com.obligatorio2dda.obligatorio2dda.Service;

import java.time.LocalDate;
import java.util.List;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.Compras;
import com.obligatorio2dda.obligatorio2dda.Entity.Usuarios;

public interface ComprasService {
    public Compras agregarCompra(Compras c) throws AppException;
    public List<Compras> listarTodos() throws AppException;
    public List<Compras> conseguirCompraPorUsuario(Usuarios usuarios) throws AppException;
    public List<Compras> conseguirCompraPorFecha(LocalDate fecha) throws AppException;

}
