package br.senai.jandira.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.jandira.dao.UsuarioDAO;
import br.senai.jandira.model.Usuario;

@WebServlet("/Autentica")
public class Autentica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Autentica() {
        super();
 
    }

	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Um Usuario submeteu o foumulario de autenticação por GET");
		
	}*/

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("txtEmail");
		String password = request.getParameter("txtSenha");
		Usuario userTemp =new UsuarioDAO().autenticar(email, password);
		
		RequestDispatcher rd =null;
		
		HttpSession session = null;
		
		
		
		if(userTemp == null){
			rd = request.getRequestDispatcher("login.html");
		}else{
			rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("frase", "Seja rapido como um raio e impenetravel como a noite. Mr. "+userTemp.getNome()+"\"-\"");
			
			session = request.getSession();
			session.setAttribute("usuario",userTemp);
		}
		rd.forward(request, response);
		
	}

}
