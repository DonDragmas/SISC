package com.sisc.sonyconsolas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sisc.sonyconsolas.model.IRol;
import com.sisc.sonyconsolas.model.Rol;

public class IRolImpl implements RolService {

    @Autowired
    private IRol rol;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rol.findAll(); 
    }

    @Override
    public void save(Rol ro) {
        rol.save(ro);
        
    }

    @Override
    public Rol findOne(Integer idRol) {
            return rol.findById(idRol).orElse(null);
    }

    @Override
    public void delete(Integer idRol) {
        rol.deleteById(idRol);
        
    }
    
}
