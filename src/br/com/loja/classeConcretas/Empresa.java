package br.com.loja.classeConcretas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import br.com.loja.controller.CodigoTransacoes;
import br.com.loja.enumpoo.FormaDePagamento;

public class Empresa {
	
	private String nome;
	public final Endereco ENDERECO;
	private  Map <String, Pedido> pedidos = new HashMap<String, Pedido>();

	public Empresa(String nome, String cep, String rua, int numero, String bairro, String cidade) {
		
		this.nome = nome;
		this.ENDERECO = new Endereco ( cep, rua, numero, bairro, cidade);
	}

	public String getNome() {
		return nome;
	}

	public void notaFiscal(Cliente cliente) {
		
		this.pedidos.get(cliente.getCodigoCompra()).fazerNotaFiscal(this.nome);
	}


	public  void novaVenda(Pedido pedido) {
		
		pedidos.put(pedido.getCodigoPedido(), pedido);
		
	}
	
	public String totalVendido() {
		double soma = 0;
		for(String numero: this.pedidos.keySet()) {
			
			soma +=   this.pedidos.get(numero).valorDoBoleto();
		}
		
		return "Total das vendas R$: "+soma;
	}
	
	public String valorNoPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		double soma = 0;
		Duration dataInicio = null;
		Duration dataFim = null; 
		for(String numero: this.pedidos.keySet()) {
			dataInicio =  Duration.between(LocalDateTime.of(dataInicial, LocalTime.now()), LocalDateTime.of(this.pedidos.get(numero).getData(), LocalTime.now()));
			 dataFim  = Duration.between(  LocalDateTime.of(dataFinal, LocalTime.now()),LocalDateTime.of(this.pedidos.get(numero).getData(), LocalTime.now()));

			 if(dataInicio.toDays() >= 0 && dataFim.toDays() <= 0 ) {
				
				soma += this.pedidos.get(numero).valorDoBoleto();
			}
			
		}
		
		
		return "Total das vendas no periodo R$: "+ soma;
		
	}
	
	public String formaDePagamentoMaisUtilizada() {
		int credito = 0;
		int debito = 0;
		int picPay = 0;
		int pix = 0;
		int boleto = 0;
		String pagamentosMaisUtilizados = "\n";
		FormaDePagamento[] tipoPagamento = {FormaDePagamento.CARTAO_DE_CREDITO,FormaDePagamento.CARTAO_DE_DEBITO,
				FormaDePagamento.PIC_PAY,FormaDePagamento.PIX,FormaDePagamento.BOLETO};
		for(String numero: this.pedidos.keySet()) {
			
			switch( this.pedidos.get(numero).getFormaPgo()){
			
			case CARTAO_DE_CREDITO:
				credito++;
				break;
			case CARTAO_DE_DEBITO:
				debito++;
				break;
			case PIC_PAY:	
				picPay++;
				break;
			case PIX:
				pix++;
				break;
			case BOLETO:
				boleto++;
				break;
			}
		}
		
		
		 int [] valores = {credito, debito, picPay, pix, boleto};
		 int maiorValor = 0;
		 for(int i = 0; i < valores.length; i++) {
			 if(maiorValor < valores[i]) {
				 maiorValor = valores[i];
			 }
		 }
		 
		 for(int i = 0; i < valores.length; i++) {
               if(maiorValor == valores[i]) {
            	  
            	   pagamentosMaisUtilizados +=  tipoPagamento[i] + "\n";
               }
		 }
		
		return "Tipo de pagamento mais utilizado " + pagamentosMaisUtilizados;
	}
	
	@Override
	public String toString() {
		return "Empresa: " + nome + ", endereço=" + ENDERECO;
	}

	public String somaPorFormaDePagamento() {
		double credito = 0;
		double debito = 0;
		double picPay = 0;
		double pix = 0;
		double boleto = 0;
		for(String numero: this.pedidos.keySet()) {
			
			switch( this.pedidos.get(numero).getFormaPgo()){
			
			case CARTAO_DE_CREDITO:
				credito +=  this.pedidos.get(numero).valorDoBoleto();
				break;
			case CARTAO_DE_DEBITO:
				debito+=  this.pedidos.get(numero).valorDoBoleto();
				break;
			case PIC_PAY:	
				picPay+=  this.pedidos.get(numero).valorDoBoleto();
				break;
			case PIX:
				pix+=  this.pedidos.get(numero).valorDoBoleto();
				break;
			case BOLETO:
				boleto+=  this.pedidos.get(numero).valorDoBoleto();
				break;
			}
		}
		
		String valoresDosPagamentos = "Total por tipo de pagamento: \n"+ FormaDePagamento.CARTAO_DE_CREDITO + " R$ " + credito + "\n"+
				FormaDePagamento.CARTAO_DE_DEBITO + " R$ " + debito  + "\n"+	
				FormaDePagamento.PIC_PAY + " R$ " + picPay  + "\n"+
				FormaDePagamento.PIX + " R$ " + pix  + "\n"+
				FormaDePagamento.BOLETO + " R$ " + boleto ;
		 
		
		return valoresDosPagamentos;
	}
	
	
	
	
	
	
	
}
