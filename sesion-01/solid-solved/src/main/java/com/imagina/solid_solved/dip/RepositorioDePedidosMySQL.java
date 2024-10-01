package com.imagina.solid_solved.dip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class RepositorioDePedidosMySQL implements RepositorioDePedidos {

    public void guardar(Pedido pedido) {
        log.info("Guadando el pedido {} en una base de datos MySQL", pedido.getNombre());
    }
}
