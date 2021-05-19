package br.com.loja.conexaoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String url = "jdbc:postgresql://localhost:5432/postgres";
	private String login = "postgres";
	private String senha = "1F9r8e6d?";
	private Connection conexao;
	
	
	public Connection conectarPostgres() {
		try {
			
				Class.forName("org.postgresql.Driver");
				conexao = DriverManager.getConnection(url, login, senha);
				System.out.println("Conectado ao postgres ");
				return conexao;
			} catch (ClassNotFoundException e) {
				System.out.println(e);
				e.printStackTrace();
				return null;
			}catch (SQLException e) {
				System.out.println(e);
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		 
	}
	
	
	

}
