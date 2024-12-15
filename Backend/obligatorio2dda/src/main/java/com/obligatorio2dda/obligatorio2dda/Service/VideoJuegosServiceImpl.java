package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.VideoJuegos;
import com.obligatorio2dda.obligatorio2dda.Repository.VideoJuegosRepository;


@Service
public class VideoJuegosServiceImpl implements VideoJuegosService {

    @Autowired
    private VideoJuegosRepository videoJuegosRepository;

    public VideoJuegos agregarVJ(VideoJuegos vj) throws AppException {
        if (videoJuegosRepository.existsByNombre(vj.getNombre())) {
            throw new AppException("Ya existe un videojuego con el título asignado");
        }
        return videoJuegosRepository.save(vj);
    }

    public boolean eliminarVJ(int id) throws AppException {
        if (videoJuegosRepository.existsById(id)) {
            videoJuegosRepository.deleteById(id);
            return true;
        }
        throw new AppException("El videojuego con el ID especificado no existe");
    }

    public VideoJuegos modificarVJ(VideoJuegos vj) throws AppException {
        if (videoJuegosRepository.existsById(vj.getId())) {
            return videoJuegosRepository.save(vj);
        }
        throw new AppException("El videojuego con el ID especificado no existe");
    }

    public List<VideoJuegos> listarTodos() {
        return videoJuegosRepository.findAll();
    }
    public VideoJuegos conseguirVideoJuego(int id) throws AppException{
        if(videoJuegosRepository.existsById(id)){
            return videoJuegosRepository.findById(id).get();
        }
        throw new AppException("El videojuego con el ID especificado no existe");
    }

    public List<VideoJuegos> filtrarPorStock(int cantStock) {
        return videoJuegosRepository.findByCantStockLessThan(cantStock);
    }
}



