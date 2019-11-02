import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes, Router } from '@angular/router';

import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarOuterComponent } from './navbar-outer/navbar-outer.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule, routing} from './app-routing.module';
import { HomeComponent } from './home/home.component';



@NgModule({
  declarations: [
    
    AppComponent,
    RegistrationComponent,
    NavbarOuterComponent,
    LoginComponent,
    HomeComponent
    
  ],
  imports: [
    routing,
    RouterModule,
    BrowserModule,
    FormsModule,
    NgbModule,
    HttpClientModule,
    AppRoutingModule
  ],
  exports: [
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
