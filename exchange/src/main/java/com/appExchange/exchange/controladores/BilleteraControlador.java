package com.appExchange.exchange.controladores;

import com.appExchange.exchange.entidades.Billetera;
import com.appExchange.exchange.entidades.Divisa;
import com.appExchange.exchange.entidades.Usuario;
import com.appExchange.exchange.servicios.BilleteraServicio;
import com.appExchange.exchange.servicios.DivisaServicio;
import com.appExchange.exchange.servicios.UsuarioServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billetera")
public class BilleteraControlador {

    @Autowired
    private BilleteraServicio billeteraServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;
    
     @Autowired
    private DivisaServicio divisaServicio;

    //    CARGAR UNA BILLETERA >>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @PostMapping
    public Billetera guardarBilletera(@RequestParam Integer idUsuario,@RequestParam Integer idDivisa, @RequestParam float saldo ) throws Exception {

        Billetera billetera = new Billetera();
        billetera.setSaldo(saldo);
        Usuario usuario = usuarioServicio.buscarPorId(idUsuario);
        billetera.setUsuario(usuario);
        
        Divisa divisa = divisaServicio.buscarPorId(idDivisa);
        List <Divisa> divisas = new ArrayList() ;
        divisas.add(divisa);
        billetera.setDivisa(divisas);

        return billeteraServicio.guardarBilletera(billetera);

    }

    //    LISTAR BILLETERAS >>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @GetMapping()
    public ArrayList<Billetera> listarBilleteras() {
        return billeteraServicio.listarBilleteras();
    }

    //    ELIMINAR BILLETERAS >>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @GetMapping("/eliminar")
    public void eliminarBilletera (Integer id) throws Exception{
        try{
            billeteraServicio.eliminarB(id);
        }catch (Exception ex){
            throw new Exception();
        }
    }
}
