package com.imagina.solid_solved.dip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DIPRunner implements CommandLineRunner {

    @Autowired
    private ServicioDePedidos servicioDePedidos;

    @Override
    public void run(String... args) throws Exception {
        log.info("===========================================");
        log.info("Ejecutando DIP Runner");

        Pedido pedido = new Pedido();
        pedido.setNombre("Pizza");
        servicioDePedidos.crearPedido(pedido);

        log.info("===========================================");
    }
}
