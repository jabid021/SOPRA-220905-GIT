import { ProduitService } from './../../../service/produit.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list-produit-sec',
  templateUrl: './list-produit-sec.component.html',
  styleUrls: ['./list-produit-sec.component.css'],
})
export class ListProduitSecComponent implements OnInit {
  constructor(private produitSrv: ProduitService) {}

  ngOnInit(): void {
    this.produitSrv.findAll().subscribe((data) => {
      console.log(data);
    });
  }
}
