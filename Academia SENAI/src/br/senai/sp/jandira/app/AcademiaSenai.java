package br.senai.sp.jandira.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

import br.senai.sp.jandira.academiaSenai.dao.ClientDAO;
import br.senai.sp.jandira.academiaSenai.model.Client;
import br.senai.sp.jandira.academiaSenai.view.FrmPrincipal;

public class AcademiaSenai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FrmPrincipal().setVisible(true);
		/*
		  Client	maria = new ClientDAO().getContato(1);
		  System.out.println("Nome: "+maria.getName());
		  System.out.println("Sexo: "+maria.getSex());
		  System.out.println("Altura: "+maria.getHeight());
		  System.out.println("IMC:  "+maria.Imc());
		  System.out.println("FCM:  "+maria.Fcm());
		  System.out.println("TMB:  "+maria.Tmb().substring(0,6));
		  System.out.println("Estado: "+maria.getState());
		  System.out.println("idade: "+maria.getOld());
		  */
		/* Client maria = new Client();
		 * maria.setId(1); try { SimpleDateFormat formatador= new
		 * SimpleDateFormat("dd/MM/yyyy");
		 * maria.setBirth(formatador.parse("20/12/1999")); //data } catch
		 * (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * 
		 * maria.setName("Maria Jos�"); maria.setSex(new String("M").charAt(0));
		 * maria.setHeight(180); maria.setWeight(80);
		 * maria.setActivity("Sedent�rio");
		 * 
		 * System.out.println("Nome: "+maria.getName());
		 * System.out.println("idade: "+maria.getOld());
		 * System.out.println("Sexo: "+maria.getSex());
		 * System.out.println("TMB:  "+maria.Tmb().substring(0,6));
		 * System.out.println("FCM:  "+maria.Fcm());
		 * System.out.println("IMC:  "+maria.Imc());
		 * System.out.println("Estado: "+maria.getState()); new
		 * ClientDAO(maria).atualizar();
		 */
	}

}
