package br.com.loja.classeConcretas;

public class Endereco {
	
	private String cep;
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String complemento;
	private String referencia;
	public Endereco(String cep, String rua, int numero, String bairro, String cidade
			) {
		
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;

	}
	
	public String getCep() {
		return cep;
	}
	public String getRua() {
		return rua;
	}
	public int getNumero() {
		return numero;
	}
	public String getBairro() {
		return bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public String getComplemento() {
		return complemento;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	

}
