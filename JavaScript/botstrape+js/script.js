function formulario( forma){ // Classe responsavel pela estrutura do formulario
    this.tipo   =   forma; // Propriedade que define o tipo de formulario
    this.html   =   "<form><fieldset><legend>Dados "+this.tipo+"</legend>";
    this.MontaCirculo = function(){// carrega o conteudo html do formulario Triangulo na variavel html
        var linha1  =   "<div class='form-row'>"+
            "<div class='form-group col-md-4'>"+
            "<label for='txtDiametro'>Diametro :</label>"+
            "<input class='form-control' id='txtDiametro' type='text' maxlength='40' required='required'>"+
            "</div></div>";
        var linha2 =    "<div class='form-row'>"+
                "<div class='form-group col-md-12'>"+
                "<input style='float:right;' class ='btn  btn-primary' onclick='Main.pegaDados(\"circulo\")' value='Calcular' >"+
                "</div></div>";
        this.html+=linha1+linha2;

    }
    this.MontaTriangulo = function(){// carrega o conteudo html do formulario Triangulo na variavel html
        var linha1  =   "<div class='form-row'>"+
                        "<div class='form-group col-md-4'>"+
                        "<label for='txtAB'>Lado :</label> <input class='form-control' id='txtAB' type='text' maxlength='40' required='required'></div>";

        var linha2  =   "<div class='form-group col-md-4'>"+
                        "<label for='txtAC'>Lado :</label>"+
                        "<input	class='form-control' id='txtAC'"+
                        "type='text' maxlength='40' required='required'>"+
                        "</div>";
        var linha3  =   "<div class='form-group col-md-4'>"+
                        "<label for='txtBC'>Lado :</label>"+
                        "<input	class='form-control' id='txtBC' type='text' maxlength='40' required='required'>"+"</div></div>";

        var linha4  =   "<div class='form-row'><div class='form-group col-md-12' >"+"<input style='float:right;' onclick='Main.pegaDados(\"triangulo\")'"+
            "class='btn  btn-primary'  value='Calcular' >"+
            "</div></div>";

        this.html+=linha1+linha2+linha3+linha4;
    }

    this.MontaQuadrilatero = function(){// carrega o conteudo html do formulario Triangulo na variavel html
        var linha1  =   "<div class='form-row'>"+
                        "<div class='form-group col-md-4'>"+
                        "<label for='txtAltura'>Altura :</label> <input class='form-control' id='txtAltura' type='text' maxlength='40' required='required'></div>";

        var linha2  =   "<div class='form-group col-md-4'>"+
                        "<label for='txtComprimento'>Comprimento :</label>"+
                        "<input	class='form-control' id='txtComprimento'"+
                        "type='text' maxlength='40' required='required'>"+
                        "</div>";
        var linha3  =   "<div class='form-row'><div class='form-group col-md-12' >"+"<input style='float:right;' onclick='Main.pegaDados(\"quadrilatero\")'"+
            "class='btn  btn-primary'  value='Calcular' >"+
            "</div></div>";

        this.html+=linha1+linha2+linha3;
    }
    this.MontaPoligono = function(){// carrega o conteudo html do formulario Triangulo na variavel html
        var linha1  =   "<div class='form-row'>"+
                        "<div class='form-group col-md-4'>"+
                        "<label for='txtLados'>Numero de lados :</label> <input class='form-control' id='txtLados' type='text' maxlength='40' required='required'></div>";

        var linha2  =   "<div class='form-group col-md-4'>"+
                        "<label for='txtComprimento'>Comprimento :</label>"+
                        "<input	class='form-control' id='txtComprimento'"+
                        "type='text' maxlength='40' required='required'>"+
                        "</div>";
        var linha3  =   "<div class='form-row'><div class='form-group col-md-12' >"+"<input style='float:right;' onclick='Main.pegaDados(\"poligono\")'"+
            "class='btn  btn-primary'  value='Calcular' >"+
            "</div></div>";

        this.html+=linha1+linha2+linha3;
    }
    this.criaformulario = function(){ // determina o html do formulario e retorna o html do formulario
        switch (this.tipo) {
          case "Circulo":
              this.MontaCirculo();
              break;
          case "Triangulo":
              this.MontaTriangulo();
              break;
          case "Quadrilátero":
              this.MontaQuadrilatero();
              break;
          case "Polígono regular":
              this.MontaPoligono();
              break;
        }
        this.html+="</fieldset></form>";
        return this.html;
    }
}



            function Circulo(diametro) {// Classe responsavel pela forma Circulo e suas propriedades
                    	this.Diametro = diametro;
                    	this.Raio = function() { // Metodo que retorna o raio do circulo baseado no diametro
                    		return this.Diametro / 2
                    	};
                    	this.Area = function() {// Metodo que retorna a Area do circulo baseado no raio e  em PI
                    		area = Math.PI * (Math.pow(this.Raio(), 2));
                    		return area.toFixed(2); /*reduz o numero de casas decimais*/
                    	}
                    	this.Perimetro = function() { // Metodo que retorna o perimetro do circulo baseado no raio e em PI
                    		perimetro = Math.PI * this.Raio() * 2;
                    		return perimetro.toFixed(3);
                    	}
                    }

            function Triangulo(ab, ac, bc) {// Classe responsavel pela forma Triangulo e suas propriedades
                    	this.tipo = "indefinido";
                    	this.AB = ab;// propriedade que fefine o lado AB do triangulo
                    	this.AC = ac;// propriedade que fefine o lado AC do triangulo
                    	this.BC = bc;// propriedade que fefine o lado BC do triangulo
                    	this.ladoM = null;
                    	// Define o maior lado e o tipo de triangulo
                    	if ((Math.max(ab, ac, bc)) == (Math.min(ab, ac, bc))) {// determina se os lados são iquais
                    		this.ladoM = 0;
                    		this.tipo = "equilatero" //Devine o triangulo como sendo do tipo equilatero
                    	} else { //procedimentos para verificar se e isoceles ou escaleno
                    		switch (ab) { //SE FOR ISOCELES Acha o lado diferete do triangulo SE NÃO ENTAO DEFINE O TRIANGULO COMO ESCALENO
                    			case this.AC: //verifica se o valor é o mesmo
                    				this.ladoM = 3;// determina o lado BC como o diferente no isoceles
                    				this.tipo = "isoceles";
                    				break;
                    			case this.BC:
                    				this.ladoM = 2;// determina o lado AC como o diferente no isoceles
                    				this.tipo = "isoceles";
                    				break;
                    			default:
                    				//procedimeto que define ab como sendo o lado diferente ou se o triangulo é escaleno!
                    				if (ac == bc) {
                    					this.ladoM = 1;// determina o lado AB como o diferente no isoceles
                    					this.tipo = "isoceles";
                    				} else {//DEFINE QUAL É O MAIOR LADO DO TRIANGULO ESCALENO
                    					if (this.AB > this.AC && this.AB > this.BC) {
                    						this.ladoM = 1; // Define o lado AB como sendo o maior
                    					} else if (this.AC > this.BC && this.AC > this.AB) {
                    						this.ladoM = 2;// Define o lado AC como sendo o maior
                    					} else if (this.BC > this.AC && this.BC > this.AB) {
                    						this.ladoM = 3 // Define o lado BC como sendo o maior
                    					}
                    					this.tipo = "escaleno"; // Define o tipo de triangulo como escaleno
                    				}
                    		}
                    	}
                    	this.Existe = function() { //Verifica se o triangulo existe
                    		//verifica se a soma dos lado e maior que a hipotenusa
                        var exist = true;
                        if(this.tipo=="isoceles"){
                          return exist;
                        }
                    		switch (this.ladoM) {
                    			case 1:
                    				if ((this.BC + this.AC) > this.AB) {

                    				} else {
                    					alert("Triangulo  não Existe!")
                              var exist = false;
                    				}
                    				break;
                    			case 2:
                    				if ((this.AB + this.BC) > this.AC) {

                    				} else {
                    					alert("Triangulo  não Existe!")
                              var exist = false;
                    				}
                    				break;
                    			case 3:
                    				if ((this.AB + this.AC) > this.BC) {

                    				} else {

                              var exist = false;
                    				}
                    				break;
                    			case 0:
                    				alert("Triangulo Equilatero")
                    				break;
                    		}
                        return exist;
                    	}
                    	this.Area = function() {
                    		var area = 0;
                    		if (this.tipo == "escaleno") {
                    			//Procedimento para calcular  a area do escaleno
                    			var s = (this.AB + this.AC + this.BC) / 2;
                    			area = Math.sqrt(s * (s - this.AB)*(s - this.AC)*(s - this.BC));
                    		} else if (this.tipo == "equilatero") {
                    			base = this.BC / 2; //devine a base como BC sendo que todos os lados são iguais
                    			hipotenusa = this.AC;
                    			altura = Math.sqrt((Math.pow(hipotenusa, 2)) - (Math.pow(base, 2)));
                    			area = altura * base;
                    		} else {
                    			if (this.ladoM == 1) {
                    				base = this.AB / 2; //devine a base como sendo o lado diferente
                    				hipotenusa = this.AC; // devine a hipotenusa como o valor dos lados iquais
                    			} else if (this.ladoM == 2) {
                    				base = this.AC / 2;
                    				hipotenusa = this.AB;
                    			} else {
                    				base = this.BC / 2;
                    				hipotenusa = this.AB;
                    			}
                    			altura = Math.sqrt((Math.pow(hipotenusa, 2)) - (Math.pow(base, 2)));
                    			area = altura * base;
                    		}
                    		return area.toFixed(2); /*reduz o numero de casas decimais*/ ;
                    	}
                    	this.Perimetro = function() {// Metodo que retorna o perimetro do triangulo
                    		return (this.AB + this.AC + this.BC);
                    	}
                    }

                    function Quadrilatero(altura, largura) {// Classe responsavel pela forma Quadrilatro e suas propriedades
                    	this.altura = altura;
                    	this.largura = largura;
                      this.tipo = function(){
                        if(this.altura==this.largura){
                          return "Quadrado";
                        }
                        return "Retangulo";
                      }
                    	this.Existe = function() {// Verifica se a integridade na figura
                    		if (this.altura == 0 || this.largura == 0) {// define se o quadrilario existe
                    			alert(" O quadrilario não exite !")
                          return false;
                    		}
                        return true;
                    	}
                    	this.Perimetro = function() {// Metodo que retorna o perimetro da figura
                    		return ((this.altura * 2) + (this.largura * 2));
                    	}
                    	this.Area = function() {// Metodo que retorna o area da figura
                    		return (this.altura * this.largura).toFixed(2);//reduz o numero de casas decimais de retorno
                    	}
                    }

                    function Poligono(numerolado, comprimentoLado) {// Classe responsavel pela formas  regulares Poligonos e suas propriedades
                    	this.NumeroLados = numerolado; //define o numero de lados da figura
                    	this.Comprimento = comprimentoLado; //define o comprimeto de cada um dos lados
                    	if (numerolado < 5) {
                    		alert("O Poligono criado não existe!")
                    	}
                    	this.Apotema = function() { // Metodo que retorna o apotema da figura baseado na tangente  numero de lados
                        // retorna a tangente de (180° por numero de lados)/3  *10
                    		return ((Math.tan(180 / this.NumeroLados)) / 3) * 10;
                    	}
                    	this.Perimetro = function() {// metodo que retorna o perimetro da figura
                    		// Retorna o perimetro baseado no comprimento de cada lado * numero de lados
                    		return (this.NumeroLados * this.Comprimento);
                    	}
                    	this.Area = function() {// Metodo que retorna a area da figura
                        // retorna a area da figura baseado no perimetro e no apotema da figura
                    		var area = (this.Perimetro() * this.Apotema()) / 2;
                    		return area.toFixed(2);//reduz o numero de casas decimais de retorno
                    	}
                    }

                    function calcular(elemento) {


                        var formul  =   new formulario(elemento.text());
                        formul.MontaTriangulo();
                        //alert(formul.html);
                        formula.innerHTML = formul.html;

                        /*
                    	alert("inserindo um poligono de 12 lados com 4 de comprimento");
                    	var polinonio = new Poligono(9, 6);
                    	alert(" A area do poligono é " + polinonio.Area());*/

                    	//var poligono = new Poligono(12,4);
                    	/*
                    	 *   Quadrilatero
                    	 *   var largura =   prompt(" Digite o valor da largura: ")*1;
                    	 *   var altura  =   prompt(" Digite o valor da altura : ")*1;
                    	 *   var quarilatero = new Quadrilatero(altura,largura);
                    	 *   quarilatero.Existe();
                    	 *   alert(" A area do triangulo é "+quarilatero.Area()+"cm²");
                    	 */
                    	/*
                    	 *   Triangulo
                    	 *   var AB=prompt(" Digite o valor de AB: ")*1;
                    	 *   var AC=prompt(" Digite o valor de AC: ")*1;
                    	 *   var BC=prompt(" Digite o valor de BC: ")*1;
                    	 *   var triang = new Tringulo(AB,AC,BC);
                    	 *   triang.Existe();
                    	 *   alert("Checando se a area chega area:"+triang.Area()+"cm²");
                    	 */
                    	/*
                    	 *   Circulo Teste
                    	 *   alert(" Recebendo  area : "+new Circulo(12).Area()+"cm²");
                    	 *   alert(" Recebendo "+new Circulo(12).Perimetro()+" como perimetro!");
                    	 */
                    }

// Varieaveis Globais

window.conteudoTabela = [];

if((JSON.parse(localStorage.getItem("cokieTabela")))!= null){
  conteudoTabela =JSON.parse(localStorage.getItem("cokieTabela"));
}
//JSON.parse(localStorage.getItem("cokieTabela"));
var Main = new function() {// CLASSE PRINCIPAL AONDE SE CENTRA A PARTE DO CONTROLE E A INDEGRAÇÃO COM OS MODELOS E O VISUAL
  //var linhaDefault = {figura:"",tipo:"",area:"",perimetro:"",datahora:""};
  this.pegaDados = function(tipoformulario){

    var validaReal  = /^([0-9.])+$/;
    var validaNumerico  = /^([0-9])+$/;

    switch (tipoformulario) {
      case "circulo":

        var diametro = txtDiametro.value;
        if(!validaReal.test(diametro)){
				    alert(" Por favor, digite um valor no perimetro ");
            txtDiametro.style.border="solid 1px  red";
            break;}
        var circuloTemp= new Circulo(diametro*1);
        var linhaconteudo = {figura:"",tipo:"",area:"",perimetro:"",datahora:""};
        linhaconteudo.area = circuloTemp.Area()+" cm²";
        linhaconteudo.perimetro = circuloTemp.Perimetro()+" cm";
        var dateTemp = new Date();
        linhaconteudo.datahora = dateTemp.getDate()+"/"+dateTemp.getMonth()+"/"+dateTemp.getFullYear()+" "+dateTemp.getHours()+":"+dateTemp.getMinutes()+":"+dateTemp.getSeconds();
        linhaconteudo.figura="Circulo";
        linhaconteudo.tipo="redondo"
        //adiciona no objeto
        this.Grava(linhaconteudo);
        break;
      case "triangulo":

        var AB = txtAB.value*1;
        var AC = txtAC.value*1;
        var BC = txtBC.value*1;

        if(!validaReal.test(AB)){
          alert(" Por favor, digite um valor na caixa ");
          txtAB.style.border="solid 1px  red";
          break;
        }
        if(!validaReal.test(AC)){
          alert(" Por favor, digite um valor na caixa ");
          txtAC.style.border="solid 1px  red";
          break;
        }
        if(!validaReal.test(BC)){
          alert(" Por favor, digite um valor na caixa ");
          txtBC.style.border="solid 1px  red";
          break;
        }

        var trianguloTemp = new Triangulo(AB,AC,BC);
        if(!trianguloTemp.Existe()){
          break;
        }
        var linhaconteudo = {figura:"",tipo:"",area:"",perimetro:"",datahora:""};
        linhaconteudo.area = trianguloTemp.Area()+" cm²";
        linhaconteudo.perimetro = trianguloTemp.Perimetro()+" cm";
        var dateTemp = new Date();
        linhaconteudo.datahora = dateTemp.getDate()+"/"+dateTemp.getMonth()+"/"+dateTemp.getFullYear()+" "+dateTemp.getHours()+":"+dateTemp.getMinutes()+":"+dateTemp.getSeconds();
        linhaconteudo.figura="Triangulo";
        linhaconteudo.tipo=trianguloTemp.tipo;
        //adiciona no objeto
        this.Grava(linhaconteudo);
        break;
      case "quadrilatero":

        var altura = txtAltura.value*1;
        var comprimento = txtComprimento.value*1;

        if(!validaReal.test(altura)){
          alert(" Por favor  digite um valor como Altura ");
          txtAltura.style.border="solid 1px  red";
          break;
        }
        if(!validaReal.test(comprimento)){
          alert(" Por favor  digite um valor como Comprimento ");
          txtComprimento.style.border="solid 1px  red";
          break;
        }

        var quadrilateroTemp = new Quadrilatero(altura,comprimento);
        if(!quadrilateroTemp.Existe()){
              break;
        }
        var linhaconteudo = {figura:"",tipo:"",area:"",perimetro:"",datahora:""};
        linhaconteudo.area = quadrilateroTemp.Area()+" cm²";
        linhaconteudo.perimetro = quadrilateroTemp.Perimetro()+" cm";
        var dateTemp = new Date();
        linhaconteudo.datahora = dateTemp.getDate()+"/"+dateTemp.getMonth()+"/"+dateTemp.getFullYear()+" "+dateTemp.getHours()+":"+dateTemp.getMinutes()+":"+dateTemp.getSeconds();
        linhaconteudo.figura="quadrilatero";
        linhaconteudo.tipo=quadrilateroTemp.tipo();
        //adiciona no objeto
        this.Grava(linhaconteudo);
        break;
      case "poligono":

        var numeroLados = txtLados.value*1;
        var comprimento = txtComprimento.value*1;
        var validaladosPoligono =  /^([4-9])+$/;

        if(!validaladosPoligono.test(numeroLados)){
          alert(" Por favor, digite um numero  de 4 a 9 em lados");
          txtLados.style.border="solid 1px  red";
          break;
        }
        if(numeroLados<=4)break;

        if(!validaReal.test(comprimento)){
          alert(" Por favor, digite um numero em Lados ");
          txtComprimento.style.border="solid 1px  red";
          break;
        }
        var poligonoTemp = new Poligono(numeroLados,comprimento);
        var linhaconteudo = {figura:"",tipo:"",area:"",perimetro:"",datahora:""};
        linhaconteudo.area = Math.abs(poligonoTemp.Area())+" cm²";
        linhaconteudo.perimetro = Math.abs(poligonoTemp.Perimetro())+" cm";
        var dateTemp = new Date();
        linhaconteudo.datahora = dateTemp.getDate()+"/"+dateTemp.getMonth()+"/"+dateTemp.getFullYear()+" "+dateTemp.getHours()+":"+dateTemp.getMinutes()+":"+dateTemp.getSeconds();
        linhaconteudo.figura="poligono";
        linhaconteudo.tipo="Lados "+poligonoTemp.NumeroLados;
        //adiciona no objeto
        this.Grava(linhaconteudo);
        break;
    }
  }
  this.montaform = function(elemento){
    var formul  =   new formulario(elemento.innerHTML);
    formula.innerHTML = formul.criaformulario();
  }

  this.Grava = function(linhaconteudo){
    conteudoTabela.push(linhaconteudo);
    var jsonTabela = JSON.stringify(conteudoTabela);
    localStorage.setItem("cokieTabela", jsonTabela);
    this.criaTabela();
  }

  this.criaTabela = function(){
    var table = document.createElement("table");
    var tblBody = document.createElement("tbody");
    var linhatitulo =document.createElement("thead");
    var linha = document.createElement("tr");

    var tituloFigura = document.createElement("th");
    tituloFigura.innerHTML="Figura";
    var tituloTipo  = document.createElement("th");
    tituloTipo.innerHTML="Tipo";
    var tituloArea  = document.createElement("th");
    tituloArea.innerHTML="Área";
    var tituloPerimetro  = document.createElement("th");
    tituloPerimetro.innerHTML="Perimetro";
    var tituloData  = document.createElement("th");
    tituloData.innerHTML="Data/Hora";
    linha.appendChild(tituloFigura);
    linha.appendChild(tituloTipo);
    linha.appendChild(tituloArea);
    linha.appendChild(tituloPerimetro);
    linha.appendChild(tituloData);
    linhatitulo.appendChild(linha);
    for(var i=0;i<conteudoTabela.length;i++){
      var linhatemp = document.createElement("tr");
      var celulaFigura = document.createElement("td");
      var celulaTipo = document.createElement("td");
      var celulaArea = document.createElement("td");
      var celulaPerimetro = document.createElement("td");
      var celulaData = document.createElement("td");
      celulaFigura.innerHTML=conteudoTabela[i].figura;
      celulaTipo.innerHTML=conteudoTabela[i].tipo;
      celulaArea.innerHTML=conteudoTabela[i].area;
      celulaPerimetro.innerHTML=conteudoTabela[i].perimetro;
      celulaData.innerHTML=conteudoTabela[i].datahora;
      linhatemp.appendChild(celulaFigura);
      linhatemp.appendChild(celulaTipo);
      linhatemp.appendChild(celulaArea);
      linhatemp.appendChild(celulaPerimetro);
      linhatemp.appendChild(celulaData);
      tblBody.appendChild(linhatemp);
    }

    //tblBody.appendChild(linha);
    table.appendChild(linhatitulo);
    table.appendChild(tblBody);
    table.className="table table-striped";
    espaçotabela.innerHTML="";
    espaçotabela.appendChild(table);
  }
}
