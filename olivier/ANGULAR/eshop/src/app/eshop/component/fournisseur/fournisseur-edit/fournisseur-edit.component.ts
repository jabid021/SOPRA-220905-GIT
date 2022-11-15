import { Fournisseur } from './../../../model/fournisseur';
import { FournisseurService } from './../../../service/fournisseur.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fournisseur-edit',
  templateUrl: './fournisseur-edit.component.html',
  styleUrls: ['./fournisseur-edit.component.css'],
})
export class FournisseurEditComponent implements OnInit {
  fournisseur: Fournisseur = new Fournisseur();
  constructor(
    private activatedRoute: ActivatedRoute,
    private fournisseurSrv: FournisseurService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (params['id']) {
        this.fournisseurSrv.findById(params['id']).subscribe((data) => {
          this.fournisseur = data;
        });
      }
    });
  }

  save() {
    if (this.fournisseur.id) {
      this.fournisseurSrv
        .update(this.fournisseur)
        .subscribe(() => this.router.navigateByUrl('/fournisseur'));
    } else {
      this.fournisseurSrv.create(this.fournisseur).subscribe(() => {
        this.router.navigateByUrl('/fournisseur');
      });
    }
  }
}
