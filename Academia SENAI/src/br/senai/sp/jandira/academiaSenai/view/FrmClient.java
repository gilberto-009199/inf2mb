package br.senai.sp.jandira.academiaSenai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import javax.swing.border.LineBorder;

import br.senai.sp.jandira.academiaSenai.dao.ClientDAO;
import br.senai.sp.jandira.academiaSenai.model.Client;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;

import javax.swing.JComboBox;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JEditorPane;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class FrmClient extends JFrame {
	private JPanel contentPane;
	JFormattedTextField txtData;

	public FrmClient(Client user, String op, ArrayList<Client> listaClientes) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 562);
		contentPane = new JPanel();
		contentPane.setAlignmentY(0.0f);
		contentPane.setAlignmentX(0.0f);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JSplitPane divPrimario = new JSplitPane();
		divPrimario.setBorder(null);
		divPrimario.setDividerSize(0);
		divPrimario.setOrientation(JSplitPane.VERTICAL_SPLIT);
		divPrimario.setDividerLocation(100);
		contentPane.add(divPrimario, "name_1378844676078510");

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		divPrimario.setLeftComponent(panel);
		panel.setLayout(new CardLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(null);
		splitPane.setDividerSize(0);
		panel.add(splitPane, "name_1379911780287011");

		JPanel panellogo = new JPanel();
		panellogo.setBackground(Color.WHITE);
		splitPane.setLeftComponent(panellogo);
		panellogo.setLayout(null);

		JLabel lblClientes = new JLabel("Cliente");
		lblClientes.setForeground(Color.BLUE);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(36, 12, 222, 71);
		lblClientes.setIconTextGap(0);
		lblClientes.setIcon(
				new ImageIcon(FrmClient.class.getResource("/br/senai/sp/jandira/academiaSenai/images/user64x64.png")));
		lblClientes.setFont(new Font("Dialog", Font.BOLD, 20));
		panellogo.add(lblClientes);

		JLabel label = new JLabel("");
		label.setBounds(-10013, -10036, 500, 100);
		panellogo.add(label);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 255, 0));
		splitPane.setRightComponent(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		JLabel lblop = new JLabel("");
		lblop.setHorizontalAlignment(SwingConstants.CENTER);
		lblop.setIcon(
				new ImageIcon(FrmClient.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Add64x64.png")));
		panel_3.add(lblop, "name_3095482947200460");
		splitPane.setDividerLocation(500);

		JPanel panel_1 = new JPanel();
		panel_1.setAlignmentY(0.0f);
		panel_1.setAlignmentX(0.0f);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(0, 128, 128));
		divPrimario.setRightComponent(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(0);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_1.add(splitPane_1, "name_3096743708449122");

		JPanel panel_2 = new JPanel();
		splitPane_1.setRightComponent(panel_2);

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.setBounds(12, 15, 182, 78);
		btnSalvar.setIcon(
				new ImageIcon(FrmClient.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Add64x64.png")));
		btnSalvar.setBorder(new LineBorder(Color.CYAN, 2));
		btnSalvar.setBackground(new Color(0, 0, 0));
		btnSalvar.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSalvar.setForeground(Color.WHITE);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(476, 16, 225, 76);
		btnSair.setIcon(
				new ImageIcon(FrmClient.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Exit.png")));
		btnSair.setBorder(new LineBorder(new Color(0, 255, 255), 2));
		btnSair.setBackground(Color.BLACK);
		btnSair.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSair.setForeground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.add(btnSalvar);
		panel_2.add(btnSair);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		splitPane_1.setLeftComponent(panel_4);
		panel_4.setLayout(null);
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setValue(1);
		progressBar.setForeground(new Color(0, 250, 154));
		progressBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		progressBar.setBounds(12, 268, 343, 19);
		panel_4.add(progressBar);
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(366, 23, 13, 250);
		panel_4.add(separator);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(12, 25, 55, 16);
		panel_4.add(lblNome);
		JTextField txtNome;
		JTextField txtPeso;
		JTextField txtAltura;

		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {

			private boolean prograss = false;

			public void keyPressed(KeyEvent arg0) {
				if (((!prograss) && (!(arg0.getKeyChar() == new String(" ").charAt(0))))
						&& !(arg0.getKeyChar() == new String("").charAt(0))) {
					prograss = true;
					progressBar.setValue(progressBar.getValue() + 25);
				} else {
					if ((txtNome.getText().length() == 1 && arg0.getKeyChar() == new String("").charAt(0))) {
						prograss = false;
						progressBar.setValue(progressBar.getValue() - 25);
					}
				}
			}
		});

		txtNome.setDisabledTextColor(new Color(135, 206, 250));
		txtNome.setSelectionColor(new Color(0, 255, 127));
		txtNome.setFont(new Font("Dialog", Font.BOLD, 12));
		txtNome.setForeground(new Color(0, 0, 0));
		txtNome.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtNome.setBounds(85, 23, 232, 24);
		panel_4.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSexo.setBounds(12, 60, 55, 16);
		panel_4.add(lblSexo);

		JRadioButton rdbtnHomen = new JRadioButton("Homem");
		rdbtnHomen.setBorder(null);
		rdbtnHomen.setBackground(Color.WHITE);
		rdbtnHomen.setBounds(85, 57, 79, 24);
		panel_4.add(rdbtnHomen);

		JRadioButton rdbtnMulher = new JRadioButton("Mulher");
		rdbtnMulher.setSelectedIcon(
				new ImageIcon(FrmClient.class.getResource("/br/senai/sp/jandira/academiaSenai/images/User.png")));
		rdbtnMulher.setBorder(null);
		rdbtnMulher.setBackground(Color.WHITE);
		rdbtnMulher.setBounds(179, 55, 79, 24);
		panel_4.add(rdbtnMulher);

		ButtonGroup sexo = new ButtonGroup();
		sexo.add(rdbtnMulher);
		sexo.add(rdbtnHomen);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPeso.setBounds(12, 92, 55, 16);
		panel_4.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setDisabledTextColor(new Color(135, 206, 250));
		txtPeso.setSelectionColor(new Color(0, 255, 127));
		txtPeso.setFont(new Font("Dialog", Font.BOLD, 12));
		txtPeso.setColumns(10);
		txtPeso.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPeso.setBounds(85, 89, 79, 24);
		panel_4.add(txtPeso);
		txtPeso.addKeyListener(new KeyAdapter() {

			private boolean prograss = false;

			public void keyPressed(KeyEvent arg0) {
				if (((!prograss) && (!(arg0.getKeyChar() == new String(" ").charAt(0))))
						&& !(arg0.getKeyChar() == new String("").charAt(0))) {
					prograss = true;
					progressBar.setValue(progressBar.getValue() + 24);
				} else {
					if (txtPeso.getText().length() == 1 && arg0.getKeyChar() == new String("").charAt(0)) {
						prograss = false;
						progressBar.setValue(progressBar.getValue() - 24);
					}
				}
			}
		});
		JLabel lblQuilos = new JLabel("quilos");
		lblQuilos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblQuilos.setBounds(176, 93, 55, 16);
		panel_4.add(lblQuilos);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAltura.setBounds(12, 132, 55, 16);
		panel_4.add(lblAltura);

		txtAltura = new JTextField();
		txtAltura.setDisabledTextColor(new Color(135, 206, 250));
		txtAltura.setSelectionColor(new Color(0, 255, 127));
		txtAltura.setFont(new Font("Dialog", Font.BOLD, 12));
		txtAltura.setColumns(10);
		txtAltura.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAltura.setBounds(85, 129, 79, 24);
		panel_4.add(txtAltura);

		txtAltura.addKeyListener(new KeyAdapter() {

			private boolean prograss = false;

			public void keyPressed(KeyEvent arg0) {
				if (((!prograss) && (!(arg0.getKeyChar() == new String(" ").charAt(0))))
						&& !(arg0.getKeyChar() == new String("").charAt(0))) {
					prograss = true;
					progressBar.setValue(progressBar.getValue() + 24);
				} else {
					if (txtAltura.getText().length() == 1 && arg0.getKeyChar() == new String("").charAt(0)) {
						prograss = false;
						progressBar.setValue(progressBar.getValue() - 24);
					}
				}
			}
		});
		JLabel lblCm = new JLabel("cm");
		lblCm.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCm.setBounds(176, 133, 55, 16);
		panel_4.add(lblCm);

		javax.swing.text.MaskFormatter data;
		try {
			data = new javax.swing.text.MaskFormatter("##/##/####");
			txtData = new javax.swing.JFormattedTextField(data);
			txtData.setDisabledTextColor(new Color(135, 206, 250));
			txtData.setSelectionColor(new Color(0, 255, 127));
			txtData.setFont(new Font("Dialog", Font.BOLD, 12));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		txtData.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtData.setHorizontalAlignment(SwingConstants.CENTER);

		txtData.setBounds(217, 167, 100, 25);
		panel_4.add(txtData);
		txtData.addKeyListener(new KeyAdapter() {

			private boolean prograss = false;

			public void keyPressed(KeyEvent arg0) {
				if (((!prograss) && (!(arg0.getKeyChar() == new String(" ").charAt(0))))
						&& !(arg0.getKeyChar() == new String("").charAt(0))) {
					prograss = true;
					progressBar.setValue(progressBar.getValue() + 24);
				} else {
					if ((txtData.getText().equals("  /  /    ") && progressBar.getValue() != 0)) {
						prograss = false;
						progressBar.setValue(progressBar.getValue() - 24);
					}
				}
			}
		});

		JLabel lblDataDeNacimento = new JLabel("Data de Nacimento:");
		lblDataDeNacimento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDataDeNacimento.setBounds(12, 170, 175, 16);
		panel_4.add(lblDataDeNacimento);

		JLabel lblNvelDeAtividade = new JLabel("N\u00EDvel de Atividade:");
		lblNvelDeAtividade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNvelDeAtividade.setBounds(12, 199, 175, 16);
		panel_4.add(lblNvelDeAtividade);

		JComboBox cbNivel = new JComboBox();
		cbNivel.addMouseListener(new MouseAdapter() {
			private boolean prograss = false;

			public void mousePressed(MouseEvent arg0) {
				if ((!prograss)) {
					prograss = true;
					progressBar.setValue(progressBar.getValue() + 2);
				}

			}
		});
		cbNivel.setModel(new DefaultComboBoxModel(new String[] { "Sedentário", "Levemente Ativo", "Moderadamente Ativo",
				"Bastante Ativo", "Muito Ativo" }));
		cbNivel.setSelectedIndex(0);
		cbNivel.setForeground(new Color(0, 0, 205));
		cbNivel.setBackground(new Color(255, 255, 255));
		cbNivel.setBorder(new LineBorder(new Color(0, 0, 0)));
		cbNivel.setBounds(12, 235, 305, 24);
		panel_4.add(cbNivel);

		JEditorPane textareaState = new JEditorPane();
		textareaState.setEditable(false);
		textareaState.setFont(new Font("Dialog", Font.BOLD, 12));
		textareaState.setSelectionColor(new Color(0, 255, 127));
		textareaState.setBorder(new LineBorder(new Color(0, 0, 0)));
		textareaState.setBounds(446, 149, 255, 62);
		panel_4.add(textareaState);

		JLabel label_2 = new JLabel("Nome:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 14));
		label_2.setBounds(397, 23, 55, 16);
		panel_4.add(label_2);

		JLabel lblInputNome = new JLabel("");
		lblInputNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInputNome.setBounds(479, 23, 222, 16);
		panel_4.add(lblInputNome);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblIdade.setBounds(397, 49, 55, 16);
		panel_4.add(lblIdade);

		JLabel label_5 = new JLabel("");
		label_5.setFont(new Font("Dialog", Font.BOLD, 14));
		label_5.setBounds(579, 23, 55, 16);
		panel_4.add(label_5);

		JLabel lblAltura_1 = new JLabel("Altura:");
		lblAltura_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAltura_1.setBounds(542, 49, 55, 16);
		panel_4.add(lblAltura_1);

		JLabel lblPeso_1 = new JLabel("Peso:");
		lblPeso_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPeso_1.setBounds(397, 72, 55, 16);
		panel_4.add(lblPeso_1);

		JLabel lblInputidade = new JLabel("0");
		lblInputidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputidade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInputidade.setBounds(464, 49, 66, 16);
		panel_4.add(lblInputidade);

		JLabel lblInputAltura = new JLabel("0");
		lblInputAltura.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputAltura.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInputAltura.setBounds(609, 52, 92, 16);
		panel_4.add(lblInputAltura);

		JLabel lblInputPeso = new JLabel("0");
		lblInputPeso.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputPeso.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInputPeso.setBounds(464, 72, 66, 16);
		panel_4.add(lblInputPeso);

		JLabel lblNvelDeAtividade_1 = new JLabel("N\u00EDvel de Atividade:");
		lblNvelDeAtividade_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNvelDeAtividade_1.setBounds(397, 100, 141, 20);
		panel_4.add(lblNvelDeAtividade_1);

		JLabel lblInputNv = new JLabel("");
		lblInputNv.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputNv.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInputNv.setBounds(533, 100, 177, 20);
		panel_4.add(lblInputNv);

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setFont(new Font("Dialog", Font.BOLD, 14));
		lblImc.setBounds(397, 129, 55, 16);
		panel_4.add(lblImc);

		JLabel lblInputImc = new JLabel("");
		lblInputImc.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputImc.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInputImc.setBounds(579, 130, 108, 16);
		panel_4.add(lblInputImc);

		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTmb.setBounds(397, 215, 55, 16);
		panel_4.add(lblTmb);

		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFcm.setBounds(397, 239, 55, 16);
		panel_4.add(lblFcm);

		JLabel lblInputTmb = new JLabel("");
		lblInputTmb.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInputTmb.setBounds(608, 216, 79, 16);
		panel_4.add(lblInputTmb);

		JLabel lblInputFcm = new JLabel("");
		lblInputFcm.setFont(new Font("Dialog", Font.BOLD, 14));
		lblInputFcm.setBounds(608, 239, 79, 16);
		panel_4.add(lblInputFcm);

		JLabel label_3 = new JLabel("");
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		label_3.setBounds(608, 133, 79, 16);
		panel_4.add(label_3);
		
		splitPane_1.setDividerLocation(300);

		// Construindo formularo para opera��o especifica

		if (!op.equals("Adicionar")) {
			txtNome.setText(user.getName());
			txtPeso.setText(user.getWeight() + "");
			txtAltura.setText(String.valueOf(user.getHeight().intValue()));
			try {
				SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
				txtData.setText(formatDate.format(user.getBirth()));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, " Erro ao operar sobe a data");
			}
			cbNivel.setSelectedItem(user.getActivity());

			if (user.getSex() == new String("M").charAt(0)) {
				rdbtnHomen.setSelected(true);
			} else {
				rdbtnMulher.setSelected(true);
			}

			if (op.equals("Remover")) {
				// area para o formulario de exclu��o
				if(listaClientes.size()>=1){

					JLabel lblNewLabel = new JLabel(listaClientes.size()+" CLiente(s) para remoção!");
					lblNewLabel.setBounds(85, 5, 271, 15);
					panel_4.add(lblNewLabel);
					
				}
				
				
				lblop.setBackground(new Color(224, 59, 8));
				lblop.setIcon(new ImageIcon(
						FrmClient.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Remove64x64.png")));
				btnSalvar.setIcon(new ImageIcon(
						FrmClient.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Remove64x64.png")));
				progressBar.setBackground(new Color(224, 59, 8));
				progressBar.setValue(100);

			} else {
				// area para o furmulario de atualiza��o

				lblop.setBackground(new Color(0, 128, 128));
				lblop.setIcon(new ImageIcon(
						FrmClient.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Edit64x64.png")));
				btnSalvar.setIcon(new ImageIcon(
						FrmClient.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Edit64x64.png")));
				progressBar.setBackground(new Color(0, 128, 128));
				progressBar.setValue(100);

			}
		}
		MouseAdapter mudacor = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				arg0.getComponent().setBackground(new Color(0, 21, 255));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(new Color(0, 0, 0));
				// setBackground(new Color(0,0,0));
			}
		};
		btnSalvar.addMouseListener(mudacor);
		btnSair.addMouseListener(mudacor);

		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				boolean operation;
				// pegando os dados do usuario que ser� adicionado , editado ou
				// excluido
				user.setName(txtNome.getText());
				if (rdbtnHomen.isSelected()) {
					user.setSex(new String("M").charAt(0));
				} else {
					user.setSex(new String("F").charAt(0));
				}
				user.setWeight(Integer.parseInt(txtPeso.getText()));
				user.setHeight(Integer.parseInt(txtAltura.getText()));
				user.setBirth(new Date(txtData.getText()));
				user.setActivity(cbNivel.getSelectedItem().toString());

				// Opera��es
				if (op.equals("Adicionar")) {
					// A��o que pega os dados do formulario e da set no user
					operation = new ClientDAO(user).gravar();
				} else if (op.equals("Remover")) {
					// Ac�o que ocorre para a remo��o do user
					if(listaClientes.size()>=1){
						for(int i=0;i<listaClientes.size();i++){
							
							if(listaClientes.get(i).getId()!=user.getId()){
								new ClientDAO(listaClientes.get(i)).excluir();
							}
						
						}
						
					}
						operation = new ClientDAO(user).excluir();
					
				} else {
					// Ac�o que ocorre para a edi��o do user
					operation = new ClientDAO(user).atualizar();

				}

				if (!operation) {
					JOptionPane.showMessageDialog(null, " Erro ao salvar as alterações na base de dados");
				} else {
					lblInputNome.setText(user.getName());
					lblInputidade.setText(user.getOld() + " anos");
					lblInputAltura.setText(user.getHeight() * 1 + " cm");
					lblInputPeso.setText(user.getWeight() + " quilos");
					lblInputNv.setText(user.getActivity());
					lblInputImc.setText(user.Imc());
					textareaState.setText(user.getState());
					lblInputTmb.setText(user.Tmb());
					lblInputFcm.setText(user.Fcm() + "");
					txtNome.setText("");
					txtPeso.setText("");
					txtAltura.setText("");
					txtData.setText("");
					cbNivel.setSelectedItem("Sedentário");
					progressBar.setValue(0);
				}

			}
		});
	}
}
