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
  //a faire en dernier
  { path: '**', component: NotFoundComponent },
];
