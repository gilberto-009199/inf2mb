
var total = 398*1;

setInterval(function(){
	total++;
	document.getElementById("numero").innerHTML="Ameaças detectadas: 192."+total;

}
, 4500);
/*
$(function(){
	$("a").mouseenter(function(){
        palavra = x.innerHTML;
		relogioTmp = setTimeout(cripta(this), 400);
    });
});*/