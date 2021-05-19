package br.com.loja.classeConcretas;

public class Cliente {
	
	private String nome;
	private String email;
	private String celular;
	private Endereco endereco;
	public Cliente(String nome, String email, String celular, Endereco endereco
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
	
	
}
