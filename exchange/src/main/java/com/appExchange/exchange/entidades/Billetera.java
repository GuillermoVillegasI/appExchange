package com.appExchange.exchange.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Billetera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private float saldo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "billetera_divisa", joinColumns = @JoinColumn(name = "billetera_id"), inverseJoinColumns = @JoinColumn(name = "divisa_id"))
    private List<Divisa> divisa ;

    public Billetera() {
    }
    
    

    public Billetera(Integer id, float saldo, Usuario usuario) {
        this.id = id;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public Billetera(List<Divisa> divisa) {
        this.divisa = divisa;
    }

    public List<Divisa> getDivisa() {
        return divisa;
    }

    public void setDivisa(List<Divisa> divisa) {
        this.divisa = divisa;
    }
        
    public Billetera(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Billetera{" + "id=" + id + ", saldo=" + saldo + ", usuario=" + usuario + '}';
    }

}
