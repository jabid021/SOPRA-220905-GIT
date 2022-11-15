import { Fournisseur } from './../../../model/fournisseur';
import { FournisseurService } from './../../../service/fournisseur.service';
import { ProduitService } from './../../../service/produit.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from './../../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit-edit',
  templateUrl: './produit-edit.component.html',
  styleUrls: ['./produit-edit.component.css'],
})
export class ProduitEditComponent implements OnInit {
  produit: Produit = new Produit();
  fournisseurs: Fournisseur[] = [];

  constructor(
    private activatedRoute: ActivatedRoute,
    private produitService: ProduitService,
    private fournissuerService: FournisseurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.produitService.findById(params['id']).subscribe((data) => {
          this.produit = data;
        });
      }
    });

    this.fournissuerService.findAll().subscribe((data) => {
      this.fournisseurs = data;
    });
  }

  save() {
    if (this.produit.id) {
      this.produitService.update(this.produit).subscribe((data) => {
        this.router.navigateByUrl('/produit');
      });
    } else {
      this.produitService.create(this.produit).subscribe((data) => {
        this.router.navigateByUrl('/produit');
      });
    }
  }

  byId(frs1: Fournisseur, frs2: Fournisseur) {
    if (frs1 && frs2) return frs1.id == frs2.id;
    return false;
  }
}
