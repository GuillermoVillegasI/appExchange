package com.appExchange.exchange.controladores;

import com.appExchange.exchange.entidades.Billetera;
import com.appExchange.exchange.entidades.Divisa;
import com.appExchange.exchange.servicios.BilleteraServicio;
import com.appExchange.exchange.servicios.DivisaServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/divisa")
public class DivisaControlador {

    @Autowired
    private DivisaServicio divisaServicio;
    private BilleteraServicio billeteraServicio;


    @PostMapping
    public Divisa guardarDivisa (@RequestBody Divisa divisa){
       return divisaServicio.guardarDivisa(divisa);
    }

    @GetMapping()
    public ArrayList<Divisa> listarUsuarios() {
        return divisaServicio.listarDivisas();
    }

}
