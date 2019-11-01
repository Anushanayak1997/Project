import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap'

import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompanyModule } from './company/company.module';
import { HomeModule } from './home/home.module';
import { JobSeekerModule } from './job-seeker/job-seeker.module';
import { ToastrModule } from 'ngx-toastr';




@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot({
      timeOut: 2000,
      positionClass: 'toast-top-right'
    }),
    NgMultiSelectDropDownModule.forRoot(),

    CompanyModule,
    HomeModule,
    JobSeekerModule,
    NgbModule,
    NgMultiSelectDropDownModule.forRoot()

  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
