package com.imagina.solid_solved.isp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Avion implements Vehiculo {
    @Override
    public void conducir() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void volar() {
        log.info("El avion está volando");
    }

    @Override
    public void navegar() {
        throw new UnsupportedOperationException();
    }
}
