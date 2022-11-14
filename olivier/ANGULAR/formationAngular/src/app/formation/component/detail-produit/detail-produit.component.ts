import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-detail-produit',
  templateUrl: './detail-produit.component.html',
  styleUrls: ['./detail-produit.component.css'],
})
export class DetailProduitComponent implements OnInit {
  id!: number;

  constructor(private activatedRoute: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    //this.id = this.activatedRoute.snapshot.params['id'];
    this.activatedRoute.params.subscribe((params) => {
      this.id = params['id'];
    });
    //on n'est pas sur d'avoir un resultat dans id
    //subscribe etant un traitement assynchrone
    console.log(this.id);
  }
  retourHome() {
    console.log('du code anuglar');
    this.router.navigateByUrl('/home');
  }
}
