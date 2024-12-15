package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.Premium;
import com.obligatorio2dda.obligatorio2dda.Repository.PremiumRepository;

@Service
public class PremiumServiceImpl implements PremiumService {

    @Autowired
    private PremiumRepository premiumRepository;

    public Premium altaPremium(Premium p) throws AppException {
        if (premiumRepository.existsByNombre(p.getNombre())) {
            throw new AppException("Ya existe un registro con el nombre asignado");
        }
        return premiumRepository.save(p);
    }

    public boolean eliminarPremium(int id) throws AppException {
        if (premiumRepository.existsById(id)) {
            premiumRepository.deleteById(id);
            return true;
        }
        throw new AppException("El registro con el ID especificado no existe");
    }

    public Premium modificarPremium(Premium p) throws AppException {
        if (premiumRepository.existsById(p.getId())) {
            return premiumRepository.save(p);
        }
        throw new AppException("El registro con el ID especificado no existe");
    }

    public List<Premium> listarTodos() {
        return premiumRepository.findAll();
    }

    public Premium conseguirPremium(int id) throws AppException{
        if(premiumRepository.existsById(id)){
            return premiumRepository.findById(id).get();
        }
        throw new AppException("El videojuego con el ID especificado no existe");
    }
}

