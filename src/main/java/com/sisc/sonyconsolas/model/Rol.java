package com.sisc.sonyconsolas.model;


import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table (name = "Rol")
public class Rol {

    //variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer idRol;

    @NotEmpty
    @Column(name = "nombreRol", length = 50, nullable=false)
    @Size (min=2, max=50)
    private String nombreRol;

    @NotEmpty
    @Column(name = "funcionRol", length = 50, nullable=false)
    @Size (min=2, max=50)
    private String funcionRol;

    //constructores

    public Rol() {
    }

    public Rol(Integer idRol, @NotEmpty @Size(min = 2, max = 50) String nombreRol,
            @NotEmpty @Size(min = 2, max = 50) String funcionRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.funcionRol = funcionRol;
    }

    //Getters y Setters

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getFuncionRol() {
        return funcionRol;
    }

    public void setFuncionRol(String funcionRol) {
        this.funcionRol = funcionRol;
    }   
}
