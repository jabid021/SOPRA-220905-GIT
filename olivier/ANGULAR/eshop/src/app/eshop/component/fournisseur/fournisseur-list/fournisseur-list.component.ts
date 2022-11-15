import { Fournisseur } from './../../../model/fournisseur';
import { Observable } from 'rxjs';
import { FournisseurService } from './../../../service/fournisseur.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fournisseur-list',
  templateUrl: './fournisseur-list.component.html',
  styleUrls: ['./fournisseur-list.component.css'],
})
export class FournisseurListComponent implements OnInit {
  fournisseursObservable!: Observable<Fournisseur[]>;

  constructor(private fournisseurSrv: FournisseurService) {}

  ngOnInit(): void {
    this.fournisseursObservable = this.fournisseurSrv.findAll();
  }

  delete(id: number) {
    this.fournisseurSrv.deleteById(id).subscribe(() => {
      this.fournisseursObservable = this.fournisseurSrv.findAll();
    });
  }
}
