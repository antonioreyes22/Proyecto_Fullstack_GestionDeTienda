import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-inicio',
  imports: [CommonModule],
  templateUrl: './inicio.html',
  styleUrl: './inicio.css',
})
export class Inicio {

  listaMuestra: string[] = [];
  centralIndex: number = 0;
  
  constructor()
  {
    this.listaMuestra = 
    [
      'img/camiseta1.png',
      'img/camiseta2.png',
      'img/camiseta3.png',
    ]
  }

  next()
  {
    if((this.centralIndex+1) >= this.listaMuestra.length)
      {
        this.centralIndex = 0;
      }
      else this.centralIndex++; 
  }

  before(){
    if((this.centralIndex-1) < 0)
      {
        this.centralIndex = this.listaMuestra.length-1;
      }
      else this.centralIndex--; 
  }

  get centro(){
    return this.listaMuestra[this.centralIndex];
  }

  get izquierda()
  {
    if((this.centralIndex - 1) < 0)
      {
        return this.listaMuestra[this.listaMuestra.length-1];
      }
      else return this.listaMuestra[this.centralIndex - 1];
  }
  
  get derecha()
  {
    if((this.centralIndex + 1) >= this.listaMuestra.length)
      {
        return this.listaMuestra[0];
      }
      else return this.listaMuestra[this.centralIndex + 1];
  }
}
