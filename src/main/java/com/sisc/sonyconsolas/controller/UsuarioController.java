package com.sisc.sonyconsolas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import com.sisc.sonyconsolas.model.Usuario;
import com.sisc.sonyconsolas.service.UsuarioService;



@RequestMapping (value = "/usuario")
@SessionAttributes("usuario")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioAl;

    @GetMapping(path ={"/listarU", "/", ""} )
    public String listar(Model u){
    u.addAttribute("usuario", usuarioAl.findAll() );
    return "usuario/listarU";
    }

    @GetMapping("/verU")
    public String VerU(Model u){
        Usuario usu=new Usuario();
        usu.setIdUsuario(1);
        usu.setCorreoUsuario("Daniel");
        usu.setContraseñaUsuario("danielito");
        //usu.setNombreRolfk();
        u.addAttribute("usuario", usu);
        return "usuario/verU";
    }

    @GetMapping("/verUs/{id}")
    public String verUs(@PathVariable Integer idUsuario, Model u){
        Usuario usuario=null;

        if(idUsuario>0){
            usuario=usuarioAl.findOne(idUsuario);
        }else{
            return "redirect::listarU";
        }
        u.addAttribute("usuario", usuario);
        u.addAttribute("accion", "Actualizar Usuario");
        return "usuario/formU";
    }

    @GetMapping("/formU")
    public String formU(Model u){
        Usuario usuario=new Usuario();
        u.addAttribute("usuario", usuario);
        u.addAttribute("accion", "Agregar Usuario");
        return "usuario/formU";
    }

    @PostMapping("/addU")
    public String addU(@Valid Usuario usu, BindingResult res, Model u, SessionStatus status){
        if(res.hasErrors()){
            return "usuario/formU";
        }
        usuarioAl.save(usu);
        status.setComplete();
        return "redirect:listarU";
    }

    @GetMapping("deleteU/{id}")
    public String deleterU(@PathVariable Integer idUsuario){
        if(idUsuario>0){
            usuarioAl.delete(idUsuario);
        }
        return "redirect:/usuario/listarU";
    }
   
    
}
