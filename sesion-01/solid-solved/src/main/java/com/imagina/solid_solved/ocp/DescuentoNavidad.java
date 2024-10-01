package com.imagina.solid_solved.ocp;

public class DescuentoNavidad implements Descuento {
    @Override
    public double aplicaDescuento(Producto producto) {
        return producto.getPrecio() * 0.9;
    }
}
