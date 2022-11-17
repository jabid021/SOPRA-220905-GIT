import { ProduitService } from './../../service/produit.service';
import { Produit } from './../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-achat',
  templateUrl: './achat.component.html',
  styleUrls: ['./achat.component.css'],
})
export class AchatComponent implements OnInit {
  produits: Produit[] = [];

  constructor(private produitSrv: ProduitService) {}

  ngOnInit(): void {
    if (!sessionStorage.getItem('panier')) {
      sessionStorage.setItem(
        'panier',
        JSON.stringify(new Map<number, number>())
      );
    }
    this.produitSrv.findAll().subscribe((data) => {
      this.produits = data;
    });
  }

  ajouterPanier(id: number) {
    let map: Map<number, number> = this.panier;
    if (map.has(id)) {
      map.set(id, map.get(id)! + 1);
    } else {
      map.set(id, 1);
    }
    sessionStorage.setItem('panier', JSON.stringify(Object.fromEntries(map)));
  }

  retirerPanier(id: number) {
    let map: Map<number, number> = this.panier;
    if (map.get(id) == 1) {
      map.delete(id);
    } else {
      map.set(id, map.get(id)! - 1);
    }
    sessionStorage.setItem('panier', JSON.stringify(Object.fromEntries(map)));
  }

  get panier(): Map<number, number> {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    let panier: Map<number, number> = new Map<number, number>();
    for (let value in jsonObject) {
      panier.set(parseInt(value), jsonObject[value]);
    }
    return panier;
  }

  getQuantite(id: number): number {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    return jsonObject[id];
  }
}
