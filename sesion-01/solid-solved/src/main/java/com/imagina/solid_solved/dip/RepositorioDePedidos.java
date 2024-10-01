package com.imagina.solid_solved.dip;

public interface RepositorioDePedidos {

    public void guardar(Pedido pedido);
    Pedido findPedidoById(Long id);
}
