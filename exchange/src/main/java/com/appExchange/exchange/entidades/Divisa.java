
package com.appExchange.exchange.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Divisa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    
    @Column(length = 25 , nullable = false , unique = true)
    private String nombre ;
    private float valor ;

    public Divisa() {
    }
    
    
    public Divisa(Integer id, String nombre, float valor) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
    }

    public Divisa(String nombre, float valor) {
        this.nombre = nombre;
        this.valor = valor;
       
    }

    public Divisa(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }


    @Override
    public String toString() {
        return "Divisa{" + "id=" + id + ", nombre=" + nombre + ", valor=" + valor + ", billetera=" + '}';
    }
    
    
    
}
