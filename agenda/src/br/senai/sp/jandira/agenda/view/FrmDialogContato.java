package br.senai.sp.jandira.agenda.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sp.jandira.agenda.dao.ContatoDAO;
import br.senai.sp.jandira.agenda.model.Contato;
import br.senai.sp.jandira.agenda.util.DbConexao;

@SuppressWarnings("serial")
public class FrmDialogContato extends JFrame {

	private JPanel contentPane;

	public FrmDialogContato(String FormModel, Contato selecionado) {
		setDefaultCloseOperation(HIDE_ON_CLOSE);

		setTitle("Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(0, 0, 356, 50);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblContato = new JLabel("Contato");
		lblContato.setIcon(
				new ImageIcon(FrmDialogContato.class.getResource("/br/senai/sp/jandira/agenda/imagens/Contato.png")));
		lblContato.setFont(new Font("Dialog", Font.BOLD, 18));
		lblContato.setBounds(32, 12, 141, 26);
		panel.add(lblContato);

		JButton btnop = new JButton("");
		btnop.setBackground(new Color(154, 205, 50));
		btnop.setIcon(new ImageIcon(FrmDialogContato.class.getResource("/br/senai/sp/jandira/agenda/imagens/Add.png")));
		btnop.setBounds(238, 0, 118, 50);
		panel.add(btnop);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(128, 128, 128)));
		panel_1.setBounds(0, 53, 352, 286);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(31, 28, 61, 14);
		panel_1.add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(31, 53, 61, 14);
		panel_1.add(lblTelefone);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(31, 78, 61, 14);
		panel_1.add(lblEmail);

		JTextPane txtNome = new JTextPane();
		txtNome.setBounds(129, 28, 193, 20);

		panel_1.add(txtNome);

		JTextPane txtTelefone = new JTextPane();
		txtTelefone.setBounds(129, 53, 193, 20);
		panel_1.add(txtTelefone);

		JTextPane txtmail = new JTextPane();
		txtmail.setBounds(129, 78, 193, 20);
		panel_1.add(txtmail);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(31, 104, 61, 14);
		panel_1.add(lblCelular);

		JTextPane txtCelular = new JTextPane();
		txtCelular.setBounds(129, 104, 193, 20);
		panel_1.add(txtCelular);

		JTextPane txtNacimento = new JTextPane();
		txtNacimento.setBounds(163, 130, 159, 20);
		panel_1.add(txtNacimento);

		JLabel lblDataDeNacimento = new JLabel("Data de Nacimento:");
		lblDataDeNacimento.setBounds(31, 130, 114, 14);
		panel_1.add(lblDataDeNacimento);

		JLabel lblEndere = new JLabel("Endereço:");
		lblEndere.setBounds(32, 179, 96, 16);
		panel_1.add(lblEndere);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 206, 311, 69);
		panel_1.add(scrollPane);

		JTextArea textAreaEndereco = new JTextArea();
		textAreaEndereco.setLineWrap(true);
		textAreaEndereco.setWrapStyleWord(true);
		scrollPane.setViewportView(textAreaEndereco);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(31, 155, 46, 14);
		panel_1.add(lblSexo);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "M", "F" }));
		comboBox.setBounds(129, 155, 46, 20);
		panel_1.add(comboBox);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setIcon(
				new ImageIcon(FrmDialogContato.class.getResource("/br/senai/sp/jandira/agenda/imagens/exit.png")));
		btnSair.setBounds(10, 350, 95, 38);
		contentPane.add(btnSair);

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.setIcon(
				new ImageIcon(FrmDialogContato.class.getResource("/br/senai/sp/jandira/agenda/imagens/data.png")));
		btnSalvar.setBounds(241, 350, 106, 38);
		contentPane.add(btnSalvar);
		txtNome.requestFocus();
		if (FormModel.equals("add")) {
			btnop.setBackground(new Color(154, 205, 50));
			btnop.setIcon(
					new ImageIcon(FrmDialogContato.class.getResource("/br/senai/sp/jandira/agenda/imagens/Add.png")));
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					try {
						Contato usertemp = new Contato();
						usertemp.setNome(txtNome.getText());

						usertemp.setDtNac(txtNacimento.getText());
						usertemp.setEmail(txtmail.getText());
						usertemp.setEndereco(textAreaEndereco.getText());
						usertemp.setSexo(comboBox.getSelectedItem().toString());
						usertemp.setTelefone(txtTelefone.getText());
						usertemp.setCelular(txtCelular.getText());

						if (new ContatoDAO(usertemp).gravar()) {
							JOptionPane.showMessageDialog(null,
									"Usuario: " + usertemp.getNome() + ", registrado com sucesso!");
							txtNome.setText("");
							txtNome.requestFocus();
							txtTelefone.setText("");
							txtmail.setText("");
							txtCelular.setText("");
							txtNacimento.setText("");
							textAreaEndereco.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao gravar Usuario: " + usertemp.getNome());
						}

						txtNome.requestFocus();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		} else if (FormModel.equals("edit")) {
			txtNome.setText(selecionado.getNome());
			txtmail.setText(selecionado.getTelefone());
			txtTelefone.setText(selecionado.getTelefone());

			btnop.setBackground(new Color(60, 179, 113));
			btnop.setIcon(new ImageIcon(
					FrmDialogContato.class.getResource("/br/senai/sp/jandira/agenda/imagens/EditContact.png")));
			PreparedStatement stn = null;
			ResultSet rts = null;
			String query = "SELECT dtNac,endereco,celular,sexo FROM contatos where id=" + selecionado.getId() + " ;";

			try {
				stn = DbConexao.abrirConexao().prepareStatement(query);
				rts = stn.executeQuery();

				while (rts.next()) {
					// retorna os dados da tabela do BD, cada campo e um coluna.

					String ano = rts.getString("dtNac").substring(0, 4);
					String mes = rts.getString("dtNac").substring(5, 7);
					String dia = rts.getString("dtNac").substring(8, 10);
					txtNacimento.setText(dia+"/"+mes+"/"+ano);
					textAreaEndereco.setText(rts.getString("endereco"));
					txtCelular.setText(rts.getString("celular"));
					comboBox.setSelectedItem(rts.getString("sexo"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			btnSalvar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {

					ContatoDAO adicionar = new ContatoDAO();
					selecionado.setCelular(txtCelular.getText());
					selecionado.setTelefone(txtTelefone.getText());
					selecionado.setNome(txtNome.getText());
					selecionado.setDtNac(txtNacimento.getText());
					selecionado.setEndereco(textAreaEndereco.getText());
					selecionado.setEmail(txtmail.getText());

					adicionar.setContato(selecionado);
					adicionar.atualizar();

				}
			});

		} else {
			btnop.setIcon(new ImageIcon(
					FrmDialogContato.class.getResource("/br/senai/sp/jandira/agenda/imagens/Remove.png")));
			btnop.setBackground(new Color(255, 0, 0));
			btnSair.setBackground(new Color(220, 20, 60));
			btnSalvar.setBackground(new Color(220, 20, 60));

			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					try {
						Contato usertemp = new Contato();
						usertemp.setNome(txtNome.getText());

						usertemp.setDtNac(txtNacimento.getText());
						usertemp.setEmail(txtmail.getText());
						usertemp.setEndereco(textAreaEndereco.getText());
						usertemp.setSexo(comboBox.getSelectedItem().toString());
						usertemp.setTelefone(txtTelefone.getText());
						usertemp.setCelular(txtCelular.getText());

						new ContatoDAO(usertemp).gravar();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		setVisible(true);
	}

}
