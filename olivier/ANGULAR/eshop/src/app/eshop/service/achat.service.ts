import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AchatService {
  constructor(private httpClient: HttpClient) {}

  public acheter(achats: any[]): Observable<any[]> {
    return this.httpClient.post<any[]>(
      'http://localhost:8080/eshop/api/achat/list',
      achats
    );
  }
}
