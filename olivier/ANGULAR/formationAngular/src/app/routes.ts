import { AdminGuardService } from './formation/service/guard/admin-guard.service';
import { AnonymousGuardService } from './formation/service/guard/anonymous-guard.service';
import { LoginComponent } from './formation/component/login/login.component';
import { ListProduitSecComponent } from './formation/component/demo-securite/list-produit-sec/list-produit-sec.component';
import { FormulaireCodeComponent } from './formation/component/formulaire/formulaire-code/formulaire-code.component';
import { FormulaireTemplateComponent } from './formation/component/formulaire/formulaire-template/formulaire-template.component';
import { DetailProduitComponent } from './formation/component/detail-produit/detail-produit.component';
import { NotFoundComponent } from './formation/component/not-found/not-found.component';
import { ListProduitComponent } from './formation/component/list-produit/list-produit.component';
import { HomeComponent } from './formation/component/home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ListProduitComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'produits/:id', component: DetailProduitComponent },
  { path: 'form/template', component: FormulaireTemplateComponent },
  { path: 'form/code', component: FormulaireCodeComponent },
  {
    path: 'sec/produit',
    component: ListProduitSecComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [AnonymousGuardService],
  },
  //a faire en dernier
  { path: '**', component: NotFoundComponent },
];
