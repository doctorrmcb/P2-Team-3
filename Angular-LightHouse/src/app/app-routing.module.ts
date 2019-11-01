import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';

const appRoutes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'registration', component: RegistrationComponent},

]


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }
export const routing = RouterModule.forRoot(appRoutes);
