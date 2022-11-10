import { Produit } from './../../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit-display',
  templateUrl: './produit-display.component.html',
  styleUrls: ['./produit-display.component.css'],
})
export class ProduitDisplayComponent implements OnInit {
  @Input()
  produit!: Produit;

  constructor() {}

  ngOnInit(): void {}

  infosProduit(): string {
    if (this.produit) {
      return 'infos du produit:' + this.produit.nom + ' ' + this.produit.prix;
    } else {
      return '';
    }
  }
}
