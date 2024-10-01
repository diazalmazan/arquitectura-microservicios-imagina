package com.imagina.solid_solved.ocp;

public class DescuentoBlackFriday implements Descuento {
    @Override
    public double aplicaDescuento(Producto producto) {
        return producto.getPrecio() * 0.7;
    }
}
