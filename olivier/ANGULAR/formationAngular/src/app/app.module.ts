import { AuthenticationInterceptor } from './formation/interceptor/authentication.interceptor';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { routes } from './routes';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoOlivierComponent } from './formation/component/demo-olivier/demo-olivier.component';
import { BonjourComponent } from './formation/component/bonjour/bonjour.component';
import { BonjourV2Component } from './formation/component/bonjour-v2/bonjour-v2.component';
import { ProduitComponent } from './formation/component/produit/produit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProduitDisplayComponent } from './formation/component/produit-display/produit-display.component';
import { ProduitEditComponent } from './formation/component/produit-edit/produit-edit.component';
import { EquipeComponent } from './formation/component/equipe/equipe.component';
import { SondageComponent } from './formation/component/sondage/sondage.component';
import { TabComponent } from './formation/component/tableau/tab/tab.component';
import { LigneComponent } from './formation/component/tableau/ligne/ligne.component';
import { ImportantDirective } from './formation/directive/important.directive';
import { ListProduitComponent } from './formation/component/list-produit/list-produit.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './formation/component/home/home.component';
import { NotFoundComponent } from './formation/component/not-found/not-found.component';
import { DetailProduitComponent } from './formation/component/detail-produit/detail-produit.component';
import { FormulaireTemplateComponent } from './formation/component/formulaire/formulaire-template/formulaire-template.component';
import { FormulaireCodeComponent } from './formation/component/formulaire/formulaire-code/formulaire-code.component';
import { ListProduitSecComponent } from './formation/component/demo-securite/list-produit-sec/list-produit-sec.component';
import { LoginComponent } from './formation/component/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoOlivierComponent,
    BonjourComponent,
    BonjourV2Component,
    ProduitComponent,
    ProduitDisplayComponent,
    ProduitEditComponent,
    EquipeComponent,
    SondageComponent,
    TabComponent,
    LigneComponent,
    ImportantDirective,
    ListProduitComponent,
    HomeComponent,
    NotFoundComponent,
    DetailProduitComponent,
    FormulaireTemplateComponent,
    FormulaireCodeComponent,
    ListProduitSecComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
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
