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

  constructor(
    private activatedRoute: ActivatedRoute,
    private produitService: ProduitService,
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
}
