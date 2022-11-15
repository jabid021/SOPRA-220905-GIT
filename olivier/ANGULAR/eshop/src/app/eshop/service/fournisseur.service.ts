import { Fournisseur } from './../model/fournisseur';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class FournisseurService {
  static URL: string = 'http://localhost:8080/eshop/api/fournisseur';

  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<Fournisseur[]> {
    return this.httpClient.get<Fournisseur[]>(FournisseurService.URL);
  }

  public findById(id: number): Observable<Fournisseur> {
    return this.httpClient.get<Fournisseur>(`${FournisseurService.URL}/${id}`);
  }

  public deleteById(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${FournisseurService.URL}/${id}`);
  }

  public update(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.httpClient.put<Fournisseur>(
      `${FournisseurService.URL}/${fournisseur.id}`,
      this.fournisseurToJson(fournisseur)
    );
  }
  public create(fournisseur: Fournisseur): Observable<Fournisseur> {
    return this.httpClient.post<Fournisseur>(
      FournisseurService.URL,
      this.fournisseurToJson(fournisseur)
    );
  }

  public fournisseurToJson(fournisseur: Fournisseur): any {
    let fournisseurJson = {
      prenom: fournisseur.prenom,
      nom: fournisseur.nom,
      societe: fournisseur.societe,
    };
    if (fournisseur.adresse) {
      Object.assign(fournisseurJson, {
        adresse: {
          numero: fournisseur.adresse.numero,
          voie: fournisseur.adresse.voie,
          ville: fournisseur.adresse.ville,
          cp: fournisseur.adresse.cp,
        },
      });
    }
    if (fournisseur.id) {
      Object.assign(fournisseurJson, { id: fournisseur.id });
    }
    return fournisseurJson;
  }
}
