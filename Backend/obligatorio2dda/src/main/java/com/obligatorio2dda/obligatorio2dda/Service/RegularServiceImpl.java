package com.obligatorio2dda.obligatorio2dda.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.Regulares;
import com.obligatorio2dda.obligatorio2dda.Repository.RegularRepository;

@Service
public class RegularServiceImpl implements RegularService {

    @Autowired
    private RegularRepository regularRepository;

    public Regulares altaRegular(Regulares r) throws AppException {
        if (regularRepository.existsByNombre(r.getNombre())) {
            throw new AppException("Ya existe un registro con el nombre asignado");
        }
        return regularRepository.save(r);
    }

    public boolean eliminarRegular(int id) throws AppException {
        if (regularRepository.existsById(id)) {
            regularRepository.deleteById(id);
            return true;
        }
        throw new AppException("El registro con el ID especificado no existe");
    }

    public Regulares modificarRegular(Regulares r) throws AppException {
        if (regularRepository.existsById(r.getId())) {
            return regularRepository.save(r);
        }
        throw new AppException("El registro con el ID especificado no existe");
    }

    public List<Regulares> listarTodos() {
        return regularRepository.findAll();
    }

    public Regulares conseguirRegular(int id) throws AppException{
        if(regularRepository.existsById(id)){
            return regularRepository.findById(id).get();
        }
        throw new AppException("El videojuego con el ID especificado no existe");
    }
}

