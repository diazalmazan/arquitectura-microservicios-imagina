package com.imagina.solid.isp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Coche implements Vehiculo {
    @Override
    public void conducir() {
        log.info("El coche esta conduciendo");
    }

    @Override
    public void volar() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void navegar() {
        throw new UnsupportedOperationException();
    }
}
