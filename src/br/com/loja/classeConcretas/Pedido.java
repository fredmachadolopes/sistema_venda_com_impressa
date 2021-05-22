package br.com.loja.classeConcretas;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.loja.controller.CodigoTransacoes;
import br.com.loja.enumpoo.Categoria;
import br.com.loja.enumpoo.FormaDePagamento;

public class Pedido {
	
	private LocalDate data;
	private List<Produto> listaDeProdutos = new ArrayList<Produto>();
	private Cliente cliente;
	private double valorFrete = Math.round(10 + (5 * Math.random()));
	private double descontoPorcentagem;
	private double desconto;
	private FormaDePagamento formaPgo;
	private double valorTotal;
	private String codigoPedido;
	public Pedido(Cliente cliente, LocalDate data) {
		this.data = data;
		this.cliente = cliente;	
		this.codigoPedido = CodigoTransacoes.gerarCodigo();
		this.cliente.codigoCompra(codigoPedido);
	}
	
	public void adicionarProduto(Produto produto) {
		listaDeProdutos.add(produto);
	}
	

	
	public void fecharPedido(FormaDePagamento formaPgo) {
		this.formaPgo = formaPgo;
		this.valorTotal = 0;
		if(this.data.getDayOfWeek().getValue() == 7) {
			for (Produto produto : listaDeProdutos) {
				 produto.setDesconto(0.1 * produto.getValor());
				 this.valorTotal += produto.getValor() - produto.getDesconto();
				 this.desconto += 0.1 * produto.getValor();
			}
		}else {
			
			for (Produto produto : listaDeProdutos) {
				this.valorTotal += produto.getValor() ;
				if(produto.getCategoria().equals(Categoria.FRETE_GRATIS)){
					this.valorFrete = 0;
				}
			}
		}
		if(formaPgo.equals(FormaDePagamento.CARTAO_DE_CREDITO) || formaPgo.equals(FormaDePagamento.PIC_PAY)) {
			this.descontoPorcentagem = .98;
		}else if(formaPgo.equals(FormaDePagamento.CARTAO_DE_DEBITO) || formaPgo.equals(FormaDePagamento.PIX)) {
			this.descontoPorcentagem = .95;
		}else if(formaPgo.equals(FormaDePagamento.BOLETO)){
			this.descontoPorcentagem = .99;
		}else {
			this.descontoPorcentagem = 1.0;
		}
		this.desconto += this.valorTotal -( this.valorTotal * this.descontoPorcentagem);
	//	return  this.valorTotal *= this.descontoPorcentagem;
	}
	
	public void fazerNotaFiscal(String empresa) {
		 DecimalFormat df = new DecimalFormat("#.00");
		try {
			FileOutputStream fos = new FileOutputStream("notaFiscal.txt");
			Writer ros = new OutputStreamWriter(fos);
			BufferedWriter escrever = new BufferedWriter(ros);
			
			
				escrever.write("******************Empresa: "+empresa+ " ************************");
				escrever.newLine();
				escrever.write("--------------------------------------------------------------");
				escrever.newLine();
				escrever.write(this.cliente.toString());
				escrever.newLine();
				escrever.write("--------------------------------------------------------------");
				escrever.newLine();
				int i = 1;
				for (Produto produto : listaDeProdutos) {
					escrever.write(i++ + " - "+ produto.toString());
					escrever.newLine();
				}
				escrever.write("--------------------------------------------------------------");
				escrever.newLine();
				escrever.write("Valor do frete R$: "+ Double.toString(this.valorFrete));
				escrever.newLine();
				escrever.write("Total desconto R$: "+ df.format(this.desconto));
				escrever.newLine();
				escrever.write("Total pago R$: "+ df.format(this.valorTotal += this.valorFrete - this.desconto));
				escrever.newLine();
			
				
			escrever.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public FormaDePagamento getFormaPgo() {
		return this.formaPgo;
	}

	public LocalDate getData() {
		return data;
	}

	public double valorDoBoleto() {

		return this.valorTotal;
	}


	public String getCodigoPedido() {
		return codigoPedido;
	}
	
    
}
