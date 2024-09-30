package com.imagina.solid.srp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

//@Component
@Slf4j
public class SRPRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("===========================================");
        log.info("Ejecutando SRP Runner");
        var facturaService = new FacturaService();
        Factura factura = new Factura();
        factura.setTotal(100.0);
        facturaService.generarFactura(factura);
        log.info("===========================================");
    }
}
