function validar(){
	
	//validador de nome completo
			var Nome = document.getElementById("txtNome")
			var validaNome = /^[A-Za-zÀ-ÿ ]+$/ 
			/* \W  \w */
			
			if(!validaNome.test(Nome.value)){
				alert(" Nome Insuficiente! ")
				erNome.style.border="solid 1px  red"
			}
			
			var data = document.getElementById("txtData")
			var validaData = /^((0[1-9]|([1-2][0-9]|3[0-1]))\/(0[1-9]|1[0-2])\/[0-9]{4})+$/ 
			alert(" Data Digitada: "+data.value)
			if(!validaData.test(data.value)){
				alert(" Data Incorreta! ")
				data.style.border="solid 1px  red"
			}
			var email = document.getElementById("txtEmail")
			var validaemail = /^([a-z.1-9]+@[a-z]*.*)+$/ 
			
			if(!validaemail.test(email.value)){
				alert(" E-mail  Incorreto! ")
				txtEmail.style.border="solid 1px  red"
			}
			
			var cel = document.getElementById("txtCelular")
			var validaCelular = /^(\([0-9]{2}\)9[0-9]{4}-[0-9]{4})+$/
			
			if(!validaCelular.test(cel.value)){
				alert("Celular incorreto!")
				txtCelular.style.border="solid 1px  red"
			}
			
			var rg = document.getElementById("rg")
			var validarg = /^[0-9]{2}\.[0-9]{3}\.[0-9]{3}-[0-9]+$/
			
			if(!validarg.test(rg.value)){
				alert("RG incorreto!")
				rg.style.border="solid 1px  red"
			}
			var cpf = document.getElementById("cpf")
			var validacpf = /^([0-9]{3}\.[0-9]{3}\.[0-9]{3}-[0-9]{2})+$/
			
			if(!validacpf.test(cpf.value)){
				alert("CPF incorreto!")
				cpf.style.border="solid 1px  red"
			}
			
			var numero = document.getElementById("txtNumero")
			var validanumero = /(^[0-9]+$)/
			
			if(!validanumero.test(numero.value)){
				alert("Numero incorreto!")
				txtNumero.style.border="solid 1px  red"
			}
			
			var cep = document.getElementById("txtCep")
			var validacep = /^([0-9]{5}-[0-9]{3})+$/
			
			if(!validacep.test(cep.value)){
				alert("CEP incorreto!")
				txtCep.style.border="solid 1px  red"
			}
}
function nomepadrao(id){
	item = document.getElementById(id)
	item.style.border="solid 1px  blue"
	
}
