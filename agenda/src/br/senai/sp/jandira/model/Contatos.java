package br.senai.sp.jandira.model;

public class Contatos {
	private int id;
	private String nome;
	private String dtNac;
	private String endereco;
	private String celular;
	private String email;
	public int getId()  {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDtNac() {
		return dtNac;
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
