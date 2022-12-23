
package com.appExchange.exchange.servicios;

import com.appExchange.exchange.entidades.Divisa;
import com.appExchange.exchange.repositorios.DivisaRepositorio;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DivisaServicio {
    
    @Autowired
    private DivisaRepositorio divisaRepositorio ;
    
      public Divisa buscarPorId(Integer id) throws Exception {
        Optional<Divisa> respuesta = divisaRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Divisa divisa = respuesta.get();
            return divisa;
        } else {
            throw new Exception("NO EXISTE ESA DIVISA");
        }
    }
    
    public ArrayList<Divisa> listarDivisas(){
        return (ArrayList<Divisa>) divisaRepositorio.findAll();                
    }
    
    public Divisa guardarDivisa(Divisa divisa) {
        return divisaRepositorio.save(divisa);
    }
}
