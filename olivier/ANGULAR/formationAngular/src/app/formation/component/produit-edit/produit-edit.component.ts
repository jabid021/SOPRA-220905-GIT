import { Produit } from './../../model/produit';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-produit-edit',
  templateUrl: './produit-edit.component.html',
  styleUrls: ['./produit-edit.component.css'],
})
export class ProduitEditComponent implements OnInit {
  nom: string = '';
  prix: number = 0;

  @Output()
  //produitReady: EventEmitter<Produit> = new EventEmitter();
  produitReady: EventEmitter<any> = new EventEmitter();
  constructor() {}

  ngOnInit(): void {}

  click() {
    if (this.nom && this.prix > 0) {
      //this.produitReady.emit(new Produit(this.nom, this.prix));
      this.produitReady.emit({
        nom: this.nom,
        prix: this.prix,
      });
    }
  }
}
