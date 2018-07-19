package br.senai.jandira.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.senai.jandira.dao.UsuarioDAO;
import br.senai.jandira.model.Usuario;

@WebServlet("/GravarUsuario")
public class GravarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GravarUsuario() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtSenha");
		String cidade = request.getParameter("txtCidade");
		String DtNasc = request.getParameter("txtDtNasc");
		Usuario userteste=new Usuario();
		userteste.setNome(nome);
		userteste.setEmail(email);
		userteste.setSenha(password);
		userteste.setCidade(cidade);
		userteste.setDtNasc(DtNasc);
		UsuarioDAO grava = new UsuarioDAO();
		grava.setUser(userteste);
		
		RequestDispatcher rd =null;
		
		
		if(grava.gravar()){
			System.out.println( "Usuario gravado!");
			rd = request.getRequestDispatcher("sucesso.html");
		}else{
			rd = request.getRequestDispatcher("novo_usuario.html");
		}
		/* Atenção vvc precisa remover a os get que vem e remver a url /gravarContato tambem */
		rd.forward(request, response);
		
	}

}
