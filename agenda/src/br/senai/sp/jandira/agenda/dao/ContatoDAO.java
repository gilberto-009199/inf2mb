package br.senai.sp.jandira.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.agenda.model.Contato;
import br.senai.sp.jandira.agenda.util.DbConexao;

public class ContatoDAO {

	private Contato contato;
	private PreparedStatement stn = null;
	private ResultSet rts = null;

	public ContatoDAO(Contato contato) {
		this.contato = contato;
	}

	public ContatoDAO() {
	};

	public Contato getContato(int id) {
		PreparedStatement stn = null;
		ResultSet rts = null;
		String query = "SELECT dtNasc,endereco,celular,sexo FROM contatos where id=?;";
		Contato userTemp = new Contato();
		try {

			stn = DbConexao.abrirConexao().prepareStatement(query);
			stn.setInt(1, id);
			rts = stn.executeQuery();

			while (rts.next()) {
				// retorna os dados da tabela do BD, cada campo e um coluna.
				SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
				userTemp.setDtNac(data.format(rts.getDate("dtNasc")));
				// JOptionPane.showMessageDialog(null, userTemp.getDtNac());
				userTemp.setEndereco(rts.getString("endereco"));
				// JOptionPane.showMessageDialog(null, userTemp.getEndereco());
				userTemp.setCelular(rts.getString("celular"));
				// JOptionPane.showMessageDialog(null, userTemp.getCelular());
				userTemp.setSexo(rts.getString("sexo"));

			}
			DbConexao.abrirConexao().close();

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Ocorreu um erro " + e.getMessage());
		}

		return userTemp;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public boolean gravar() throws ClassNotFoundException {

		PreparedStatement stn = null;
		// ResultSet rts = null;
		String Sql = "insert into contatos(nome,dtNasc,endereco,telefone,celular,email,sexo)values(?,?,?,?,?,?,?);";
		 
	
		try {
			stn = DbConexao.abrirConexao().prepareStatement(Sql);
			// data ano-mes-dia:::
			stn.setString(1, contato.getNome());
			String dia = contato.getDtNac().substring(0, 2);
			String mes = contato.getDtNac().substring(3, 5);
			String ano = contato.getDtNac().substring(6, 10);
			String data = ano + "-" + mes + "-" + dia + " 00:00:00.000000";
			// JOptionPane.showMessageDialog(null, data);

			stn.setString(2, data);
			stn.setString(3, contato.getEndereco());
			stn.setString(4, contato.getTelefone());
			stn.setString(5, contato.getCelular());
			stn.setString(6, contato.getEmail());
			stn.setString(7, contato.getSexo());
			stn.execute();
			stn.close();
			DbConexao.abrirConexao().close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao gravar: " + e.getMessage());
			return false;
		}
	}

	public void atualizar() {
		PreparedStatement stn = null;
		// String sql="UPDATE contatos SET nome='',.. where ID='' ;";
		String dia = contato.getDtNac().substring(0, 2);
		String mes = contato.getDtNac().substring(3, 5);
		String ano = contato.getDtNac().substring(6, 10);
		String data = ano + "-" + mes + "-" + dia + " 00:00:00.000000";

		/*String query = "UPDATE contatos " + "SET nome='" + contato.getNome() + "',dtNasc='" + data + "',endereco='"
				+ contato.getEndereco() + "',telefone='" + contato.getTelefone() + "',celular='" + contato.getCelular()
				+ "',email='" + contato.getEmail() + "' WHERE ID='" + contato.getId() + "';";
		*/
		String Sql = "UPDATE contatos SET nome=?,dtNasc=?,endereco=?,telefone=?,celular=?,email=?,sexo=? WHERE ID=?;";
		
		try {
			stn = DbConexao.abrirConexao().prepareStatement(Sql);
			stn.setString(1, contato.getNome());
			stn.setString(2, data);
			stn.setString(3, contato.getEndereco());
			stn.setString(4, contato.getTelefone());
			stn.setString(5, contato.getCelular());
			stn.setString(6, contato.getEmail());
			stn.setString(7, contato.getSexo());
			stn.setInt(8, contato.getId());
			
			
			stn.execute();
			DbConexao.abrirConexao().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void excluir() {
		String Sql = "DELETE FROM contatos WHERE ID=?;";
		
		try {
			stn = DbConexao.abrirConexao().prepareStatement(Sql);
			stn.setInt(1, contato.getId());//id do usuario que será deletado
			stn.execute();//execute a instrução
			DbConexao.abrirConexao().close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Contato> getContatos() {

		ArrayList<Contato> contados = new ArrayList<>();
		stn = null;
		rts = null;
		String sql = "SELECT*FROM contatos ORDER BY nome;";
		try {
			stn = DbConexao.abrirConexao().prepareStatement(sql);
			rts = stn.executeQuery();
			while (rts.next()) {

				Contato userTemp = new Contato();
				userTemp.setId(rts.getInt("id"));
				userTemp.setNome(rts.getString("nome"));
				userTemp.setDtNac(rts.getString("dtNasc"));
				userTemp.setEmail(rts.getString("email"));
				userTemp.setTelefone(rts.getString("telefone"));
				userTemp.setCelular(rts.getString("celular"));
				userTemp.setSexo(rts.getString("sexo"));
				userTemp.setEndereco(rts.getString("endereco"));
				contados.add(userTemp);

			}
			DbConexao.abrirConexao().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contados;
	}
}
