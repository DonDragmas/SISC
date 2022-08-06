package com.sisc.sonyconsolas.service;

import java.util.List;

import com.sisc.sonyconsolas.model.Rol;

public interface RolService {
    public List<Rol> findAll();
    public void save (Rol rol);
    public Rol findOne(Integer idRol);
    public void delete (Integer idRol);
}
