import { ProduitEditComponent } from './eshop/component/produit/produit-edit/produit-edit.component';
import { ProduitListComponent } from './eshop/component/produit/produit-list/produit-list.component';
import { HomeComponent } from './eshop/component/home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produit', component: ProduitListComponent },
  { path: 'produit/edit', component: ProduitEditComponent },
  { path: 'produit/edit/:id', component: ProduitEditComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
