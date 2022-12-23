package com.appExchange.exchange.servicios;

import com.appExchange.exchange.entidades.Billetera;
import com.appExchange.exchange.repositorios.BilleteraRepositorio;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilleteraServicio {

    @Autowired
    BilleteraRepositorio billeteraRepositorio;

    public Billetera buscarPorId(Integer id) throws Exception {
        Optional<Billetera> respuesta = billeteraRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Billetera billetera = respuesta.get();
            return billetera;
        } else {
            throw new Exception("NO EXISTE ESA BILLETERA");
        }
    }


    public ArrayList<Billetera> listarBilleteras() {
        return (ArrayList<Billetera>) billeteraRepositorio.findAll();
    }

    public Billetera guardarBilletera(Billetera billetera) {
        return billeteraRepositorio.save(billetera);
    }
    
    public void eliminarB (Integer id) throws Exception{
        
        Optional<Billetera> billeteraRespuesta = billeteraRepositorio.findById(id);
        if (billeteraRespuesta.isPresent()) {
            billeteraRepositorio.deleteById(billeteraRespuesta.get().getId());
        }else{
            throw new Exception(" No se encontro la billetera ");
        }
        
    }
}
