package br.senai.sp.jandira.academiaSenai.dao;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.senai.sp.jandira.academiaSenai.model.Client;
import br.senai.sp.jandira.academiaSenai.util.DbConexao;

public class ClientDAO {

	private Client client;
	private PreparedStatement stn = null;
	private ResultSet rts = null;

	public ClientDAO(Client contato) {
		this.client = contato;
	}

	public ClientDAO() {
	};

	public void setClient(Client contato) {
		this.client = contato;
	}

	public Client getClient(int id) {
		PreparedStatement stn = null;
		ResultSet rts = null;
		String query = "SELECT Nome,DtNasc,NvAtividade,Sexo,Peso,Altura FROM Clientes WHERE id=?;";
		Client userTemp = new Client();
		userTemp.setId(id);
		try {

			stn = DbConexao.abrirConexao().prepareStatement(query);
			stn.setInt(1, id);
			rts = stn.executeQuery();

			while (rts.next()) {

				userTemp.setName(rts.getString("Nome"));

				userTemp.setActivity(rts.getString("NvAtividade"));

				userTemp.setSex((rts.getString("Sexo").charAt(0)));
				userTemp.setHeight((rts.getInt("Altura")));
				userTemp.setWeight((rts.getInt("Peso")));

				userTemp.setBirth(rts.getDate("DtNasc"));

			}
			rts.close();
			DbConexao.abrirConexao().close();

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Ocorreu um erro " + e.getMessage());
		}

		return userTemp;
	}

	public boolean gravar() {

		PreparedStatement stn = null;
		String sql = "insert into Clientes(Nome,Sexo,DtNasc,Peso,Altura,NvAtividade" + ")values(?,?,?,?,?,?);";

		try {

			stn = DbConexao.abrirConexao().prepareStatement(sql);
			// data ano-mes-dia:::
			stn.setString(1, client.getName());
			stn.setString(2, client.getSex() + "");

			stn.setTimestamp(3, new java.sql.Timestamp(client.getBirth().getTime()));

			stn.setInt(4, client.getWeight());
			
			stn.setDouble(5, client.getHeight());// passando altura em metros para cm novamente
													
			stn.setString(6, client.getActivity());
			stn.execute();
			stn.close();

			DbConexao.abrirConexao().close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao gravar: " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean atualizar() {
		PreparedStatement stn = null;
		String sql = "UPDATE Clientes SET Nome=?,Sexo=?,DtNasc=?,Peso=?,Altura=?,NvAtividade=? WHERE ID=?;";

		try {
			stn = DbConexao.abrirConexao().prepareStatement(sql);

			stn.setString(1, client.getName());
			stn.setString(2, client.getSex() + "");
			stn.setTimestamp(3, new java.sql.Timestamp(client.getBirth().getTime()));
			stn.setInt(4, client.getWeight());
			stn.setDouble(5, client.getHeight());// passando altura em metros
													// (1,**)
			stn.setString(6, client.getActivity());
			stn.setInt(7, client.getId());
			stn.execute();

			DbConexao.abrirConexao().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean excluir() {
		String query = "DELETE FROM Clientes WHERE ID=?;";

		try {
			stn = DbConexao.abrirConexao().prepareStatement(query);
			stn.setInt(1, client.getId());
			stn.execute();
			DbConexao.abrirConexao().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public ArrayList<Client> getClients() {

		ArrayList<Client> clientes = new ArrayList<>();
		stn = null;
		rts = null;
		String sql = "SELECT*FROM Clientes ORDER BY nome;";
		try {
			stn = DbConexao.abrirConexao().prepareStatement(sql);
			rts = stn.executeQuery();
			while (rts.next()) {

				Client userTemp = new Client();

				userTemp.setId(rts.getInt("id"));
				userTemp.setName(rts.getString("Nome"));
				userTemp.setSex(rts.getString("Sexo").charAt(0));
				userTemp.setBirth(rts.getDate("DtNasc"));
				userTemp.setWeight(rts.getInt("Peso"));
				userTemp.setHeight(rts.getDouble("Altura"));
				userTemp.setActivity(rts.getString("NvAtividade"));
				clientes.add(userTemp);
			}
			rts.close();
			DbConexao.abrirConexao().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientes;
	}
	public ArrayList<Client> SearchClients(String Nome) {

		ArrayList<Client> clientes = new ArrayList<>();
		stn = null;
		rts = null;
		String sql = "SELECT*FROM Clientes WHERE Nome LIKE ?";
		try {
			stn = DbConexao.abrirConexao().prepareStatement(sql);
			stn.setString(1, "%"+Nome+"%");
			rts = stn.executeQuery();
			while (rts.next()) {

				Client userTemp = new Client();

				userTemp.setId(rts.getInt("id"));
				userTemp.setName(rts.getString("Nome"));
				userTemp.setSex(rts.getString("Sexo").charAt(0));
				userTemp.setBirth(rts.getDate("DtNasc"));
				userTemp.setWeight(rts.getInt("Peso"));
				userTemp.setHeight(rts.getDouble("Altura"));
				userTemp.setActivity(rts.getString("NvAtividade"));
				clientes.add(userTemp);
			}
			rts.close();
			DbConexao.abrirConexao().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clientes;
	}
}
