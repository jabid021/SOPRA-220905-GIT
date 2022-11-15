import { FournisseurEditComponent } from './eshop/component/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { FournisseurListComponent } from './eshop/component/fournisseur/fournisseur-list/fournisseur-list.component';
import { ProduitEditComponent } from './eshop/component/produit/produit-edit/produit-edit.component';
import { ProduitListComponent } from './eshop/component/produit/produit-list/produit-list.component';
import { HomeComponent } from './eshop/component/home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produit', component: ProduitListComponent },
  { path: 'produit/edit', component: ProduitEditComponent },
  { path: 'produit/edit/:id', component: ProduitEditComponent },
  { path: 'fournisseur', component: FournisseurListComponent },
  { path: 'fournisseur/edit', component: FournisseurEditComponent },
  { path: 'fournisseur/edit/:id', component: FournisseurEditComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
