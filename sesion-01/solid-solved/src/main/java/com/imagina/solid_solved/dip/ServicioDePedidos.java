package com.imagina.solid_solved.dip;

public class ServicioDePedidos {

    private RepositorioDePedidosMySQL repositorio;


    public ServicioDePedidos() {
        repositorio = new RepositorioDePedidosMySQL();
    }

    public void crearPedido(Pedido pedido) {
        repositorio.guardar(pedido);
    }

}
