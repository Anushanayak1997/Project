import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule } from '@angular/forms';

import { ApplicationStatusComponent } from './application-status/application-status.component';
import { ManageAccountComponent } from './manage-account/manage-account.component';
import { SeekerPageComponent } from './seeker-page/seeker-page.component';
import { SeekerProfileComponent } from './seeker-profile/seeker-profile.component';
import { HomeModule } from '../home/home.module';
import { FileUploadComponent } from './file-upload/file-upload.component';




@NgModule({
  declarations: [SeekerProfileComponent, ApplicationStatusComponent, ManageAccountComponent, SeekerPageComponent, FileUploadComponent],
  exports: [
    SeekerPageComponent
  ],
  imports: [
    CommonModule,
    NgbModule,
    FormsModule,
      HomeModule
    
  ]
})
export class JobSeekerModule { }
