import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ApplicationStatusComponent } from './application-status/application-status.component';
import { ManageAccountComponent } from './manage-account/manage-account.component';
import { SeekerPageComponent } from './seeker-page/seeker-page.component';
import { SeekerProfileComponent } from './seeker-profile/seeker-profile.component';



@NgModule({
  declarations: [SeekerProfileComponent, ApplicationStatusComponent, ManageAccountComponent, SeekerPageComponent],
  exports: [
    SeekerPageComponent
  ],
  imports: [
    CommonModule
  ]
})
export class JobSeekerModule { }
