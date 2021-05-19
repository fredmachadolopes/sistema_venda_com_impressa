package br.com.loja.controller;

import java.util.HashMap;
import java.util.Map;

import br.com.loja.classeConcretas.Pedido;

public abstract class Pedidos {
	
	private static Map <String, Pedido> pedidos = new HashMap<String, Pedido>();
	
	public static void novaCompra(Pedido pedido) {
		pedidos.put(CodigoTransacoes.gerarCodigo(), pedido);
	}
}
