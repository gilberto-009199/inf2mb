package br.senai.sp.jandira.agenda.view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.senai.sp.jandira.agenda.dao.ContatoDAO;
import br.senai.sp.jandira.agenda.model.Contato;

import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FrmDialogContato extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtNacimento;
	private JFormattedTextField txtCelular;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtmail;

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
		lblTelefone.setBounds(31, 53, 80, 14);
		panel_1.add(lblTelefone);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(31, 78, 61, 14);
		panel_1.add(lblEmail);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(31, 104, 61, 14);
		panel_1.add(lblCelular);

		JLabel lblDataDeNacimento = new JLabel("Data de Nacimento:");
		lblDataDeNacimento.setBounds(31, 130, 159, 14);
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

		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "M", "F" }));
		comboBox.setBounds(129, 155, 46, 20);
		panel_1.add(comboBox);

		javax.swing.text.MaskFormatter data;
		javax.swing.text.MaskFormatter celular;

		try {
			data = new javax.swing.text.MaskFormatter("##/##/####");
			txtNacimento = new javax.swing.JFormattedTextField(data);
			txtNacimento.setHorizontalAlignment(SwingConstants.CENTER);

		} catch (ParseException e1) {

			e1.printStackTrace();
		}
		txtNacimento.setBounds(233, 130, 88, 25);
		panel_1.add(txtNacimento);

		try {
			celular = new javax.swing.text.MaskFormatter("(##)#########");
			txtCelular = new javax.swing.JFormattedTextField(celular);
		} catch (Exception e) {

		}

		txtCelular.setHorizontalAlignment(SwingConstants.LEFT);

		txtCelular.setBounds(215, 101, 106, 25);
		panel_1.add(txtCelular);

		txtNome = new JTextField();
		txtNome.setBounds(129, 25, 193, 25);
		panel_1.add(txtNome);
		txtNome.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(129, 50, 193, 25);
		panel_1.add(txtTelefone);

		txtmail = new JTextField();
		txtmail.setColumns(10);
		txtmail.setBounds(129, 75, 193, 25);
		panel_1.add(txtmail);
		
		
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
						if (verifica(usertemp)) {
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
						}
					} catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(null, " Erro ao chamar class :" + e.getMessage());
					}
				}
			});
		} else if (FormModel.equals("edit")) {
			txtNome.setText(selecionado.getNome());
			txtmail.setText(selecionado.getEmail());
			txtTelefone.setText(selecionado.getTelefone());

			btnop.setBackground(new Color(60, 179, 113));
			btnop.setIcon(new ImageIcon(
					FrmDialogContato.class.getResource("/br/senai/sp/jandira/agenda/imagens/EditContact.png")));

			Contato userTemp = new ContatoDAO().getContato(selecionado.getId());

			selecionado.setCelular(userTemp.getCelular());

			selecionado.setDtNac(userTemp.getDtNac());
			selecionado.setCelular(userTemp.getCelular());

			txtNacimento.setText(selecionado.getDtNac());

			selecionado.setEndereco(userTemp.getEndereco());

			selecionado.setSexo(userTemp.getSexo());

			txtCelular.setText(selecionado.getCelular());

			textAreaEndereco.setText(selecionado.getEndereco());

			comboBox.setSelectedItem(selecionado.getSexo());

			btnSalvar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {

					ContatoDAO adicionar = new ContatoDAO();
					selecionado.setCelular(txtCelular.getText());
					selecionado.setTelefone(txtTelefone.getText());
					selecionado.setNome(txtNome.getText());

					selecionado.setDtNac(txtNacimento.getText());
					selecionado.setSexo(comboBox.getSelectedItem().toString());
					selecionado.setEndereco(textAreaEndereco.getText());
					selecionado.setEmail(txtmail.getText());
					if (verifica(selecionado)) {
						adicionar.setContato(selecionado);
						adicionar.atualizar();
					}
				}
			});

		} else {
			btnop.setIcon(new ImageIcon(
					FrmDialogContato.class.getResource("/br/senai/sp/jandira/agenda/imagens/Remove.png")));
			btnop.setBackground(new Color(255, 0, 0));
			btnSair.setBackground(new Color(220, 20, 60));
			btnSalvar.setBackground(new Color(220, 20, 60));
			txtNome.setText(selecionado.getNome());
			txtmail.setText(selecionado.getEmail());
			txtTelefone.setText(selecionado.getTelefone());
			Contato userTemp = new ContatoDAO().getContato(selecionado.getId());
			
			selecionado.setCelular(userTemp.getCelular());
			selecionado.setDtNac(userTemp.getDtNac());
			selecionado.setEndereco(userTemp.getEndereco());
			txtCelular.setText(selecionado.getCelular());
			txtNacimento.setText(selecionado.getDtNac());
			textAreaEndereco.setText(selecionado.getEndereco());

			
			comboBox.setSelectedItem(selecionado.getSexo());
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Contato usertemp = new Contato();
					usertemp.setNome(txtNome.getText());
					if (selecionado.getId() != 0) {
						usertemp.setId(selecionado.getId());
					} else {
						usertemp.setId((Integer.parseInt(JOptionPane.showInputDialog(null,
								"Por favor Digite o ID do usuario que será deletado!"))));
					}
					
					new ContatoDAO(usertemp).excluir();

				}
			});
		}

		setVisible(true);
	}

	protected boolean verifica(Contato usertemp) {

		if (usertemp.getNome().equals("") || usertemp.getNome().equals(null)) {
			JOptionPane.showMessageDialog(null, "Erro: Campo Nome não Preenchido! Usuario não gravado!");
			return false;
		} else if (usertemp.getTelefone().equals("") || usertemp.getTelefone().equals(null)) {
			JOptionPane.showMessageDialog(null, "Erro: Campo Telefone não Preenchido! Usuario não gravado!");
			return false;
		} else if (usertemp.getEmail().equals("") || usertemp.getEmail().equals(null)) {
			JOptionPane.showMessageDialog(null, "Erro: Campo E-mail não Preenchido! Usuario não gravado!");
			return false;
		} else if (usertemp.getCelular().equals("") || usertemp.getCelular().equals(null)) {
			JOptionPane.showMessageDialog(null, "Erro: Campo Celular não Preenchido! Usuario não gravado!");
			return false;
		} else if (usertemp.getDtNac().equals("") || usertemp.getDtNac().equals(null)) {
			JOptionPane.showMessageDialog(null, "Erro: Campo Nacimento não Preenchido! Usuario não gravado!");
			return false;
		} else if (usertemp.getSexo().equals("") || usertemp.getSexo().equals(null)) {
			JOptionPane.showMessageDialog(null, "Erro: Campo Sexo não Preenchido! Usuario não gravado!");
			return false;
		} else if (usertemp.getEndereco().equals("") || usertemp.getEndereco().equals(null)) {
			JOptionPane.showMessageDialog(null, "Erro: Campo Endereço não Preenchido! Usuario não gravado!");
			return false;
		} else {
			return true;
		}
	}
}
