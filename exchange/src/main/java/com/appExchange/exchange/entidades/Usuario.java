package com.appExchange.exchange.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60, nullable = false)
    private String nombres;

    @Column(length = 60, nullable = false)
    private String apellidos;

    @Column(length = 15, nullable = false)
    private Long dni;

    @Column(length = 60, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String sexo;

    @Column(length = 45, nullable = false)
    private String telefono;

    @Column
    @OneToMany
    @JoinColumn(name = "billetera_id")
    private List<Billetera> billetera;

    public Usuario() {
    }

    public Usuario(Integer id, String nombres, String apellidos, Long dni, String email, String sexo, String telefono, List<Billetera> billetera) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.sexo = sexo;
        this.telefono = telefono;
        this.billetera = billetera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Usuario(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni + ", email=" + email + ", sexo=" + sexo + ", telefono=" + telefono + ", billetera="  + billetera + '}';
    }

  

}
