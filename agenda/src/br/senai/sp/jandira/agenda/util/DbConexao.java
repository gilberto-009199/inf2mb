package br.senai.sp.jandira.agenda.util;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.JOptionPane;

public class DbConexao {

	private static Connection conet;

	public static Connection abrirConexao() {
		conet = null;

		try {
			JSONObject jsonObject;
			// Cria o parse de tratamento
			JSONParser parser = new JSONParser();
			jsonObject = (JSONObject) parser.parse(new FileReader("config.json"));

			// Salva nas variaveis os dados retirados do arquivo
			String arquivo = (String) jsonObject.get("arquivo");

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			File banco = new File(arquivo);

			if (!banco.exists()) {
				JOptionPane.showMessageDialog(null, " 404: Erro arquivo não encontrado ");
			} else {
				conet = DriverManager.getConnection("jdbc:ucanaccess://" + banco.toString());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, " Erro ao conectar ao banco: " + e.getMessage());
			System.out.println(" Erro ao conectar ao banco: " + e.getMessage());
		}

		return conet;
	}

}
