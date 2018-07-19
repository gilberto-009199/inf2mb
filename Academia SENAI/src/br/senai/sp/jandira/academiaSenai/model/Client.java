package br.senai.sp.jandira.academiaSenai.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.JSpinner.DateEditor;

public class Client {
	//	Campos que existem na tabela do Banco de Dados
	private int id; 		//	int ID do registro na tabela 
	private String name;	//	String Nome do cliente
	private char sex;		//	Char sexo do cliente
	private Date birth;		//	date Nacimento do cliente 
	private int weight;		//	int Peso do Cliente
	private double height;	//	Double Altura do cliente
	private String activity;//	String Nivel de Atividade do cliente
	//	Campo que n existe na tabela do Banco de dados 
	private String state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public void setName(String nome) {
		this.name = nome;
	}


	public String getState() {
		return state;
	}
	
	
	public String getName() {
		return name;
	}


	public char getSex() {
		return sex;
	}

	public void setSex(char sexo) {
		this.sex = sexo;
	}
	

	public int getWeight() {
		return weight;
	}

	public void setWeight(int peso) {
		this.weight = peso;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(double altura) {
		this.height = altura;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String Nvestado) {
		this.activity = Nvestado;
	}
	
	public String Imc(){
		double height = this.height/100;
		String x = (weight/((height)*height))+"";
		double c= Double.parseDouble(x.substring(0, 3));
		if(c<=16&&c<16.9){
			state="Muito abaixo do peso \n";
			state+="Queda de cabelo, infertilidade, ausencia menstrual ";
			
		}else{
			if(c>17&&c<18.4){
				state="Abaixo do peso \n";
				state+="Fadiga, stress, ansiedade";
				
			}else{
				if(c>18.5&&c<24.9){
					state="Peso normal \n";
					state+="Menor risco de doen�as cardiacas e vasculares";
					
				}else{
					if(c>24.91&&c<29.9){
						state="Acima do peso \n";
						state+="Fadiga, m� circula��o, varizes ";
						
					}else{
						if(c>29.91&&c<34.9){
							state="Obesidade Grau I \n";
							state+="Diabetes, angina, infarto, aterosclerose ";
							
						}else{
							if(c>35&&c<40){
								state="Obesidade Grau II \n";
								state+="Apneia do sono, falta de ar";
								
							}else{
								if(c>40){
									state="Obesidade Grau III \n";
									state+="Refluxo, dificuldade para se mover, escaras,diabetes, infarto, AVC";
									
								}
							}}}}}}
		return (weight/(height*height)+"").substring(0, 4)+" Kg/m�";
		
	}
	public String Tmb(){
		int age = getOld();
		
		switch(activity){
			case "Sedentário":
				if(sex== new String("M").charAt(0)){
					return ""+((66+(13.7*weight)+(5*height)+(6.8*age))*1.20);
				}else{
					return ""+((665+(9.6*weight)+(1.8*height)-(4.7*age))*1.20);
				}
			case "Levemente Ativo":
				if(sex== new String("M").charAt(0)){
					return ""+((66+(13.7*weight)+(5*height)+(6.8*age))*1.37);
				}else{
					return ""+((665+(9.6*weight)+(1.8*height)-(4.7*age))*1.37);
				}
			case "Moderadamente Ativo":
				if(sex== new String("M").charAt(0)){
					return ""+((66+(13.7*weight)+(5*height)+(6.8*age))*1.55);
				}else{
					return ""+((665+(9.6*weight)+(1.8*height)-(4.7*age))*1.55);
				}
			case "Bastante Ativo":
				if(sex== new String("M").charAt(0)){
					return ""+((66+(13.7*weight)+(5*height)+(6.8*age))*1.72);
				}else{
					return ""+((665+(9.6*weight)+(1.8*height)-(4.7*age))*1.72);
				}
			case "Muito Ativo":
				if(sex== new String("M").charAt(0)){
					return ""+((66+(13.7*weight)+(5*height)+(6.8*age))*1.90);
				}else{
					return ""+((665+(9.6*weight)+(1.8*height)-(4.7*age))*1.90);
				}
			default:
				JOptionPane.showMessageDialog(null, "Erro Frequencia de atividades fisicas n�o preenchido");
				return "nullo";
		}
	}
	
	public double Fcm(){
		int age = getOld();
		if(sex== new String("M").charAt(0)){
			return ((210-(0.5*age))-(weight*0.01))+4;
		}else{
			return ((210-(0.5*age))-(weight*0.01));
		}
	}
	public int getOld() {
		/* 		Metodo Responsavel por definir a idade do cliente
		 * 		pega o Date birth do escopo e retorna a idade atual 
		 */
		Calendar dateDtNascCelendar = new GregorianCalendar();
		Calendar dateAtualCelendar = new GregorianCalendar();
		
		dateDtNascCelendar.setTime(birth);
		int year = dateDtNascCelendar.get(Calendar.YEAR);
		int month = birth.getMonth();
		int day = birth.getDate();
		
		
		int yearAtual = dateAtualCelendar.get(Calendar.YEAR);
		int monthAtual = dateAtualCelendar.get(Calendar.MONTH);
		int dayAtual = dateAtualCelendar.get(Calendar.DATE);
		
		int age = ((yearAtual-year)*365+(monthAtual-month)*30+(dayAtual-day+1))/365;
		
		return age;
	}
	
}
