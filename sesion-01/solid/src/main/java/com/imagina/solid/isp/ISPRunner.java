package com.imagina.solid.isp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

//@Component
@Slf4j
public class ISPRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("===========================================");
        log.info("Ejecutando ISP Runner");

        Coche coche = new Coche();
        coche.conducir();
        coche.volar();

        log.info("===========================================");
    }
}
