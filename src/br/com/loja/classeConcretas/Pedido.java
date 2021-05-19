package br.com.loja.classeConcretas;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.loja.enumpoo.FormaDePagamento;

public class Pedido {
	
	private LocalDate data;
	private List<Produto> listaDeProdutos = new ArrayList<Produto>();
	private Cliente cliente;
	private double valorFrete = Math.round(10 + (5 * Math.random()));
	private double desconto;
	private FormaDePagamento formaPgo;
	private double valorTotal;
	public Pedido(Cliente cliente, LocalDate data) {
		this.data = data;
		this.cliente = cliente;						
	}
	
	public void adicionarProduto(Produto produto) {
		listaDeProdutos.add(produto);
	}
	
	public double valorDoPedido() {
		
		if(this.data.getDayOfWeek().getValue() == 7) {
			for (Produto produto : listaDeProdutos) {
				 produto.setDesconto(0.9);
			}
		}
		for (Produto produto : listaDeProdutos) {
			this.valorTotal += produto.getValor() * produto.getDesconto();
		}

		return this.valorTotal;
	}
	
	public void facharPedido(FormaDePagamento formaPgo) {
		this.formaPgo = formaPgo;
		if(formaPgo.equals(FormaDePagamento.CARTAO_DE_CREDITO) || formaPgo.equals(FormaDePagamento.PIC_PAY)) {
			this.desconto = .02;
		}else if(formaPgo.equals(FormaDePagamento.CARTAO_DE_DEBITO) || formaPgo.equals(FormaDePagamento.PIX)) {
			this.desconto = .05;
		}else if(formaPgo.equals(FormaDePagamento.BOLETO)){
			this.desconto = .01;
		}else {
			this.desconto = .0;
		}
		 
	
	}
	
	public void fazerNotaFiscal() {
		
		try {
			FileOutputStream fos = new FileOutputStream("notaFila.txt");
			Writer ros = new OutputStreamWriter(fos);
			BufferedWriter escrever = new BufferedWriter(ros);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
