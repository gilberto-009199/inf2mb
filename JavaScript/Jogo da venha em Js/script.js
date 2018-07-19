var timer;
var celulax;
window.onload = function () {
	audio.play()
	setInterval(toca, 1000);
    timer=setInterval(venha, 840);
}
var token=1;
function verifica_ai(){
	if(radio1.checked){
		return false;
	}
	if(radio2.checked){
		return false;
	}
	if(radio3.checked){
		return false;
	}
	return true;
}
function inicia_ai(){
	verifica_venha()
	if(radio1.checked){
		facil()
	}
	if(radio2.checked){
		intermediario()
	}
	if(radio3.checked){
		dificil()//inicia robo para o estado atual
	}
	return true;
}


	//	radio1.checked retorna true
function toca(){
	audio.play()
}
function limpa(){
	c1_1.alt=""
	c1_2.src="./img/blue-background2.jpg"
	c1_3.alt=""
	c2_1.src="./img/blue-background2.jpg"
	c2_2.alt=""
	c2_3.src="./img/blue-background2.jpg"
	c3_1.alt=""
	c3_2.src="./img/blue-background2.jpg"
	c3_3.alt=""
	vezimg.alt="o"
	vezimg.src="./img/o-icon.png"
	vez.value="Sua vez O"
}
function defini_celula(x){
	posicao=document.getElementById(x);
	if(verifica_ai()){
		switch(posicao.alt){
			case "0":
				if(vezimg.alt=="o"){
					posicao.src="./img/o-icon.png"
					posicao.alt="o"
					vezimg.alt="x"
					vezimg.src="./img/x-icon.png"
					vez.value="Sua vez X"
				}else{
					posicao.alt="x"
					posicao.src="./img/x-icon.png"
					vezimg.alt="o"
					vezimg.src="./img/o-icon.png"
					vez.value="Sua vez O"
				}
			default:

		}
	}else{
		//area da ai e do jogador
			vez.value=="Sua vez O"
			verifica_venha()
			posicao.src="./img/o-icon.png"
			posicao.alt="o"
			verifica_venha()
			vez.value="Sua vez X"
			inicia_ai()
	}
	verifica_venha()
}
function verifica_venha(){
	for (i=0;i<9;i++){
		var arrayVelha = [	document.getElementById("c1_1"),document.getElementById("c1_2"),
							document.getElementById("c1_3"),document.getElementById("c2_1"),
							document.getElementById("c2_2"),document.getElementById("c2_3"),
							document.getElementById("c3_1"),document.getElementById("c3_2"),
							document.getElementById("c3_3")	]
		switch(arrayVelha[i].id){
			case"c1_1":
				verifica(arrayVelha[i].alt,arrayVelha[i+1].alt,arrayVelha[i+2].alt)//verifica linha
				verifica(arrayVelha[i].alt,arrayVelha[i+3].alt,arrayVelha[i+6].alt)//verificador coluna
				verifica(arrayVelha[i].alt,arrayVelha[i+4].alt,arrayVelha[i+8].alt)//verificador transversal
				break;
			case"c1_2":
				verifica(arrayVelha[i].alt,arrayVelha[i+3].alt,arrayVelha[i+6].alt)
				break;
			case"c1_3":
				verifica(arrayVelha[i].alt,arrayVelha[i+2].alt,arrayVelha[i+4].alt)
				verifica(arrayVelha[i].alt,arrayVelha[i+3].alt,arrayVelha[i+6].alt)
				break;
			case"c2_1":
				verifica(arrayVelha[i].alt,arrayVelha[i+1].alt,arrayVelha[i+2].alt)
				break;
			//case"c2_2":
			//	verifica(arrayVelha[i].alt,arrayVelha[i+1].alt,arrayVelha[i+2].alt)
			//	break;
			case"c3_1":
				verifica(arrayVelha[i].alt,arrayVelha[i+1].alt,arrayVelha[i+2].alt)
				break;
			default:

		}
	}
}
function verifica(x,r,t){
	if(x=="0" || r=="0" ||t=="0"){
	}else{

		if(x==r && r==t){
			alert("Velha!!!")
			token=2;
			clearInterval(timer)
		var arrayVelha = [	document.getElementById("c1_1"),document.getElementById("c1_2"),
							document.getElementById("c1_3"),document.getElementById("c2_1"),
							document.getElementById("c2_2"),document.getElementById("c2_3"),
							document.getElementById("c3_1"),document.getElementById("c3_2"),
							document.getElementById("c3_3")	]

		if(vez.value=="Sua vez X"){
			alert("O o venceu !!")
			for (i=0;i<=9;i++){
				arrayVelha[i].src="./img/o-icon.png"
				vez.value="O venceu!!"
			}
			final;
		}else{
			alert("O x venceu !!")
			for (i=0;i<=9;i++){
				arrayVelha[i].src="./img/x-icon.png"
				vez.value="X venceu!!"
			}
			final;
		}
		}
	}

}
function venha(){
	if(token==1){
		switch(velhatabela.bgColor){
			case"#00ff1d":
				velhatabela.bgColor="red";
				break;
			case"red":
				velhatabela.bgColor="blue";
				break;
			case"blue":
				velhatabela.bgColor="yellow";
				break;
			case"yellow":
				velhatabela.bgColor="Aqua";
				break;
			case"Aqua":
				velhatabela.bgColor="AliceBlue";
				break;
			case"AliceBlue":
				velhatabela.bgColor="BlueViolet";
				break;
			case"BlueViolet":
				velhatabela.bgColor="DarkSeaGreen";
				break;
			case"DarkSeaGreen":
				velhatabela.bgColor="ForestGreen ";
				break;
			case"ForestGreen":
				velhatabela.bgColor="#00ff1d";
				break;
			default:
				velhatabela.bgColor="#00ff1d";
		}
	}else{
		
	}
}
