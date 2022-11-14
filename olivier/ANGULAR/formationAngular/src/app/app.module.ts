import { routes } from './routes';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoOlivierComponent } from './formation/component/demo-olivier/demo-olivier.component';
import { BonjourComponent } from './formation/component/bonjour/bonjour.component';
import { BonjourV2Component } from './formation/component/bonjour-v2/bonjour-v2.component';
import { ProduitComponent } from './formation/component/produit/produit.component';
import { FormsModule } from '@angular/forms';
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
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
