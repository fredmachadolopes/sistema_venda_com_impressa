package br.com.loja.classeConcretas;

public class Cliente {
	
	private String nome;
	private String email;
	private String celular;
	private Endereco endereco;
	private String codigoCompra;
	public Cliente(String nome, String email, String celular
			, String cep, String rua, int numero, String bairro, String cidade) {
		
		this.nome = nome;
		this.email = email;
		this.celular = celular;
		this.endereco = new Endereco( cep,  rua,  numero,  bairro,  cidade);
		
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCelular() {
		return celular;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void codigoCompra(String codigoPedido) {

		this.codigoCompra = codigoPedido;
		
	}
	public String getCodigoCompra() {
		return codigoCompra;
	}
	@Override
	public String toString() {
		return "Cliente: " + nome + "\ncelular: " + celular + "\nendereco: " + endereco;
	}

	
	
}
