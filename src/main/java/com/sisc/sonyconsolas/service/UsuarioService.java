package com.sisc.sonyconsolas.service;

import java.util.List;

import com.sisc.sonyconsolas.model.Usuario;


public interface UsuarioService {
    public List<Usuario> findAll();
    public void save (Usuario usu);
    public Usuario findOne(Integer idUsuario);
    public void delete (Integer idUsuario);
}
