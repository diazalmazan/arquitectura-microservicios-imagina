package com.imagina.solid_solved.srp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacturaService {

    private CalculaImpuestosService calculaImpuestosService = new CalculaImpuestosService();

    public void generarFactura(Factura factura) {
        // Calcular impuestos
        double impuestos = calculaImpuestosService.calcularImpuestos(factura);
        factura.setTotal(factura.getTotal() + impuestos);

        // Guardar en la base de datos
        guardarEnBaseDatos(factura);

        // Enviar notificación por correo electrónico
        enviarNotificacion(factura);

        log.info("Factura generada");
    }



    private void guardarEnBaseDatos(Factura factura) {
        // Lógica para guardar en base de datos
        log.info("Almacenando factura en la base de datos");
    }

    private void enviarNotificacion(Factura factura) {
        // Lógica para enviar un correo electrónico
        log.info("Enviando correo electronico con la factura");
    }
}
