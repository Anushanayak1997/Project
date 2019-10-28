import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import {FormsModule } from '@angular/forms'
import { CookieService } from 'ngx-cookie-service';
@NgModule({
  declarations: [MainComponent, LoginComponent, RegisterComponent],
  exports: [
    MainComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [ CookieService],
})
export class HomeModule { }
