import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap'

import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompanyModule } from './company/company.module';
import { HomeModule } from './home/home.module';
import { JobSeekerModule } from './job-seeker/job-seeker.module';




@NgModule({
  declarations: [
    AppComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,

    CompanyModule,
    HomeModule,
    JobSeekerModule,
    NgbModule

  ],
  providers: [CookieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
