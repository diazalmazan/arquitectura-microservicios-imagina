package com.imagina.solid.ocp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

@Slf4j
//@Component
public class OCPRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("===========================================");
        log.info("Ejecutando OCP Runner");
        var calculadoraPrecios = new CalculadoraPrecios();
        Producto astroBot = new Producto();
        astroBot.setPrecio(30.0);
        Producto zapatillas = new Producto();
        zapatillas.setPrecio(50.0);

        log.info("El precio actual de Astro Bot es {}", astroBot.getPrecio());
        log.info("Calculando precio para Astro Bot con descuento de BLACKFRIDAY");
        var precioDescuentoBF = calculadoraPrecios.calcularPrecio(astroBot, "BLACKFRIDAY");
        log.info("El precio tras el descuento de BLACKFRIDAY es: {}", precioDescuentoBF);

        log.info("El precio actual de zapatillas es {}", zapatillas.getPrecio());
        log.info("Calculando precio para Zapatillas con descuento de NAVIDAD");
        var precioDescuentoNV = calculadoraPrecios.calcularPrecio(zapatillas, "NAVIDAD");
        log.info("El precio tras el descuento de NAVIDAD es: {}", precioDescuentoNV);

        log.info("===========================================");
    }
}
