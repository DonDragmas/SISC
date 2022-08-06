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

import com.sisc.sonyconsolas.model.Rol;
import com.sisc.sonyconsolas.service.RolService;

@RequestMapping (value = "/rol")
@SessionAttributes ("rol")
@Controller

public class RolController {
    @Autowired
    private RolService rolU;

    @GetMapping(path ={"listarrol", "/", ""})
    public String listar(Model r){
        r.addAttribute("rol", rolU.findAll());
        return "rol/listarrol";
    }

    @GetMapping("verR")
    public String verR(Model r){
        Rol ro=new Rol();
        ro.setIdRol(1);
        ro.setNombreRol("Administrador");
        ro.setFuncionRol("Contador");        
        r.addAttribute("rol", ro);
        return "rol/verR";
    }

    @GetMapping("verRol/{id}")
    public String verRol(@PathVariable Integer idRol, Model r){
        Rol rol=null;
        if(idRol>0){
            rol=rolU.findOne(idRol);
        }else{
            return "redirect:listarrol";
        }
        r.addAttribute("rol", rol);
        r.addAttribute("accion", "Actualizar Rol");
        return "rol/formRl";
    }

    @GetMapping("/formRl")
    public String form (Model r){
        Rol rol=new Rol();
        r.addAttribute("rol", rol);
        r.addAttribute("accion", "Agregar Rol");
        return "rol/formRl";
    }

    @PostMapping("/addR")
    public String addR(@Valid Rol ro, BindingResult res, Model r, SessionStatus status){
        if(res.hasErrors()){
            return "rol/formRl";
        }
        rolU.save(ro);
        status.setComplete();
        return "redirect:listarrol";
    }

    @GetMapping("deleteR/{id}")
    public String deleterU(@PathVariable Integer idRol){
        if(idRol>0){
            rolU.delete(idRol);
        }

        return "redirect:/rol/listarrol";
    }
   
}
