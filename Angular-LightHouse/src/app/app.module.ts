import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule, Routes, Router } from '@angular/router';

import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavbarOuterComponent } from './navbar-outer/navbar-outer.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule, routing } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { GeneralForumComponent } from './general-forum/general-forum.component';
import { GeneralForumInnerComponent } from './general-forum-inner/general-forum-inner.component';
import { ThreadComponent } from './thread/thread.component';
import { PostComponent } from './post/post.component';
import { SubForumComponent } from './sub-forum/sub-forum.component';
import { HttpRequestInterceptor } from './types/HttpRequestInterceptor';


@NgModule({
  declarations: [

    AppComponent,
    RegistrationComponent,
    NavbarOuterComponent,
    LoginComponent,
    HomeComponent,
    GeneralForumComponent,
    GeneralForumInnerComponent,
    ThreadComponent,
    PostComponent,
    SubForumComponent

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
  providers: [/*[
    { provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptor, multi: true }
  ],*/],
  bootstrap: [AppComponent]
})
export class AppModule { }
