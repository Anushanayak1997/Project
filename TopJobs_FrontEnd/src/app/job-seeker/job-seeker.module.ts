import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule } from '@angular/forms';

import { ApplicationStatusComponent } from './application-status/application-status.component';
import { ManageAccountComponent } from './manage-account/manage-account.component';
import { SeekerPageComponent } from './seeker-page/seeker-page.component';
import { SeekerProfileComponent } from './seeker-profile/seeker-profile.component';
import{FormsModule}from '@angular/forms';


@NgModule({
  declarations: [SeekerProfileComponent, ApplicationStatusComponent, ManageAccountComponent, SeekerPageComponent],
  exports: [
    SeekerPageComponent
  ],
  imports: [
    CommonModule,
    NgbModule,
    FormsModule,
  ]
})
export class JobSeekerModule { }
