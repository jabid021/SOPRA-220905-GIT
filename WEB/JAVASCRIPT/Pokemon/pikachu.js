//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;
var nom;


inputName.onkeyup=function()
{
  nom = inputName.value;
  if(nom!="")
  {
    btnStart.disabled=false;
  }
  else
  {
    btnStart.disabled=true;
  }
}



btnStart.onclick=function()
{
  pikachu.title=nom;
  grass.style.display="block";
  formStart.style.display="none";
  document.body.onkeyup=mouvement;
  //theme.play();
}


function mouvement(event)
{
  if(event.key=="ArrowUp" || event.key=="z")
  {
    imgPikachu.setAttribute("src","assets/img/pikachuUp.png");
    if(posY>0)
    {
      posY-=30;
      pikachu.style.top=posY+"px";
    }

  }
  else if(event.key=="ArrowDown" || event.key=="s")
  {
    imgPikachu.setAttribute("src","assets/img/pikachuDown.png");

    if(posY<660)
    {
      posY+=30;
      pikachu.style.top=posY+"px";
    }
  }
  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    imgPikachu.setAttribute("src","assets/img/pikachuLeft.png");
    if(posX>0)
    {
      posX-=30;
      pikachu.style.left=posX+"px";
    }

  }

  else if(event.key=="ArrowRight" || event.key=="d")
  {
    imgPikachu.setAttribute("src","assets/img/pikachuRight.png");

    if(posX<660)
    {
      posX+=30;
      pikachu.style.left=posX+"px";
    }

  }


}
