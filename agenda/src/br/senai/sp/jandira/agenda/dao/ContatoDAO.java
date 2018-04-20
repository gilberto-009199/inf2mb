package br.senai.sp.jandira.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.agenda.model.Contato;
import br.senai.sp.jandira.agenda.util.DbConexao;



public class ContatoDAO {
	
	private Contato contato;
	private PreparedStatement stn = null;
	private ResultSet rts = null;
	
	public ContatoDAO(Contato contato){
		this.contato=contato;
	}
	public ContatoDAO(){};
	
	public Contato getContato() {
		return contato;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public boolean gravar() throws ClassNotFoundException{
		
		PreparedStatement stn = null;
		//ResultSet	rts	=	null;
		String	sql	=	"insert into contatos(nome,dtNac,endereco,telefone,celular,email,sexo)values(?,?,?,?,?,?,?);";

						
		try {
			stn = DbConexao.abrirConexao().prepareStatement(sql);
			//data ano-mes-dia:::
			stn.setString(1, contato.getNome());
			stn.setString(2, contato.getDtNac());
			stn.setString(3,  contato.getEndereco());
			stn.setString(4,  contato.getTelefone());
			stn.setString(5,  contato.getCelular());
			stn.setString(6,  contato.getEmail());
			stn.setString(7,  contato.getSexo());
			stn.execute();
			stn.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
			return false;
		}
	}
	public void atualizar(){
		PreparedStatement stn = null;
		ResultSet rts = null;
		String query =	"UPDATE contatos "
				+ "SET nome="+contato.getNome()+",dtNac="+contato.getDtNac()
				+ ",endereco="+contato.getEndereco()+",telefone="+contato.getTelefone()
				+ ",celular="+contato.getCelular()+",email="+contato.getEmail()
				+ " WHERE ID="+contato.getId()+";";
		
						
		try {
			stn = DbConexao.abrirConexao().prepareStatement(query);
			stn.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void excluir(){
		
	}
	public Contato getContato(int id){
		
		
		return contato;
	}
	public ArrayList<Contato> getContatos(){
		
		ArrayList<Contato> contados = new ArrayList<>();
		stn = null;
		rts = null;
		String sql ="SELECT*FROM contatos";
		try {
			stn = DbConexao.abrirConexao().prepareStatement(sql);
			rts=stn.executeQuery();
			while(rts.next())
			   {
			        //retorna os dados da tabela do BD, cada campo e um coluna.
			        Contato userTemp = new Contato();  
			        userTemp.setId(rts.getInt("id"));
			        userTemp.setNome(rts.getString("nome"));
//			        
//			        String ano = rts.getString("dtNac").substring(0, 3);
//					String mes = rts.getString("dtNac").substring(5, 7);
//					String dia = rts.getString("dtNac").substring(8, 10);
//					
			        userTemp.setDtNac(rts.getString("dtNac"));
			        
			        userTemp.setEmail(rts.getString("email"));
			        userTemp.setTelefone(rts.getString("telefone"));
			        userTemp.setCelular(rts.getString("celular"));
			        userTemp.setSexo(rts.getString("sexo"));
			        userTemp.setEndereco(rts.getString("endereco"));
			        
			        //JOptionPane.showMessageDialog(null, "user: "+userTemp.getNome());
			        
			        contados.add(userTemp);
			        DbConexao.abrirConexao().close();
			  } 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return contados;
	}
}
