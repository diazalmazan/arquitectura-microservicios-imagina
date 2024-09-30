package com.imagina.solid.lsp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Pato extends Pajaro {

    @Override
    public void comer() {
        log.info("Puedo comer hamburguesas.");
    }

    @Override
    public void volar() {
        log.info("Puedo volar desde el agua.");
    }
}
