import { FournisseurService } from './fournisseur.service';
import { Produit } from './../model/produit';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  constructor(
    private httpClient: HttpClient,
    private fournisseurSrv: FournisseurService
  ) {}

  public findAll(): Observable<Produit[]> {
    return this.httpClient.get<Produit[]>(
      'http://localhost:8080/eshop/api/produit'
    );
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(
      `http://localhost:8080/eshop/api/produit/${id}`
    );
  }

  public findById(id: number): Observable<Produit> {
    return this.httpClient.get<Produit>(
      `http://localhost:8080/eshop/api/produit/${id}`
    );
  }

  public update(produit: Produit): Observable<Produit> {
    console.debug(produit);
    return this.httpClient.put<Produit>(
      `http://localhost:8080/eshop/api/produit/${produit?.id}`,
      produit
    );
  }

  public create(produit: Produit): Observable<Produit> {
    console.debug(produit);
    return this.httpClient.post<Produit>(
      'http://localhost:8080/eshop/api/produit',
      this.produitToJson(produit)
    );
  }

  private produitToJson(produit: Produit): any {
    let produitEnJsonPourJava = {
      libelle: produit.libelle,
      prix: produit.prix,
      fournisseur: this.fournisseurSrv.fournisseurToJson(produit.fournisseur!),
    };
    return produitEnJsonPourJava;
  }
}
