package br.senai.jandira.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection conet;
	
	public static Connection getConexao(){
		
		try{
			
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			
			String server = new String("10.107.134.3:3306");
			String database = new String("agenda?useSSL=false");//?useSSL=false  pois nos n estamos usando ssl no nosso computador então ele da uma menssagem pois o servidro possui mas o computador não!
			String user = new String("root");
			String password = new String("bcd127");
			
			conet = DriverManager.getConnection("jdbc:mysql://"+ server+"/"+database,user,password);
			System.out.println("Banco conectado com sucesso");
			//System.out.println(" A conexão com o banco foi bem sucedida!");	 
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Erro ao conectar ao banco: "+e.getMessage());
		}
		
		return conet;
	}

}
