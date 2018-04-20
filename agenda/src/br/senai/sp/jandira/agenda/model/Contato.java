package br.senai.sp.jandira.agenda.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JSpinner.DateEditor;

public class Contato {
	private int id;
	private String nome;
	private String dtNac;
	private String endereco;
	private String celular;
	private String telefone;
	private String email;
	private String sexo;
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getId()  {
		return  id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return  nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDtNac() {
		String data ="";
		
		String dia = dtNac.substring(0, 2);
		String mes = dtNac.substring(3, 5);
		String ano = dtNac.substring(6, 10);
		data= ano+"-"+mes+"-"+dia+" 00:00:00.000000";
		JOptionPane.showMessageDialog(null,data );
		return data;
	}
	public void setDtNac(String dtNac) {
		this.dtNac = dtNac;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
