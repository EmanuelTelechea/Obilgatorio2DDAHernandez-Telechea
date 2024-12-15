package com.obligatorio2dda.obligatorio2dda.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.Compras;
import com.obligatorio2dda.obligatorio2dda.Entity.Premium;
import com.obligatorio2dda.obligatorio2dda.Entity.Usuarios;
import com.obligatorio2dda.obligatorio2dda.Entity.VideoJuegos;
import com.obligatorio2dda.obligatorio2dda.Repository.ComprasRepository;
import com.obligatorio2dda.obligatorio2dda.Repository.VideoJuegosRepository;

@Service
public class ComprasServiceImpl implements ComprasService {
  @Autowired
  public ComprasRepository comprasRepository;
  @Autowired
  public VideoJuegosRepository videoJuegosRepository;

  public Compras agregarCompra(Compras c) throws AppException {
    if (c.getUsuario() instanceof Premium) {
      double precioConDescuento = c.getMonto() * 0.8;
      c.setMonto(precioConDescuento);
    }

    for (VideoJuegos videojuego : c.getVideojuegos()) {
      if (videojuego.getCantStock() <= 0) {
        throw new AppException("El videojuego " + videojuego.getNombre() + " no tiene suficiente stock");
      }
      videojuego.setCantStock(videojuego.getCantStock() - 1);
      videoJuegosRepository.save(videojuego);
    }

    try {
      return comprasRepository.save(c);
    } catch (Exception e) {
      throw new AppException("Ocurrió un error al agregar la compra: " + e.getMessage());
    }
  }

  public List<Compras> listarTodos() {
    return comprasRepository.findAll();
  }

  public List<Compras> conseguirCompraPorUsuario(Usuarios usuario) throws AppException {
    List<Compras> compras = comprasRepository.findByUsuario(usuario);
    if (compras.isEmpty()) {
      throw new AppException("No se encontraron compras para el usuario con ID: " + usuario.getId());
    }
    return compras;
  }

  public List<Compras> conseguirCompraPorFecha(LocalDate fecha) throws AppException {
    List<Compras> compras = comprasRepository.findByFecha(fecha);
    if (compras.isEmpty()) {
      throw new AppException("No se encontraron compras para la fecha: " + fecha);
    }
    return compras;
  }
}
