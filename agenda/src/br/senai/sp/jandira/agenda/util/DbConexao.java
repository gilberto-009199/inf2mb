package br.senai.sp.jandira.agenda.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DbConexao {
		
	private static Connection conet;
		
	public static Connection abrirConexao(){
		conet = null;
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			File banco=new File("./bancoagenda.accdb");
			if (!banco.exists()) {
				JOptionPane.showMessageDialog(null, " Erro arquivo não encontrado");
			}
			conet = DriverManager.getConnection("jdbc:ucanaccess://"+ banco.toString());
			System.out.println(" A conexão com o banco foi bem sucedida!");			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, " Erro ao conectar ao banco: "+e.getMessage());
			System.out.println("Erro ao conectar ao banco: "+e.getMessage());
		}
		
		return conet;
	}
	
}
