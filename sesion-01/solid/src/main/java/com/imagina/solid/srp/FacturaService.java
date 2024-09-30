package com.imagina.solid.srp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacturaService {

    public void generarFactura(Factura factura) {
        // Calcular impuestos
        double impuestos = calcularImpuestos(factura);
        factura.setTotal(factura.getTotal() + impuestos);

        // Guardar en la base de datos
        guardarEnBaseDatos(factura);

        // Enviar notificación por correo electrónico
        enviarCorreo(factura);

        log.info("Factura generada");
    }

    private double calcularImpuestos(Factura factura) {
        // Lógica de cálculo de impuestos
        var impuestos = factura.getTotal() * 0.18;
        log.info("El total de impuestos es {}", impuestos);
        return impuestos;
    }

    private void guardarEnBaseDatos(Factura factura) {
        // Lógica para guardar en base de datos
        log.info("Almacenando factura en la base de datos");
    }

    private void enviarCorreo(Factura factura) {
        // Lógica para enviar un correo electrónico
        log.info("Enviando correo electronico con la factura");
    }
}
