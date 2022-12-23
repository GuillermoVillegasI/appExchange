package com.appExchange.exchange.controladores;

import com.appExchange.exchange.entidades.Billetera;
import com.appExchange.exchange.entidades.Usuario;
import com.appExchange.exchange.servicios.BilleteraServicio;
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
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;
    private BilleteraServicio billeteraServicio;

    //    CARGAR UN USUARIO >>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @PostMapping
    public Usuario guardarUsuario(@RequestParam String nombres, @RequestParam String apellidos, @RequestParam Long dni, @RequestParam String email, @RequestParam String sexo, @RequestParam String telefono) throws Exception {

        Usuario usuario = new Usuario();
        usuario.setNombres(nombres);
        usuario.setApellidos(apellidos);
        usuario.setDni(dni);
        usuario.setEmail(email);
        usuario.setSexo(sexo.toUpperCase());
        usuario.setTelefono(telefono);
        return usuarioServicio.guardarUsuario(usuario);
    }

    //    LISTAR USUARIOS >>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @GetMapping()
    public ArrayList<Usuario> listarUsuarios() {
        return usuarioServicio.listarUsuarios();
    }

    //    ELIMINAR USUARIOS >>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @GetMapping("/eliminar")
    public void eliminarUsuario(Integer id) throws Exception {
        try {
            usuarioServicio.eliminarUsuario(id);
        } catch (Exception ex) {
            throw new Exception();
        }
    }

   
}
