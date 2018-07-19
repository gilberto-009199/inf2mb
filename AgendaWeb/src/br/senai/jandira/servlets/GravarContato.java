package br.senai.jandira.servlets;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.server.RemoteCall;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.jandira.dao.ContatoDAO;
import br.senai.jandira.model.Contato;
import sun.rmi.server.Dispatcher;

@WebServlet("/GravarContato")
public class GravarContato extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public GravarContato() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contato c = new Contato();
		c.setNome(request.getParameter("txtNome"));
		c.setEmail(request.getParameter("txtEmail"));
		c.setDtNasc(request.getParameter("txtDtNasc"));
		c.setSexo(request.getParameter("cbSexo"));
		c.setTelefone(request.getParameter("txtTelefone"));
		c.setCelular(request.getParameter("txtCelular"));
		c.setLogradouro(request.getParameter("txtLogradouro"));
		c.setBairro(request.getParameter("txtbBairro"));
		c.setCidade(request.getParameter("txtCidade"));
		c.setEstado(request.getParameter("txtEstado"));
		c.setCep(request.getParameter("txtCep"));
		
		c.setIdUsuario(Integer.parseInt( request.getParameter("idUsuario")));
		
		
		ContatoDAO cDAO = new ContatoDAO(c);
		
		RequestDispatcher rd;
		
		if(cDAO.gravarContato()){
			rd = request.getRequestDispatcher("index.jsp");
		}else{
			rd = request.getRequestDispatcher("codastrar_contato.jsp");
		}
		rd.forward(request, response);
	}

}
