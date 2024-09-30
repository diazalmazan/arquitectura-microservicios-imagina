package com.imagina.solid_solved.ocp;

public class CalculadoraPrecios {

    public double calcularPrecio(Producto producto, String tipoDescuento) {
        if(tipoDescuento.equals("NAVIDAD")) {
            return producto.getPrecio() * 0.9;
        } else if (tipoDescuento.equals("BLACKFRIDAY")) {
            return producto.getPrecio() * 0.7;
        }
        return producto.getPrecio();
    }
}