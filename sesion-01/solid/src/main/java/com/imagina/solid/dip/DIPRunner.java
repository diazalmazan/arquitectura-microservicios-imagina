package com.imagina.solid.dip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DIPRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("===========================================");
        log.info("Ejecutando DIP Runner");

        ServicioDePedidos servicioDePedidos = new ServicioDePedidos();
        Pedido pedido = new Pedido();
        pedido.setNombre("Pizza");
        servicioDePedidos.crearPedido(pedido);

        log.info("===========================================");
    }
}
