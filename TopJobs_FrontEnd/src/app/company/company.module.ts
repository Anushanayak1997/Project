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
import { CompanyService } from './company.service';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { HomeModule } from '../home/home.module';
import { ApplicantDetailsComponent } from './applicant-details/applicant-details.component';
import { SelectedseekersComponent } from './selectedseekers/selectedseekers.component';
import { ViewCompanyComponent } from './view-company/view-company.component';

@NgModule({
  declarations: [
    CompanyDetailsComponent, 
    JobPostsComponent,
     EditPostComponent,
      EmployerDetailsComponent,
       JobDescriptionComponent,
       ApplicantDetailsComponent,
       SelectedseekersComponent,
       ViewCompanyComponent,
      ],
  exports: [
    CompanyDetailsComponent,
    
  ],

  imports: [
    
    CommonModule,
    HomeModule,
    
    
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    DlDateTimeDateModule,  // <--- Determines the data type of the model
    DlDateTimePickerModule,
    NgMultiSelectDropDownModule.forRoot()
  ],

  
  
  providers:[CompanyService],

 
})
export class CompanyModule { }
