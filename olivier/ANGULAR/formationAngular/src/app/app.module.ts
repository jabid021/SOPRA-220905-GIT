import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoOlivierComponent } from './formation/component/demo-olivier/demo-olivier.component';
import { BonjourComponent } from './formation/component/bonjour/bonjour.component';
import { BonjourV2Component } from './formation/component/bonjour-v2/bonjour-v2.component';
import { ProduitComponent } from './formation/component/produit/produit.component';
import { FormsModule } from '@angular/forms';
import { ProduitDisplayComponent } from './formation/component/produit-display/produit-display.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoOlivierComponent,
    BonjourComponent,
    BonjourV2Component,
    ProduitComponent,
    ProduitDisplayComponent,
  ],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
