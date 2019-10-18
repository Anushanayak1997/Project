import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompanyDetailsComponent } from './company-details/company-details.component';
import { ReactiveFormsModule } from '@angular/forms';
import { JobPostsComponent } from './job-posts/job-posts.component';
import { EditPostComponent } from './edit-post/edit-post.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule } from '@angular/forms'


@NgModule({
  declarations: [CompanyDetailsComponent, JobPostsComponent, EditPostComponent],
  exports: [
    CompanyDetailsComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ]
})
export class CompanyModule { }
