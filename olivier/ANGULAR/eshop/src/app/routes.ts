import { ProblemeAdminComponent } from './eshop/component/probleme-admin/probleme-admin.component';
import { ClientGuardService } from './eshop/guard/client-guard.service';
import { ValidationAchatComponent } from './eshop/component/validation-achat/validation-achat.component';
import { AchatComponent } from './eshop/component/achat/achat.component';
import { AnonymousGuardService } from './eshop/guard/anonymous-guard.service';
import { AdminGuardService } from './eshop/guard/admin-guard.service';
import { LoginComponent } from './eshop/component/login/login.component';
import { InscriptionComponent } from './eshop/component/client/inscription/inscription.component';
import { FournisseurEditComponent } from './eshop/component/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { FournisseurListComponent } from './eshop/component/fournisseur/fournisseur-list/fournisseur-list.component';
import { ProduitEditComponent } from './eshop/component/produit/produit-edit/produit-edit.component';
import { ProduitListComponent } from './eshop/component/produit/produit-list/produit-list.component';
import { HomeComponent } from './eshop/component/home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'produit',
    component: ProduitListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'produit/edit',
    component: ProduitEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'produit/edit/:id',
    component: ProduitEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'fournisseur',
    component: FournisseurListComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'fournisseur/edit',
    component: FournisseurEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'fournisseur/edit/:id',
    component: FournisseurEditComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'inscription',
    component: InscriptionComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [AnonymousGuardService],
  },
  { path: 'achat', component: AchatComponent },
  {
    path: 'achat/validation',
    component: ValidationAchatComponent,
    canActivate: [ClientGuardService],
  },
  {
    path: 'probleme/admin',
    component: ProblemeAdminComponent,
    canActivate: [AdminGuardService],
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
