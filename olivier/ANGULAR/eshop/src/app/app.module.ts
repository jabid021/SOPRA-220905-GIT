import { AuthenticationInterceptor } from './eshop/interceptor/authentication.interceptor';
import { ProduitListComponent } from './eshop/component/produit/produit-list/produit-list.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './eshop/component/home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { routes } from './routes';
import { MenuComponent } from './eshop/component/menu/menu.component';
import { ProduitEditComponent } from './eshop/component/produit/produit-edit/produit-edit.component';
import { FournisseurListComponent } from './eshop/component/fournisseur/fournisseur-list/fournisseur-list.component';
import { FournisseurEditComponent } from './eshop/component/fournisseur/fournisseur-edit/fournisseur-edit.component';
import { InscriptionComponent } from './eshop/component/client/inscription/inscription.component';
import { LoginComponent } from './eshop/component/login/login.component';
import { AchatComponent } from './eshop/component/achat/achat.component';
import { ValidationAchatComponent } from './eshop/component/validation-achat/validation-achat.component';
import { ProblemeAdminComponent } from './eshop/component/probleme-admin/probleme-admin.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MenuComponent,
    ProduitListComponent,
    ProduitEditComponent,
    FournisseurListComponent,
    FournisseurEditComponent,
    InscriptionComponent,
    LoginComponent,
    AchatComponent,
    ValidationAchatComponent,
    ProblemeAdminComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
