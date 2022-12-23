package com.appExchange.exchange.repositorios;

import com.appExchange.exchange.entidades.Billetera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BilleteraRepositorio extends JpaRepository<Billetera, Integer> {

    @Query("SELECT b FROM Billetera b WHERE b.usuario.id LIKE :id")
    public List<Billetera> buscarPorUsuario(@Param("id")Integer id);
}
