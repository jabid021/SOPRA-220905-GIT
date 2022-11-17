import { Router } from '@angular/router';
import { AuthenticationService } from './../../service/authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})
export class MenuComponent implements OnInit {
  constructor(private authSrv: AuthenticationService, private router: Router) {}

  ngOnInit(): void {}

  logoff() {
    sessionStorage.clear();
    this.router.navigateByUrl('/home');
  }

  get admin() {
    return this.authSrv.isAdmin();
  }

  get client() {
    return this.authSrv.isClient();
  }

  get anonymous() {
    return !this.authSrv.isAuthenticated();
  }

  get authenticated() {
    return this.authSrv.isAuthenticated();
  }
}
