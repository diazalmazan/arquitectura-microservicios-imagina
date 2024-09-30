package com.imagina.solid.dip;

public class ServicioDePedidos {

    private RepositorioDePedidosMySQL repositorio;


    public ServicioDePedidos() {
        repositorio = new RepositorioDePedidosMySQL();
    }

    public void crearPedido(Pedido pedido) {
        repositorio.guardar(pedido);
    }

}
