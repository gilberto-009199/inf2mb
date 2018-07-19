package br.senai.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.classfile.ConstantObject;

import br.senai.jandira.jdbc.Conexao;
import br.senai.jandira.model.Contato;

public class ContatoDAO {
	private Contato contato;
	private PreparedStatement stn;
	private ResultSet rts;
	
	public ContatoDAO(){
		
	}
	public ContatoDAO(Contato contato){
		this.contato = contato;
	}
	
	public ArrayList<Contato> getContatos(int idUsuario){
		ArrayList <Contato> lista = new ArrayList<>();
		
		String sql="SELECT*FROM contatos WHERE idUsuario = ?";
		
		try{
		
			stn= Conexao.getConexao().prepareStatement(sql);
			stn.setInt(1, idUsuario);
			stn.executeQuery();
			rts = stn.getResultSet();
			while(rts.next()){
				Contato contatoTemp = new Contato();
				contatoTemp.setId(rts.getInt("id"));
				contatoTemp.setNome(rts.getString("nome"));
				
				contatoTemp.setDtNasc(rts.getString("dtNasc"));
				
				contatoTemp.setEmail(rts.getString("email"));
				contatoTemp.setLogradouro(rts.getString("logradouro"));
				contatoTemp.setBairro(rts.getString("bairro"));
				contatoTemp.setCidade(rts.getString("cidade"));
				contatoTemp.setEstado(rts.getString("estado"));
				contatoTemp.setCep(rts.getString("cep"));
				contatoTemp.setTelefone(rts.getString("telefone"));
				contatoTemp.setCelular(rts.getString("celular"));
				contatoTemp.setSexo(rts.getString("sexo"));
				contatoTemp.setIdUsuario(rts.getInt("idUsuario"));
				lista.add(contatoTemp);
			}
			stn.close();
		}catch (Exception e) {
			System.out.println("Erro ao operar sobre ao pegar os contatos"+e.getMessage());
		}
		
		
		
		return lista;
	}
	
	public boolean gravarContato(){
		boolean status = true;
		String sql = "INSERT INTO contatos (nome,dtNasc,email,logradouro,bairro,cidade,"
				+ " estado,cep,telefone,celular,sexo,idUsuario)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)"; //12
		try{
			stn = Conexao.getConexao().prepareStatement(sql);
			stn.setString(1,contato.getNome() );
			stn.setString(2,contato.getDtNasc() );
			stn.setString(3,contato.getEmail() );
			stn.setString(4,contato.getLogradouro() );
			stn.setString(5,contato.getBairro() );
			stn.setString(6,contato.getCidade() );
			stn.setString(7,contato.getEstado() );
			stn.setString(8,contato.getCep() );
			stn.setString(9,contato.getTelefone() );
			stn.setString(10,contato.getCelular() );
			stn.setString(11,contato.getSexo() );
			stn.setInt(12,contato.getIdUsuario() );
			stn.executeUpdate();
			Conexao.getConexao().close();
		}catch (Exception e) {
			e.printStackTrace();
			status= false;
		}
		
		
		return status;
	}
	public Contato getContato(int id){
		
		String sql="SELECT*FROM contatos WHERE id = ?";
		Contato contatoTemp = new Contato();
		try{
		
			stn= Conexao.getConexao().prepareStatement(sql);
			stn.setInt(1, id);
			stn.executeQuery();
			rts = stn.getResultSet();
			
			while(rts.next()){
				
				contatoTemp.setId(rts.getInt("id"));
				contatoTemp.setNome(rts.getString("nome"));
				
				contatoTemp.setDtNasc(rts.getString("dtNasc"));
				
				contatoTemp.setEmail(rts.getString("email"));
				contatoTemp.setLogradouro(rts.getString("logradouro"));
				contatoTemp.setBairro(rts.getString("bairro"));
				contatoTemp.setCidade(rts.getString("cidade"));
				contatoTemp.setEstado(rts.getString("estado"));
				contatoTemp.setCep(rts.getString("cep"));
				contatoTemp.setTelefone(rts.getString("telefone"));
				contatoTemp.setCelular(rts.getString("celular"));
				contatoTemp.setSexo(rts.getString("sexo"));
				contatoTemp.setIdUsuario(rts.getInt("idUsuario"));
			}
			stn.close();
		}catch (Exception e) {
			System.out.println("Erro ao operar sobre ao pegar os contatos"+e.getMessage());
		}
		
		
		return contatoTemp;
	}
}
