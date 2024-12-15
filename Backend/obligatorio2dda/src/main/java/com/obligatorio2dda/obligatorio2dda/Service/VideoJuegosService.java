package com.obligatorio2dda.obligatorio2dda.Service;


import java.util.List;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.VideoJuegos;

public interface VideoJuegosService {

      public VideoJuegos agregarVJ(VideoJuegos vj) throws Exception;
      public boolean eliminarVJ(int id) throws Exception;
      public VideoJuegos modificarVJ(VideoJuegos vj) throws Exception;
      public List<VideoJuegos> listarTodos() throws AppException;
      public VideoJuegos conseguirVideoJuego(int id) throws AppException;
      public List<VideoJuegos> filtrarPorStock(int cantStock);
}
