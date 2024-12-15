package com.obligatorio2dda.obligatorio2dda.Service;

import java.util.List;

import com.obligatorio2dda.obligatorio2dda.AppException;
import com.obligatorio2dda.obligatorio2dda.Entity.Regulares;

public interface RegularService {
  public Regulares altaRegular(Regulares r) throws AppException;
  public boolean eliminarRegular(int id) throws AppException;
  public Regulares modificarRegular(Regulares r) throws AppException;
  public List<Regulares> listarTodos() throws AppException;
  public Regulares conseguirRegular(int id) throws AppException;

}
