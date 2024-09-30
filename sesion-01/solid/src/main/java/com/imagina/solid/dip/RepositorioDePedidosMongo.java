package com.imagina.solid.dip;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RepositorioDePedidosMongo {

    public void guardar(Pedido pedido) {
        log.info("Guadando el pedido {} en una base de datos Mongo", pedido.getNombre());
    }
}
