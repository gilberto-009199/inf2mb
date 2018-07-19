package br.senai.jandira.model;

public class Usuario {
	private int id;
	private String nome;
	private String senha;
	private String cidade;
	private String DtNasc;
	private String Email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getDtNasc() {
		return DtNasc;
	}
	public void setDtNasc(String dtNasc) {
		DtNasc = dtNasc;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
}
