import { Router } from '@angular/router';
import { AchatService } from './../../service/achat.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-validation-achat',
  templateUrl: './validation-achat.component.html',
  styleUrls: ['./validation-achat.component.css'],
})
export class ValidationAchatComponent implements OnInit {
  constructor(private achatSrv: AchatService, private router: Router) {}

  ngOnInit(): void {
    let jsonObject = JSON.parse(sessionStorage.getItem('panier')!);
    let achats = [];
    for (let key in jsonObject) {
      achats.push({ quantite: jsonObject[key], produit: { id: key } });
    }
    this.achatSrv.acheter(achats).subscribe((data) => {
      console.log(data);
      sessionStorage.removeItem('panier');
      this.router.navigateByUrl('/home');
    });
  }
}
