package com.imagina.solid_solved.lsp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Avestruz extends Pajaro {

    @Override
    public void comer() {
        log.info("Puedo comer cocodrilo.");
    }

    public void volar() {
        log.info("No puedo volar.");
        throw new UnsupportedOperationException();
    }
}
