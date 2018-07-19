function procurax(x,r,t){
	switch(x){
		case"0":
			if(r!="0"){
				if(r==t){
					alert("1 para dar venha "+r)//retorna true
				}
			}
			break;
		case"x":
			if(r!="o"){
				if(r==x||x==t){
					alert("1 para dar venha "+r)//retorna true
				}
			}
			break;
		case"o":
			if(r!="x"){
				if(r==x||x==t){
					alert("1 para dar venha "+r) //retorna true
				}
			}
			break;
		default:

	}

}
function adicionaxCentro(){
	if(c2_2.alt=="0"){
		return c2_2.id;//retorna a celula principal para setar com x
	}else{
		return "false";
	}
}

function colocaxAleatoriamente(){
	if(c1_1.alt=="0"){
		c1_1.alt="x"
		c1_1.src="./img/x-icon.png"
	}else{
		if(c1_3.alt=="0"){
			c1_3.alt="x"
			c1_3.src="./img/x-icon.png"
		}else{
			if(c3_1.alt=="0"){
				c3_1.alt="x"
				c3_1.src="./img/x-icon.png"
			}else{
				if(c3_3.alt=="0"){
					c3_3.alt="x"
					c3_3.src="./img/x-icon.png"
				}else{
						alert("Fim de jogo!!!")
						limpa()
				}
			}
		}
	}
}
function colocaAdicionaXaoX(x,r,t){
	var c="false";
	switch(x.alt){
		case"x":
			if(r.alt!="o" && t.alt!="o"){//define se r ou t e bolinha
				c=r.id;
			}else{
				c="false";
			}

			break;
		case"0":
			if(r.alt!="o"&& t.alt!="o"){//define se r ou t e bolinha
				if(r.alt=="x" || t.alt=="x"){//define se r e t = x
					c=x.id;
				}else{
					c="false";
				}
			}else{
				c= "false";
			}
			break;
		default:

	}
	return c;//retorna false caso n seja possivel adicionar mais um permitindo a venha
}

function dizCelulaParaVelhaInimiga(x,r,t){
	var c="false";
	switch(x.alt){
		case"o":
			if(r.alt!="x"&& t.alt!="x"){//define se r ou t e bolinha
				if(r.alt==x.alt||x.alt==t.alt){//define se r ou t e o
					if(r.alt==x.alt){
						c=t.id;
					}else{
						c=r.id;
					}
				}else{
					c="false";
				}
			}else{
				c= "false";
			}

			break;
		case"0":
			if(r.alt!="x"&& t.alt!="x"){//define se r ou t e x
				if(r.alt=="o"&& t.alt=="o"){//define se r e t = o
					c=x.id;
				}else{
					c="false";
				}
			}else{
				c= "false";
			}
			break;
		default:

	}
	return c; //retorna a celula necessaria para evitar a velha do inimigo ou false se não tiver
}

function dizCelulaParaVenha(x,r,t){
	var c="false";
	switch(x.alt){
			case"x":
				if(r.alt!="o"&& t.alt!="o"){//define se r ou t e bolinha
					if(r.alt==x.alt||x.alt==t.alt){//define se r ou t e x
						if(r.alt==x.alt){
							c=t.id;
						}else{
							c=r.id;
						}
					}
				}else{
					c="false";
				}

				break;
			case"0":
				if(r.alt!="o"&& t.alt!="o"){//define se r ou t e bolinha
					if(r.alt=="x"&&t.alt=="x"){//define se r e t = x
						c=x.id;
					}else{
						c="false";
					}
				}else{
					c= "false";
				}
				break;
			default:

		} 
		
	return c; //retorna a celula necessaria para dar velha ou false se não tiver
}
function dificil(){
	var arrayVelha = [	document.getElementById("c1_1"),document.getElementById("c1_2"),
							document.getElementById("c1_3"),document.getElementById("c2_1"),
							document.getElementById("c2_2"),document.getElementById("c2_3"),
							document.getElementById("c3_1"),document.getElementById("c3_2"),
							document.getElementById("c3_3")	]
	var linha =[arrayVelha[0],arrayVelha[1],arrayVelha[2]]//verifica linha
	var coluna=[arrayVelha[0],arrayVelha[3],arrayVelha[6]]//verificador coluna
	var transversal=[arrayVelha[0],arrayVelha[4],arrayVelha[8]]//verificador transversal
	var coluna2 =[arrayVelha[1],arrayVelha[4],arrayVelha[7]]
	var coluna3=[arrayVelha[2],arrayVelha[5],arrayVelha[8]]
	var transversal2=[arrayVelha[2],arrayVelha[4],arrayVelha[6]]
	var linha2=[arrayVelha[3],arrayVelha[4],arrayVelha[5]]
	var linha3=[arrayVelha[6],arrayVelha[7],arrayVelha[8]]
	
	
	if(dizCelulaParaVenha(linha[0],linha[1],linha[2])!="false"){
		var posicao=document.getElementById(dizCelulaParaVenha(linha[0],linha[1],linha[2]))
		posicao.alt="x";
		posicao.src="./img/x-icon.png";
		
	}else if(dizCelulaParaVenha(coluna[0],coluna[1],coluna[2])!="false"){
		var posicao=document.getElementById(dizCelulaParaVenha(coluna[0],coluna[1],coluna[2]))
		posicao.alt="x";
		posicao.src="./img/x-icon.png";
		
	}else if(dizCelulaParaVenha(transversal[0],transversal[1],transversal[2])!="false"){
		var posicao=document.getElementById(dizCelulaParaVenha(transversal[0],transversal[1],transversal[2]))
		posicao.alt="x";
		posicao.src="./img/x-icon.png";
	
	}else if( dizCelulaParaVenha(coluna2[0],coluna2[1],coluna2[2])!="false"){
		var posicao=document.getElementById(dizCelulaParaVenha(coluna2[0],coluna2[1],coluna2[2]))
		posicao.alt="x";
		posicao.src="./img/x-icon.png";
		
	}else if(dizCelulaParaVenha(coluna3[0],coluna3[1],coluna3[2])!="false"){ 
		var posicao=document.getElementById(dizCelulaParaVenha(coluna3[0],coluna3[1],coluna3[2]))
		posicao.alt="x";
		posicao.src="./img/x-icon.png";
		
	}else if(dizCelulaParaVenha(transversal2[0],transversal2[1],transversal2[2])!="false"){
		var posicao=document.getElementById(dizCelulaParaVenha(transversal2[0],transversal2[1],transversal2[2]))
		posicao.alt="x";
		posicao.src="./img/x-icon.png";
	
	}else if(dizCelulaParaVenha(linha2[0],linha2[1],linha2[2])!="false" ){
		var posicao=document.getElementById(dizCelulaParaVenha(linha2[0],linha2[1],linha2[2]))
		posicao.alt="x";
		posicao.src="./img/x-icon.png";
	
	}else if(dizCelulaParaVenha(linha3[0],linha3[1],linha3[2])!="false"){
		var posicao=document.getElementById(dizCelulaParaVenha(linha3[0],linha3[1],linha3[2]))
		posicao.alt="x";
		posicao.src="./img/x-icon.png";
	
	}else{// area que impedi a venha do inimiga ou do bolinha 
		if(dizCelulaParaVelhaInimiga(linha[0],linha[1],linha[2])!="false"){
			var posicao=document.getElementById(dizCelulaParaVelhaInimiga(linha[0],linha[1],linha[2]))
			posicao.alt="x";
			posicao.src="./img/x-icon.png";
		}else if(dizCelulaParaVelhaInimiga(coluna[0],coluna[1],coluna[2])!="false"){
			var posicao=document.getElementById(dizCelulaParaVelhaInimiga(coluna[0],coluna[1],coluna[2]))
			posicao.alt="x";
			posicao.src="./img/x-icon.png";
		}else if(dizCelulaParaVelhaInimiga(transversal[0],transversal[1],transversal[2])!="false"){
			var posicao=document.getElementById(dizCelulaParaVelhaInimiga(transversal[0],transversal[1],transversal[2]))
			posicao.alt="x";
			posicao.src="./img/x-icon.png";
		}else if (dizCelulaParaVelhaInimiga(coluna2[0],coluna2[1],coluna2[2])!="false"){
			var posicao=document.getElementById(dizCelulaParaVelhaInimiga(coluna2[0],coluna2[1],coluna2[2]))
			posicao.alt="x";
			posicao.src="./img/x-icon.png";
		}else if(dizCelulaParaVelhaInimiga(coluna3[0],coluna3[1],coluna3[2])!="false"){
			var posicao=document.getElementById(dizCelulaParaVelhaInimiga(coluna3[0],coluna3[1],coluna3[2]))
			posicao.alt="x";
			posicao.src="./img/x-icon.png";
		}else if(dizCelulaParaVelhaInimiga(transversal2[0],transversal2[1],transversal2[2])!="false"){
			var posicao=document.getElementById(dizCelulaParaVelhaInimiga(transversal2[0],transversal2[1],transversal2[2]))
			posicao.alt="x";
			posicao.src="./img/x-icon.png";
		}else if(dizCelulaParaVelhaInimiga(linha2[0],linha2[1],linha2[2])!="false"){
			var posicao=document.getElementById(dizCelulaParaVelhaInimiga(linha2[0],linha2[1],linha2[2]))
			posicao.alt="x";
			posicao.src="./img/x-icon.png";
		}else if(dizCelulaParaVelhaInimiga(linha3[0],linha3[1],linha3[2])!="false"){
			var posicao=document.getElementById(dizCelulaParaVelhaInimiga(linha3[0],linha3[1],linha3[2]))
			posicao.alt="x";
			posicao.src="./img/x-icon.png";
		}else{	//area de adicionar x ao x
			if(colocaAdicionaXaoX(linha2[0],linha2[1],linha2[2])!="false"){
				var posicao=document.getElementById(colocaAdicionaXaoX(linha2[0],linha2[1],linha2[2]));
				posicao.alt="x";
				posicao.src="./img/x-icon.png";
			}else if(colocaAdicionaXaoX(coluna2[0],coluna2[1],coluna2[2])!="false"){
				var posicao=document.getElementById(colocaAdicionaXaoX(coluna2[0],coluna2[1],coluna2[2]));
				posicao.alt="x";
				posicao.src="./img/x-icon.png";
			}else if(colocaAdicionaXaoX(transversal[0],transversal[1],transversal[2])!="false"){
				var posicao=document.getElementById(colocaAdicionaXaoX(transversal[0],transversal[1],transversal[2]));
				posicao.alt="x";
				posicao.src="./img/x-icon.png";
			}else if(colocaAdicionaXaoX(transversal2[0],transversal2[1],transversal2[2])!="false"){
				var posicao=document.getElementById(colocaAdicionaXaoX(transversal2[0],transversal2[1],transversal2[2]));
				posicao.alt="x";
				posicao.src="./img/x-icon.png";
			}else{	//area de colocar no centro ou colocar aleatoriamente
				if(adicionaxCentro()!="false"){
					c2_2.alt="x";
					c2_2.src="./img/x-icon.png";
				}else{
					 colocaxAleatoriamente()
				}
			}
		}
	}
}