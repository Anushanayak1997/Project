import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompanyDetailsComponent } from './company-details/company-details.component';
import { ReactiveFormsModule } from '@angular/forms';
import { JobPostsComponent } from './job-posts/job-posts.component';
import { EditPostComponent } from './edit-post/edit-post.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule } from '@angular/forms'
import { DlDateTimeDateModule, DlDateTimePickerModule } from 'angular-bootstrap-datetimepicker';
import { EmployerDetailsComponent } from './employer-details/employer-details.component';
import { JobDescriptionComponent } from './job-description/job-description.component';

@NgModule({
  declarations: [CompanyDetailsComponent, JobPostsComponent, EditPostComponent, EmployerDetailsComponent, JobDescriptionComponent],
  exports: [
    CompanyDetailsComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    DlDateTimeDateModule,  // <--- Determines the data type of the model
    DlDateTimePickerModule,
  ]
})
export class CompanyModule { }
