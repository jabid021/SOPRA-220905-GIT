import { Produit } from './../../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  nom: string = '';
  prix: number = 0;
  produit!: Produit;

  constructor() {}

  ngOnInit(): void {}

  click() {
    if (this.nom && this.prix != 0) {
      this.produit = new Produit(this.nom, this.prix);
    }
  }
}
