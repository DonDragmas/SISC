package com.sisc.sonyconsolas.model;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table (name = "Usuario")
public class Usuario {

    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idUsuario;
    @NotEmpty
    @Column(name = "CorreoUsuario", length = 50, nullable=false)
    @Size(min=2, max=50)
    private String CorreoUsuario;

    @NotEmpty
    @Column(name = "ContraseñaUsuario", length = 50, nullable=false)
    @Size(min=2, max=50)
    private String ContraseñaUsuario;

    @NotEmpty
    @Column(name = "NombreRol", length = 50, nullable=false)
    @Size(min=2, max=50)
    private String NombreRolfk;

    //Constructores

    public Usuario() {
    }

    public Usuario(Integer idUsuario, @NotEmpty @Size(min = 2, max = 50) String correoUsuario,
            @NotEmpty @Size(min = 2, max = 50) String contraseñaUsuario,
            @NotEmpty @Size(min = 2, max = 50) String nombreRolfk) {
        this.idUsuario = idUsuario;
        CorreoUsuario = correoUsuario;
        ContraseñaUsuario = contraseñaUsuario;
        NombreRolfk = nombreRolfk;
    }

    //Getters y Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreoUsuario() {
        return CorreoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        CorreoUsuario = correoUsuario;
    }

    public String getContraseñaUsuario() {
        return ContraseñaUsuario;
    }

    public void setContraseñaUsuario(String contraseñaUsuario) {
        ContraseñaUsuario = contraseñaUsuario;
    }

    public String getNombreRolfk() {
        return NombreRolfk;
    }

    public void setNombreRolfk(String nombreRolfk) {
        NombreRolfk = nombreRolfk;
    }
    
}
