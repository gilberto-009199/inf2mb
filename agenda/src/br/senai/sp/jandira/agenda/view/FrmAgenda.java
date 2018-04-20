package br.senai.sp.jandira.agenda.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import org.hsqldb.lib.ArrayListIdentity;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import br.senai.sp.jandira.agenda.dao.ContatoDAO;
import br.senai.sp.jandira.agenda.model.Contato;
import br.senai.sp.jandira.agenda.util.DbConexao;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import javax.swing.border.TitledBorder;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	public JTable table;
	JScrollPane scrollTabela = new JScrollPane();
	JPanel panelContatos = new JPanel();
	
	public FrmAgenda() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAgenda.class.getResource("/br/senai/sp/jandira/agenda/imagens/icon.png")));
		setTitle("Agenta");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 642, 498);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(UIManager.getColor("scrollbar"));
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(255, 250, 205));
		panelTitulo.setBounds(0, 0, 626, 88);
		painelPrincipal.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setHorizontalAlignment(SwingConstants.LEFT);
		lblAgenda.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/agenda/imagens/Resume-icon.png")));
		lblAgenda.setForeground(new Color(0, 0, 255));
		lblAgenda.setFont(new Font("Vladimir Script", Font.PLAIN, 32));
		lblAgenda.setBounds(10, 0, 619, 90);
		panelTitulo.add(lblAgenda);
		
		
		panelContatos.setBorder(new TitledBorder(null, "Menu Contatos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelContatos.setBounds(0, 91, 626, 282);
		painelPrincipal.add(panelContatos);
		panelContatos.setLayout(null);
		
		
		scrollTabela.setBounds(5, 18, 609, 259);
		scrollTabela.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTabela.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		criarTabela();
		
		panelContatos.add(scrollTabela);
		
		JPanel PainelBotoes = new JPanel();
		PainelBotoes.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(192, 192, 192), null), "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PainelBotoes.setBounds(9, 386, 617, 61);
		painelPrincipal.add(PainelBotoes);
		PainelBotoes.setLayout(null);
		
		JButton btnRegistar = new JButton("Novo");
		btnRegistar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/agenda/imagens/Add.png")));
		btnRegistar.setBounds(12, 12, 93, 40);
		PainelBotoes.add(btnRegistar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/agenda/imagens/edit.png")));
		btnEditar.setBounds(117, 12, 103, 40);
		PainelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmDialogContato("remove",null);
			}
		});
		btnExcluir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/agenda/imagens/Remove.png")));
		btnExcluir.setBounds(232, 12, 115, 40);
		PainelBotoes.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/agenda/imagens/data.png")));
		btnConsultar.setBounds(359, 12, 129, 40);
		PainelBotoes.add(btnConsultar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/agenda/imagens/exit.png")));
		btnSair.setBounds(500, 12, 105, 40);
		PainelBotoes.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopulaTabela();
			}
		});
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {					// Retorna a lina selecionada
				/*JOptionPane.showMessageDialog(null, " Linha selecionada:	"+table.getSelectedRow());
				JOptionPane.showMessageDialog(null, " Coluna selecionada:	"+table.getSelectedColumn());
				JOptionPane.showMessageDialog(null,"Palavra selecionada: "+table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
				*/
				Contato selecionado = new Contato();
				selecionado.setId(Integer.parseInt((String) table.getValueAt(table.getSelectedRow(),0)));
				selecionado.setNome(table.getValueAt(table.getSelectedRow(),1).toString());
				selecionado.setEmail(table.getValueAt(table.getSelectedRow(),2).toString());
				selecionado.setTelefone(table.getValueAt(table.getSelectedRow(),3).toString());
				
				new FrmDialogContato("edit",selecionado);
				
			}
		});
		btnRegistar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new FrmDialogContato("add",null);
			}
		});
		
	}
	public  void criarTabela(){
		DefaultTableModel modeloTabela = new DefaultTableModel();
		Object[] linha = new Object[4];
		
		int i=0;
		while(i<4){
			linha[i]="";
			i++;
		}
		//Object[][] linhas = new Object[4][4];

		String[] nomes ={"ID", "Nome", "E-mail", "Telefone"};
		
		modeloTabela.setColumnIdentifiers(nomes);
		modeloTabela.addRow(linha);
		//table.setModel(modeloTabela);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "E-mail", "Telefone"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(215);
		table.getColumnModel().getColumn(2).setPreferredWidth(175);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.setFillsViewportHeight(true);
		table.setBackground(new Color(248, 248, 255));
		
		
		
		scrollTabela.setViewportView(table);
		
		
	}
	public void PopulaTabela(){
		
		ContatoDAO registros = new ContatoDAO();
		ArrayList<Contato> contatos	= registros.getContatos();
		DefaultTableModel model =(DefaultTableModel) table.getModel();
		   model.setNumRows(0);
		 
		   for(int i =0; i<contatos.size();i++){
			   model.addRow(new Object[] 
				       { 
				          //retorna os dados da tabela do BD, cada campo e um coluna.
				          contatos.get(i).getId(),
				          contatos.get(i).getNome(),
				          contatos.get(i).getEmail(),
				          contatos.get(i).getTelefone()
				       });
		   }
		   
		
		
		
		
		
		
		
		
		
		/*PreparedStatement stn = null;
		ResultSet rts = null;
		String query ="SELECT*FROM contatos";
		
		try {
			stn = DbConexao.abrirConexao().prepareStatement(query);
			rts=stn.executeQuery();
			
			 DefaultTableModel model =(DefaultTableModel) table.getModel();
			   model.setNumRows(0);
			 
			   while(rts.next())
			   {
			       model.addRow(new Object[] 
			       { 
			          //retorna os dados da tabela do BD, cada campo e um coluna.
			          rts.getString("id"),
			          rts.getString("nome"),
			          rts.getString("email"),
			          rts.getString("telefone")
			       }); 
			  } 

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
