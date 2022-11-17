import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  constructor(private httpClient: HttpClient) {}

  public findAll(): Observable<any[]> {
    return this.httpClient.get<any[]>(
      'http://localhost:8080/eshop/api/produit'
    );
  }
}
