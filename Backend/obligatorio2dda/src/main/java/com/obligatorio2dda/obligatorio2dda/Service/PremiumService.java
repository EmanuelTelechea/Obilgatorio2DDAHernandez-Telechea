package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.Premium;

public interface PremiumService {
    public Premium altaPremium(Premium p) throws AppException;
    public boolean eliminarPremium(int id) throws AppException;
    public Premium modificarPremium(Premium p) throws AppException;
    public List<Premium> listarTodos() throws AppException;
    public Premium conseguirPremium(int id) throws AppException;

}
