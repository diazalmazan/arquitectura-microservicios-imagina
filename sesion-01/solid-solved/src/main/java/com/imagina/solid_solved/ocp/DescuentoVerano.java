package com.imagina.solid_solved.ocp;

public class DescuentoVerano implements Descuento{
    @Override
    public double aplicaDescuento(Producto producto) {
        return producto.getPrecio() * 0.5;
    }
}
