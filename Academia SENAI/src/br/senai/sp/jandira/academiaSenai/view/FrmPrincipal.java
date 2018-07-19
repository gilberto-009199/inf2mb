package br.senai.sp.jandira.academiaSenai.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import br.senai.sp.jandira.academiaSenai.dao.ClientDAO;
import br.senai.sp.jandira.academiaSenai.model.Client;

import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.GridLayout;

import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JProgressBar;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNome;
	private JScrollPane scrollPainelInferiorSegundarioTabelaCelulas = null;
	private DefaultTableModel modeloTabela = null;
	private JPanel panelCalculo = null;
	private JTable tabletemp;

	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FrmPrincipal.class.getResource("/br/senai/sp/jandira/academiaSenai/images/icon.png")));
		setTitle("AcademiaTools");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 690);

		JMenuBar Menu = new JMenuBar();

		setJMenuBar(Menu);
		contentPane = new JPanel();
		contentPane.setAlignmentY(0.0f);
		contentPane.setAlignmentX(0.0f);
		contentPane.setMinimumSize(new Dimension(302, 302));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JSplitPane divpainel = new JSplitPane();
		divpainel.setBackground(new Color(0, 128, 128));
		divpainel.setMinimumSize(new Dimension(300, 300));
		divpainel.setResizeWeight(0);
		divpainel.setOrientation(JSplitPane.VERTICAL_SPLIT);
		divpainel.setOrientation(0);
		divpainel.setDividerLocation(100);
		divpainel.setDividerSize(1);
		contentPane.add(divpainel, "name_672575842315485");

		JPanel painelSuperior = new JPanel();
		painelSuperior.setAutoscrolls(true);
		painelSuperior.setBackground(Color.WHITE);
		divpainel.setLeftComponent(painelSuperior);
		painelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 30));

		JLabel label = new JLabel("Boa Forma");
		label.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/jandira/academiaSenai/images/icon.png")));
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Dialog", Font.BOLD, 36));
		painelSuperior.add(label);

		JSplitPane divPainelInferior = new JSplitPane();
		divPainelInferior.setMinimumSize(new Dimension(300, 300));
		divPainelInferior.setBackground(new Color(0, 128, 128));
		divpainel.setRightComponent(divPainelInferior);
		divPainelInferior.setBounds(0, 0, 800, 564);
		divPainelInferior.setDividerLocation(300);
		divPainelInferior.setDividerSize(1);

		JPanel painelInferiorPrimario = new JPanel();
		painelInferiorPrimario.setMinimumSize(new Dimension(290, 100));
		painelInferiorPrimario.setBackground(new Color(0, 128, 128));
		divPainelInferior.setLeftComponent(painelInferiorPrimario);
		painelInferiorPrimario.setLayout(new CardLayout(0, 0));

		JSplitPane divPanelInferiorPrimarioPrimario = new JSplitPane();
		divPanelInferiorPrimarioPrimario.setDividerSize(0);
		divPanelInferiorPrimarioPrimario.setBackground(new Color(0, 128, 128));
		divPanelInferiorPrimarioPrimario.setOrientation(JSplitPane.VERTICAL_SPLIT);
		divPanelInferiorPrimarioPrimario.setDividerLocation(100);
		painelInferiorPrimario.add(divPanelInferiorPrimarioPrimario, "name_9504706201703");

		JPanel panelInferiorPrimarioPrimarioPesquisa = new JPanel();
		panelInferiorPrimarioPrimarioPesquisa.setMinimumSize(new Dimension(10, 100));
		panelInferiorPrimarioPrimarioPesquisa.setBackground(new Color(0, 128, 128));
		divPanelInferiorPrimarioPrimario.setLeftComponent(panelInferiorPrimarioPrimarioPesquisa);
		panelInferiorPrimarioPrimarioPesquisa.setLayout(null);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PesquisaCliente(txtNome.getText());
			}
		});
		btnPesquisar.setForeground(new Color(255, 255, 255));
		btnPesquisar.setBackground(new Color(0, 0, 0));
		btnPesquisar.setBounds(167, 62, 118, 32);

		panelInferiorPrimarioPrimarioPesquisa.add(btnPesquisar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(12, 22, 70, 15);
		panelInferiorPrimarioPrimarioPesquisa.add(lblNome);

		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtNome.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		txtNome.setBounds(88, 16, 202, 24);
		panelInferiorPrimarioPrimarioPesquisa.add(txtNome);
		txtNome.setColumns(10);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setEnabled(false);
		progressBar.setIndeterminate(true);
		progressBar.setValue(30);
		progressBar.setForeground(Color.GREEN);
		progressBar.setBackground(Color.DARK_GRAY);
		progressBar.setBounds(8, 71, 148, 15);
		panelInferiorPrimarioPrimarioPesquisa.add(progressBar);

		JPanel panelInferiorPrimarioPrimarioConteudo = new JPanel();
		panelInferiorPrimarioPrimarioConteudo.setBackground(new Color(0, 128, 128));
		divPanelInferiorPrimarioPrimario.setRightComponent(panelInferiorPrimarioPrimarioConteudo);
		panelInferiorPrimarioPrimarioConteudo.setLayout(new CardLayout(0, 0));

		JScrollPane scrollpanelInferiorPrimarioPrimarioConteudoinfo = new JScrollPane();
		scrollpanelInferiorPrimarioPrimarioConteudoinfo.setBackground(new Color(0, 128, 128));
		panelInferiorPrimarioPrimarioConteudo.add(scrollpanelInferiorPrimarioPrimarioConteudoinfo,
				"name_14585595650659");

		panelCalculo = new JPanel();
		panelCalculo.setBorder(null);
		panelCalculo.setBackground(new Color(0, 128, 128));
		scrollpanelInferiorPrimarioPrimarioConteudoinfo.setViewportView(panelCalculo);
		panelCalculo.setLayout(null);
		//

		//
		JSplitPane divPainelInferiorSegundario = new JSplitPane();
		divPainelInferiorSegundario.setMinimumSize(new Dimension(287, 220));
		divPainelInferiorSegundario.setBackground(new Color(0, 128, 128));
		divPainelInferiorSegundario.setOneTouchExpandable(true);
		divPainelInferiorSegundario.setOrientation(JSplitPane.VERTICAL_SPLIT);
		divPainelInferior.setRightComponent(divPainelInferiorSegundario);
		divPainelInferiorSegundario.setOrientation(0);
		divPainelInferiorSegundario.setDividerLocation(65);
		divPainelInferiorSegundario.setDividerSize(1);

		JPanel painelInferiorSegundarioControles = new JPanel();
		painelInferiorSegundarioControles.setMinimumSize(new Dimension(100, 57));
		painelInferiorSegundarioControles.setBorder(null);
		painelInferiorSegundarioControles.setBackground(new Color(0, 128, 128));
		divPainelInferiorSegundario.setLeftComponent(painelInferiorSegundarioControles);
		painelInferiorSegundarioControles.setLayout(new GridLayout(0, 5, 0, 0));

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setMinimumSize(new Dimension(40, 100));
		btnAdicionar.setForeground(new Color(240, 255, 255));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmClient(new Client(), "Adicionar",null).setVisible(true);

			}
		});

		MouseAdapter mudacor = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				arg0.getComponent().setBackground(new Color(0, 21, 255));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(new Color(0, 0, 0));

			}
		};

		btnAdicionar.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnAdicionar.setToolTipText("Adiciona um cliente ao sistema");
		btnAdicionar.setBackground(new Color(0, 0, 0));
		btnAdicionar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAdicionar.setSelectedIcon(null);
		btnAdicionar.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Add.png")));
		painelInferiorSegundarioControles.add(btnAdicionar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Client usertemp = new ClientDAO().getClient((int) table.getValueAt(table.getSelectedRow(), 1));

					new FrmClient(usertemp, "Editar",null).setVisible(true);

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, " Erro: Nenhum usuario selecionado! Selecione um na tabela");
					System.out.println("erro : " + erro.getMessage());
				}
			}
		});
		btnEditar.setMinimumSize(new Dimension(40, 100));
		btnEditar.setForeground(new Color(240, 255, 255));
		btnEditar.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnEditar.setToolTipText("Edita os atributos de um cliente\r\n do sistema");
		btnEditar.setBackground(new Color(0, 0, 0));
		btnEditar.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/br/senai/sp/jandira/academiaSenai/images/EditContact.png")));
		btnEditar.setFont(new Font("Dialog", Font.BOLD, 16));
		painelInferiorSegundarioControles.add(btnEditar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Client usertemp = new ClientDAO().getClient((int) table.getValueAt(table.getSelectedRow(), 1));
					ArrayList<Client> lista =new ArrayList<Client>();
					
					for (int i = 0; i < table.getRowCount(); i++) {
						Boolean checked = Boolean.valueOf(table.getValueAt(i, 0).toString());
						// Verifica se o usuario que foi pego nesse loop foi
						// selecionado
						if (checked) {
							
							lista.add(new ClientDAO().getClient((int)table.getValueAt(i, 1)));
							
						}
					}
					 new FrmClient(usertemp, "Remover",lista).setVisible(true);
					

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, " Erro: Nenhum usuario selecionado! Selecione um na tabela");
					System.out.println("erro : " + erro.getMessage());
				}
			}
		});
		btnRemover.setMinimumSize(new Dimension(40, 100));
		btnRemover.setForeground(new Color(240, 255, 255));
		btnRemover.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnRemover.setToolTipText("Remove um cliente do sistema");
		btnRemover.setBackground(new Color(0, 0, 0));
		btnRemover.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Remove.png")));
		btnRemover.setFont(new Font("Dialog", Font.BOLD, 16));
		painelInferiorSegundarioControles.add(btnRemover);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PopulaTabela();
			}
		});
		btnConsultar.setMinimumSize(new Dimension(40, 100));
		btnConsultar.setForeground(new Color(240, 255, 255));
		btnConsultar.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnConsultar.setToolTipText("Consulta os registros do sistema");
		btnConsultar.setBackground(new Color(0, 0, 0));
		btnConsultar.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Query.png")));
		btnConsultar.setFont(new Font("Dialog", Font.BOLD, 16));
		painelInferiorSegundarioControles.add(btnConsultar);

		JButton btnSair = new JButton("Sair");
		btnSair.setMinimumSize(new Dimension(40, 100));
		btnSair.setForeground(new Color(240, 255, 255));
		btnSair.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnSair.setToolTipText("Sai do programa");
		btnSair.setBackground(new Color(0, 0, 0));
		btnSair.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Exit.png")));
		btnSair.setFont(new Font("Dialog", Font.BOLD, 16));
		painelInferiorSegundarioControles.add(btnSair);

		btnAdicionar.addMouseListener(mudacor);
		btnConsultar.addMouseListener(mudacor);
		btnEditar.addMouseListener(mudacor);
		btnRemover.addMouseListener(mudacor);
		btnSair.addMouseListener(mudacor);
		btnPesquisar.addMouseListener(mudacor);

		JPanel divPainelInferiorSegundarioTabela = new JPanel();
		divPainelInferiorSegundarioTabela.setBorder(null);
		divPainelInferiorSegundario.setRightComponent(divPainelInferiorSegundarioTabela);
		divPainelInferiorSegundarioTabela.setLayout(new CardLayout(0, 0));

		scrollPainelInferiorSegundarioTabelaCelulas = new JScrollPane();
		divPainelInferiorSegundarioTabela.add(scrollPainelInferiorSegundarioTabelaCelulas, "name_2303465990491");

		scrollPainelInferiorSegundarioTabelaCelulas
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPainelInferiorSegundarioTabelaCelulas
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		criarTabela();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (table.getSelectedRow() >= 0) {
					Client usertemp = new ClientDAO().getClient((int) table.getValueAt(table.getSelectedRow(), 1));
					calcula(usertemp);
				}
			}
		});
	}

	private void calcula(Client calculado) {
		panelCalculo.removeAll();

		JLabel lblNomeC = new JLabel("Nome:");
		lblNomeC.setForeground(Color.WHITE);
		lblNomeC.setBounds(12, 49, 55, 16);
		panelCalculo.add(lblNomeC);

		JLabel lblInputNome = new JLabel(calculado.getName());
		lblInputNome.setForeground(Color.WHITE);
		lblInputNome.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblInputNome.setBounds(70, 50, 210, 16);
		panelCalculo.add(lblInputNome);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(Color.WHITE);
		lblIdade.setBounds(12, 77, 55, 16);
		panelCalculo.add(lblIdade);

		JLabel lblInputIdade = new JLabel(calculado.getOld() + "");
		lblInputIdade.setForeground(Color.WHITE);
		lblInputIdade.setBounds(231, 78, 55, 16);
		panelCalculo.add(lblInputIdade);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setBounds(12, 105, 55, 16);
		panelCalculo.add(lblAltura);
		int altura = calculado.getHeight().intValue();
		
		JLabel lblInputAltura = new JLabel(altura + " cm");
		lblInputAltura.setForeground(Color.WHITE);
		lblInputAltura.setBounds(231, 106, 55, 16);
		panelCalculo.add(lblInputAltura);

		JLabel lblNvelDeAtividade = new JLabel("N�vel de atividade:");
		lblNvelDeAtividade.setForeground(Color.WHITE);
		lblNvelDeAtividade.setBounds(12, 133, 108, 16);
		panelCalculo.add(lblNvelDeAtividade);

		JLabel lblInputNvAtividade = new JLabel(calculado.getActivity());
		lblInputNvAtividade.setForeground(Color.WHITE);
		lblInputNvAtividade.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInputNvAtividade.setBounds(127, 134, 173, 16);
		panelCalculo.add(lblInputNvAtividade);

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setForeground(Color.WHITE);
		lblImc.setBounds(12, 161, 55, 16);
		panelCalculo.add(lblImc);

		JLabel lblInputImc = new JLabel(calculado.Imc());
		lblInputImc.setForeground(Color.WHITE);
		lblInputImc.setBounds(210, 161, 65, 16);
		panelCalculo.add(lblInputImc);

		JTextArea estado = new JTextArea(calculado.getState());
		estado.setBorder(new LineBorder(new Color(0, 0, 0)));
		estado.setBounds(44, 190, 230, 50);
		panelCalculo.add(estado);

		JLabel lblFcm = new JLabel("FCM:");
		lblFcm.setForeground(Color.WHITE);
		lblFcm.setBounds(12, 291, 55, 16);
		panelCalculo.add(lblFcm);

		JLabel lblInputFcm = new JLabel(calculado.Fcm() + "");
		lblInputFcm.setForeground(Color.WHITE);
		lblInputFcm.setBounds(231, 291, 55, 16);
		panelCalculo.add(lblInputFcm);

		JLabel lblTmb = new JLabel("TMB:");
		lblTmb.setForeground(Color.WHITE);
		lblTmb.setBounds(12, 263, 55, 16);
		panelCalculo.add(lblTmb);

		JLabel lblInputTmb = new JLabel(calculado.Tmb().substring(0, 6));
		lblInputTmb.setForeground(Color.WHITE);
		lblInputTmb.setBounds(231, 263, 55, 16);
		panelCalculo.add(lblInputTmb);

		setVisible(false);
		setVisible(true);
	}

	private void criarTabela() {

		modeloTabela = new DefaultTableModel() {
			boolean[] columnEditables = new boolean[] { true, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];// impede a edição das linhas
			}

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;

				default:
					return String.class;
				}
			}
		};

		modeloTabela.addColumn("");
		modeloTabela.addColumn("ID");
		modeloTabela.addColumn("Nome");
		modeloTabela.addColumn("Sexo");
		modeloTabela.addColumn("Peso");
		modeloTabela.addColumn("Altura");

		ArrayList<Client> lista = new ClientDAO().getClients();
		for (int i = 0; i < lista.size(); i++) {

			modeloTabela.addRow(new Object[0]);
			modeloTabela.setValueAt(false, i, 0);// coloca uma checkbox na
													// coluna 1 da lista
			// Pega os clientee coloca no novo objeto
			modeloTabela.setValueAt(lista.get(i).getId(), i, 1);
			modeloTabela.setValueAt(lista.get(i).getName(), i, 2);
			modeloTabela.setValueAt(lista.get(i).getSex(), i, 3);
			modeloTabela.setValueAt(lista.get(i).getWeight(), i, 4);
			modeloTabela.setValueAt((int) (lista.get(i).getHeight() * 1), i, 5);

		}

		table = new JTable();
		table.setSelectionForeground(new Color(255, 255, 255));
		table.setForeground(new Color(0, 0, 0));
		table.setGridColor(new Color(0, 0, 0));
		table.setSelectionBackground(new Color(0, 128, 128));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(modeloTabela);

		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(0).setResizable(true);

		table.getColumnModel().getColumn(1).setPreferredWidth(47);
		table.getColumnModel().getColumn(1).setMaxWidth(61);

		table.getColumnModel().getColumn(1).setResizable(false);

		table.getColumnModel().getColumn(2).setPreferredWidth(215);
		table.getColumnModel().getColumn(3).setPreferredWidth(175);
		table.getColumnModel().getColumn(4).setPreferredWidth(95);

		table.setFillsViewportHeight(true);
		table.setBackground(new Color(255, 255, 255));
		scrollPainelInferiorSegundarioTabelaCelulas.add(table);
		scrollPainelInferiorSegundarioTabelaCelulas.setViewportView(table);

	}

	private void PopulaTabela() {

		modeloTabela.setNumRows(0);

		ArrayList<Client> lista = new ClientDAO().getClients();

		for (int i = 0; i < lista.size(); i++) {

			modeloTabela.addRow(new Object[0]);
			modeloTabela.setValueAt(false, i, 0);// coloca uma checkbox na
													// coluna 1 da lista
			// Pega os clientee coloca no novo objeto
			modeloTabela.setValueAt(lista.get(i).getId(), i, 1);
			modeloTabela.setValueAt(lista.get(i).getName(), i, 2);
			modeloTabela.setValueAt(lista.get(i).getSex(), i, 3);
			modeloTabela.setValueAt(lista.get(i).getWeight(), i, 4);
			modeloTabela.setValueAt((int) (lista.get(i).getHeight() * 1), i, 5);

		}

	}

	@SuppressWarnings("unused")
	private void PesquisaCliente(String nome) {
		panelCalculo.removeAll();

		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/br/senai/sp/jandira/academiaSenai/images/EditContact.png")));
		btnEditar.setToolTipText("Edita os atributos de um cliente\r\n do sistema");
		btnEditar.setMinimumSize(new Dimension(40, 100));
		btnEditar.setForeground(new Color(240, 255, 255));
		btnEditar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnEditar.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnEditar.setBackground(Color.BLACK);
		btnEditar.setBounds(1, 355, 133, 64);
		panelCalculo.add(btnEditar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.setIcon(
				new ImageIcon(FrmPrincipal.class.getResource("/br/senai/sp/jandira/academiaSenai/images/Remove.png")));
		btnRemover.setToolTipText("Edita os atributos de um cliente\r\n do sistema");
		btnRemover.setMinimumSize(new Dimension(40, 100));
		btnRemover.setForeground(new Color(240, 255, 255));
		btnRemover.setFont(new Font("Dialog", Font.BOLD, 16));
		btnRemover.setBorder(UIManager.getBorder("DesktopIcon.border"));
		btnRemover.setBackground(Color.BLACK);
		btnRemover.setBounds(153, 354, 141, 65);
		panelCalculo.add(btnRemover);

		JScrollPane scrollPanetemp = new JScrollPane();
		scrollPanetemp.setBounds(12, 12, 270, 319);
		panelCalculo.add(scrollPanetemp);

		tabletemp = new JTable();
		tabletemp.setSelectionForeground(new Color(255, 255, 255));
		tabletemp.setForeground(new Color(0, 0, 0));
		tabletemp.setGridColor(new Color(0, 0, 0));
		tabletemp.setSelectionBackground(new Color(0, 128, 128));
		tabletemp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPanetemp.setViewportView(tabletemp);

		DefaultTableModel modelotemp = new DefaultTableModel();
		tabletemp.setModel(modelotemp);
		modelotemp.addColumn("ID");
		modelotemp.addColumn("Nome");
		modelotemp.addColumn("Sexo");

		tabletemp.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabletemp.getColumnModel().getColumn(0).setMaxWidth(45);
		tabletemp.getColumnModel().getColumn(0).setResizable(false);

		tabletemp.getColumnModel().getColumn(1).setPreferredWidth(100);

		tabletemp.getColumnModel().getColumn(1).setResizable(false);

		tabletemp.getColumnModel().getColumn(2).setPreferredWidth(35);
		tabletemp.getColumnModel().getColumn(0).setMaxWidth(34);

		modelotemp.setNumRows(0);

		ArrayList<Client> lista = new ClientDAO().SearchClients(nome);

		for (int i = 0; i < lista.size(); i++) {

			modelotemp.addRow(new Object[0]);
			// Pega os clientee coloca no novo objeto
			modelotemp.setValueAt(lista.get(i).getId(), i, 0);
			modelotemp.setValueAt(lista.get(i).getName(), i, 1);
			modelotemp.setValueAt(lista.get(i).getSex(), i, 2);

		}
		// SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		// data.format(rts.getDate("dtNasc"));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Client usertemp = new ClientDAO()
							.getClient((int) tabletemp.getValueAt(tabletemp.getSelectedRow(), 0));

					new FrmClient(usertemp, "Remover",null).setVisible(true);

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, " Erro: Nenhum usuario selecionado! Selecione um na tabela");
					System.out.println("erro : " + erro.getMessage());
				}
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Client usertemp = new ClientDAO()
							.getClient((int) tabletemp.getValueAt(tabletemp.getSelectedRow(), 0));

					new FrmClient(usertemp, "Editar",null).setVisible(true);

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, " Erro: Nenhum usuario selecionado! Selecione um na tabela");
					System.out.println("erro : " + erro.getMessage());
				}
			}
		});

		setVisible(false);
		setVisible(true);
	}
}
