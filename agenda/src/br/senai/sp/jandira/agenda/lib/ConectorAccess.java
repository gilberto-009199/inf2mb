package br.senai.sp.jandira.agenda.lib;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConectorAccess {
	private Connection conet;

	private Statement stm;

	private ResultSet rs;

	private File fileconector;

	public Connection getConet() {
		return conet;
	}

	public void setConet(Connection conet) {
		this.conet = conet;
	}

	public Statement getStm() {
		return stm;
	}

	public void setStm(Statement stm) {
		this.stm = stm;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public File getFileconector() {
		return fileconector;
	}

	public void setFileconector(File fileconector) {
		this.fileconector = fileconector;
	}

	public boolean VerificaDriver() {
		if (!fileconector.exists()) {
			JOptionPane.showMessageDialog(null, " erro arquivo não encontrado");
			return false;
		} else {
			return true;
		}
	}

	public void Conetar() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			conet = DriverManager.getConnection("jdbc:ucanaccess://" + fileconector.toString());

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet query(String sql) {
		// criando statemente tansporta os dados par ao banco
		try {
			
		stm = conet.createStatement();
		rs = stm.executeQuery(sql);
		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Um erro ocorreu durante o a execução do sql: ("+sql+")erro:"+e.getMessage());
		}
		return rs;
	}
	public void Desconectar(){
		try {
			stm.close();
			rs.close();
			conet.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Um erro ocorreu durante o fechamento da sessão: "+e.getMessage());
		}
		
	}

}
