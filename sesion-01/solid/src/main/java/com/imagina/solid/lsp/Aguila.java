package com.imagina.solid.lsp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Aguila extends Pajaro {

    @Override
    public void comer() {
        log.info("Puedo comerme una cabra.");
    }

    @Override
    public void volar() {
        log.info("Puedo volar desde un acantilado.");
    }
}
