//Función que anula caracteres no numéricos, pero
//acepta la tecla de retroceso

function AnularPegado(e)
{
  if (e.keyCode==86 && e.ctrlKey)   
     return false;
  else
     return true;
}

function ValidarNumeros(e) 
{
  document.oncontextmenu = function(){return false}  
  var tecla = (document.all)?e.keyCode:e.which;
  if (tecla==8) return true;
  patron = /\d/;
  te = String.fromCharCode(tecla);
  return patron.test(te);
}

  
  

