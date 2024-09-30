package com.imagina.solid_solved.dip;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RepositorioDePedidosMongo {

    public void guardar(Pedido pedido) {
        log.info("Guadando el pedido {} en una base de datos Mongo", pedido.getNombre());
    }
}
