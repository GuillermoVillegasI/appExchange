package com.appExchange.exchange.servicios;

import com.appExchange.exchange.entidades.Billetera;
import com.appExchange.exchange.entidades.Usuario;
import com.appExchange.exchange.errores.ErrorServicio;
import com.appExchange.exchange.repositorios.BilleteraRepositorio;
import com.appExchange.exchange.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    BilleteraRepositorio billeteraRepositorio;

    @Autowired
    BilleteraServicio billeteraServicio;

    public Usuario buscarPorId(Integer id) throws ErrorServicio {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            return usuario;
        } else {
            throw new ErrorServicio("NO EXISTE ESE USUARIO");
        }
    }

    public ArrayList<Usuario> listarUsuarios() {
        return (ArrayList<Usuario>) usuarioRepositorio.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario) {

        return usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(Integer id) throws ErrorServicio {
        Optional<Usuario> usuarioRespuesta = usuarioRepositorio.findById(id);
        List<Billetera> billeteraRespuesta = billeteraRepositorio.buscarPorUsuario(id);
         if (usuarioRespuesta.isPresent()) {
            if (billeteraRespuesta.isEmpty()) {
                usuarioRepositorio.deleteById(usuarioRespuesta.get().getId());
            }else{
                throw new ErrorServicio("ERROR ! La usuario tiene una o mas Billeteras asignadas ");
            }                
        } else {
            throw new ErrorServicio(" No se encontro el usuario ");
        }
    }

}
