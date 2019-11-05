import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlcoholComponent } from './alcohol/alcohol.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { NavbarComponent } from './navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AlertComponent } from './alert/alert.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { LoginComponent } from './login/login.component';
import { BeerComponent } from './beer/beer.component';
import { WineComponent } from './wine/wine.component';
import { CompanyComponent } from './company/company.component';
import {DatePipe} from "@angular/common";

@NgModule({
  declarations: [
    AppComponent,
    AlcoholComponent,
    NavbarComponent,
    AlertComponent,
    HomeComponent,
    AboutComponent,
    LoginComponent,
    BeerComponent,
    WineComponent,
    CompanyComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule { }
