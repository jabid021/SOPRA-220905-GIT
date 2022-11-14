import { Produit } from './../../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  produit!: Produit;

  constructor() {}

  ngOnInit(): void {}

  produitRecu(produit: Produit) {
    this.produit = produit;
  }
}
