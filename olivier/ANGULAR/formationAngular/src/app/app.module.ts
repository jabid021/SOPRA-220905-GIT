import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemoOlivierComponent } from './formation/component/demo-olivier/demo-olivier.component';
import { BonjourComponent } from './formation/component/bonjour/bonjour.component';
import { BonjourV2Component } from './formation/component/bonjour-v2/bonjour-v2.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoOlivierComponent,
    BonjourComponent,
    BonjourV2Component
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
