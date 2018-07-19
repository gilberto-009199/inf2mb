package br.senai.jandira.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.senai.jandira.jdbc.Conexao;
import br.senai.jandira.model.Usuario;

public class UsuarioDAO {
	private Usuario user;
	private PreparedStatement stn;
	private ResultSet rts;
	
	public void setUsuario( Usuario user){
		this.setUser(user);
	}
	public UsuarioDAO(Usuario user){
		this.setUser(user);
	}
	public UsuarioDAO(){
		setUser(null);
	}
	public Usuario getUsuario(){
		Usuario userTemp=null;
		
		return userTemp;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public boolean gravar(){
		boolean op	=	true;
		stn=null;
		rts=null;
		String sql = "INSERT INTO usuarios (nome,email,senha,cidade,dtNasc)VALUES(?,?,?,?,?);";
		try{
			stn = Conexao.getConexao().prepareStatement(sql);
			stn.setString(1, user.getNome());
			stn.setString(2, user.getEmail());
			stn.setString(3, user.getSenha());
			stn.setString(4, user.getCidade());
			stn.setString(5, user.getDtNasc());
			stn.execute();			
			
		}catch (Exception e) {
			e.printStackTrace();
			op=false;
		}
		
		
		return op;
	}
	public Usuario autenticar( String email, String senha){
		Usuario userTemp=null;
		stn=null;
		rts=null;
		String sql = "SELECT * FROM usuarios WHERE email=? AND senha=?;";
		try {
			stn = Conexao.getConexao().prepareStatement(sql);
			stn.setString(1, email);
			stn.setString(2, senha);
			rts = stn.executeQuery();
			if(rts.next()){
				userTemp= new Usuario();
				System.out.println("Usuario encontrado!");
				userTemp.setId(rts.getInt("id"));
				userTemp.setNome(rts.getString("nome"));
				userTemp.setSenha(rts.getString("senha"));
				userTemp.setEmail(rts.getString("email"));
				userTemp.setDtNasc(rts.getString("dtNasc"));
				userTemp.setCidade(rts.getString("Cidade"));
				
			}else{
				System.out.println("Erro: Usuario Desencontrado!kkk ");
			}
			stn.close();
		} catch (SQLException e) {
			System.out.println("Erro na instrução SQL "+sql+"\n");
			System.out.println("Erro: "+e.getMessage());
		}catch(Exception e){
			System.out.println("Erro Desconhecido: "+e.getMessage());
		}
		
		
		
		return userTemp;
	}
	
}
