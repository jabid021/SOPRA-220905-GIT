import { AuthenticationService } from './../authentication.service';
import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AdminGuardService implements CanActivate {
  constructor(private authSrv: AuthenticationService, private router: Router) {}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | boolean
    | UrlTree
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree> {
    if (this.authSrv.isAuthenticated()) {
      //admin
      let compte = JSON.parse(sessionStorage.getItem('compte')!);
      if (compte.role == 'ROLE_ADMIN') {
        return true;
      } else {
        //client
        return false;
      }
    }
    return this.router.parseUrl('/login');
  }
}
