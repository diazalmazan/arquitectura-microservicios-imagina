package com.imagina.solid_solved.ocp;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DescuentoFactory {

    @Autowired
    private List<Descuento> descuentoList;

    public Descuento getDescuento(String descuentoType) {
        switch (descuentoType){
            case "NAVIDAD": return new DescuentoNavidad();
            default: return new DescuentoVerano();
        }
    }
}
