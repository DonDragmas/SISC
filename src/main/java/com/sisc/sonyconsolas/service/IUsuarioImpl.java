package com.sisc.sonyconsolas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisc.sonyconsolas.model.IUsuario;
import com.sisc.sonyconsolas.model.Usuario;

@Service
public class IUsuarioImpl implements UsuarioService {

    @Autowired
    private IUsuario usuarioAl;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioAl.findAll();  
    }

    @Override
    public void save(Usuario usu) {
        usuarioAl.save(usu);
    }

    @Override
    public Usuario findOne(Integer idUsuario) {
        return usuarioAl.findById(idUsuario).orElse(null);
    }

    @Override
    public void delete(Integer idUsuario) {
        usuarioAl.deleteById(idUsuario);
    }

  
}
