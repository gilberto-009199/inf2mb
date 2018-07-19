package br.senai.jandira.test;

import java.sql.Connection;

import br.senai.jandira.dao.UsuarioDAO;
import br.senai.jandira.jdbc.Conexao;
import br.senai.jandira.model.Usuario;

public class Test {
	public static void main(String [] args){
		Usuario userteste=new Usuario();
		userteste.setNome("teste3274");
		userteste.setEmail("teste3274@mail.org");
		userteste.setSenha("teste");
		userteste.setCidade("Jandira");
		userteste.setDtNasc("25/10/1999");
		
		new UsuarioDAO(userteste).gravar();
		
	}
}
