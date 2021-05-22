package br.com.loja.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import br.com.loja.classeConcretas.Cliente;
import br.com.loja.classeConcretas.Empresa;
import br.com.loja.classeConcretas.Endereco;
import br.com.loja.classeConcretas.Pedido;
import br.com.loja.classeConcretas.Produto;
import br.com.loja.conexaoDados.ConnectionFactory;
import br.com.loja.controller.CodigoProduto;
import br.com.loja.enumpoo.Categoria;
import br.com.loja.enumpoo.FormaDePagamento;

public class LojaMain {

	public static void main(String[] args) {
	

		Produto microondas = new Produto("Brastempe 210Lt", Categoria.FRETE_GRATIS, 10, 760);
		Produto geladeira = new Produto("Eletrolux lt300", Categoria.IMPORTADOS, 20, 2700);
		Produto fogao = new Produto("Consul prata", Categoria.IMPORTADOS, 30, 75);
		Produto tv = new Produto("Tv 60Polegadas", Categoria.NACIONAIS, 10, 7000.05);
		Produto batedeira = new Produto("Lg 600whats", Categoria.PROMOCAO, 10, 560);
		Produto processadorLegumes = new Produto("Consul 600whats", Categoria.PROMOCAO, 20, 300);
		Produto filtro = new Produto("Filtro pequeno porte", Categoria.IMPORTADOS, 30, 100);
		Produto smarttv = new Produto("Tv xiomi 60Polegadas", Categoria.IMPORTADOS, 10, 5000.0);
		//public Cliente(String nome, String email, String celular
		//, String cep, String rua, int numero, String bairro, String cidade)
		
		Cliente c1 = new Cliente("Fred", "fred@lopes", "123456", "098765", "Rua luis noget", 1, "Sao pedro", "Tere" );
		Cliente c2 = new Cliente("Lucas", "lucas@lopes", "1654456", "098765", "Rua  noget", 2, "varzea", "Tere" );
		Cliente c3 = new Cliente("Paty", "paty@lopes", "4563456", "778765", "Rua Goitacases", 1, "Jardim meudon", "Tere" );
		Cliente c4 = new Cliente("Maria", "Maria@lopes", "156756", "7765", "Rua  noget Jr", 2, "Rosario", "Tere" );
		
		// (String nome, String cep, String rua, int numero, String bairro, String cidade)
		
		Empresa Eletro = new Empresa("Eletro Plus", "0987654", "Rua jose de Lima jr.", 12, "Copacabana", "Rio de janeiro");
		
		//Pedido(Cliente cliente, LocalDate data)
		
		
				Pedido nP= new Pedido(c1, LocalDate.of(2021,05,10));
				Eletro.novaVenda(nP);
				nP.adicionarProduto(microondas);
				nP.adicionarProduto(geladeira);
				nP.adicionarProduto(fogao);
				nP.adicionarProduto(smarttv);
				
				nP.fecharPedido(FormaDePagamento.CARTAO_DE_CREDITO);
				//-----------------------------------------------------------------------------------------
				Pedido nP2= new Pedido(c2, LocalDate.of(2021,05,11));
				Eletro.novaVenda(nP2);
				nP2.adicionarProduto(microondas);
				nP2.adicionarProduto(processadorLegumes);
				
				nP2.fecharPedido(FormaDePagamento.BOLETO);
				//-----------------------------------------------------------------------------------------
				Pedido nP3= new Pedido(c3, LocalDate.of(2021,05,12));
				Eletro.novaVenda(nP3);
				nP3.adicionarProduto(smarttv);
				nP3.adicionarProduto(batedeira);
				
				nP3.fecharPedido(FormaDePagamento.BOLETO);
				//------------------------------------------------------------------------------------------
				Pedido nP4= new Pedido(c4, LocalDate.of(2021,05,13));
				Eletro.novaVenda(nP4);
				nP4.adicionarProduto(filtro);
				nP4.adicionarProduto(fogao);
				nP4.adicionarProduto(processadorLegumes);
				nP4.adicionarProduto(tv);
				
				
				nP4.fecharPedido(FormaDePagamento.PIX);
			
				
				
				Eletro.notaFiscal(c4);
				System.out.println(Eletro.formaDePagamentoMaisUtilizada());
				System.out.println(Eletro.somaPorFormaDePagamento());
				System.out.println(Eletro.valorNoPeriodo(LocalDate.of(2021,05,10),LocalDate.of(2021,05,12)));
				System.out.println(Eletro.totalVendido());
		
		
	}

}
