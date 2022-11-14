import { Produit } from './../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-produit',
  templateUrl: './list-produit.component.html',
  styleUrls: ['./list-produit.component.css'],
})
export class ListProduitComponent implements OnInit {
  produits: Produit[] = [
    new Produit('velo', 100),
    new Produit('pomme', 1),
    new Produit('voiture', 10000),
  ];

  constructor() {}

  ngOnInit(): void {}

  recuperationProduit(produit: any) {
    this.produits.push(new Produit(produit.nom, produit.prix));
  }
}
