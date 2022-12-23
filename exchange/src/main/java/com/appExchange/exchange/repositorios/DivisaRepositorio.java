
package com.appExchange.exchange.repositorios;

import com.appExchange.exchange.entidades.Divisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisaRepositorio extends JpaRepository<Divisa, Integer> {
    
}
