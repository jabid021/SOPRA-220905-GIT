import { Produit } from './../../../model/produit';
import { ProduitService } from './../../../service/produit.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.css'],
})
export class ProduitListComponent implements OnInit {
  produits: Produit[] = [];

  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.initProduit();
  }

  initProduit() {
    this.produitService.findAll().subscribe((data) => {
      this.produits = data;
    });
  }

  delete(id: number) {
    this.produitService.deleteById(id).subscribe(() => {
      this.initProduit();
    });
  }
}
