import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

import {FormsModule } from '@angular/forms'
import { CookieService } from 'ngx-cookie-service';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router';
import { CompaniesComponent } from './companies/companies.component';
import { NgImageSliderModule } from 'ng-image-slider';
import { FindCandidatesComponent } from './find-candidates/find-candidates.component';
import { LoadingComponent } from './loading/loading.component';
import { AllCompaniesComponent } from './all-companies/all-companies.component';
import { FooterComponent } from './footer/footer.component';
import { ManageaccountComponent } from './manageaccount/manageaccount.component';

@NgModule({
  declarations: [MainComponent, LoginComponent, RegisterComponent, HeaderComponent, CompaniesComponent, FindCandidatesComponent, LoadingComponent, AllCompaniesComponent, FooterComponent, ManageaccountComponent],
  exports: [
   
    MainComponent,
    HeaderComponent,
    FooterComponent

  ],
  imports: [  
    CommonModule,
    FormsModule,
    RouterModule,
    NgImageSliderModule,
  ],
  providers: [CookieService],
  
})
export class HomeModule { }
