package com.imagina.solid_solved.srp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculaImpuestosService {

    public double calcularImpuestos(Factura factura) {
        // Lógica de cálculo de impuestos
        var impuestos = factura.getTotal() * 0.18;
        log.info("El total de impuestos es {}", impuestos);
        return impuestos;
    }
}
