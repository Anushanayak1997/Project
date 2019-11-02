import { NgModule } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';
import{PDFExportModule} from '@progress/kendo-angular-pdf-export'; 
import { CompanyModule } from './company/company.module';
import { CompanyDetailsComponent } from './company/company-details/company-details.component';
import { AppComponent } from './app.component';
import { JobPostsComponent } from './company/job-posts/job-posts.component';
import { EditPostComponent } from './company/edit-post/edit-post.component';
import { EmployerDetailsComponent } from './company/employer-details/employer-details.component';
import { MainComponent } from './home/main/main.component';
import { LoginComponent } from './home/login/login.component';
import { RegisterComponent } from './home/register/register.component';
import { SeekerPageComponent } from './job-seeker/seeker-page/seeker-page.component';
import { SeekerProfileComponent } from './job-seeker/seeker-profile/seeker-profile.component';
import { ApplicationStatusComponent } from './job-seeker/application-status/application-status.component';
import { ManageAccountComponent } from './job-seeker/manage-account/manage-account.component';
import { JobDescriptionComponent } from './company/job-description/job-description.component';

import { JobSeekerModule } from './job-seeker/job-seeker.module';
import { ToastrModule } from 'ngx-toastr';
import { from } from 'rxjs';
const routes: Routes = [
   { path: "", component: MainComponent, pathMatch: 'full' },
  {
    path: "company/details", component: CompanyDetailsComponent,
  },
  {
    path: "company/jobpost", component: JobPostsComponent,
  },
  {
    path: "company/jobpost/:Index", component: EditPostComponent,
  },
  {
    path: "company/create-post", component: EditPostComponent,
  },
  {
    path: "company/employee-details", component: EmployerDetailsComponent,
  },
  {
    path: "company/job_discription", component: JobDescriptionComponent,
  },
  {
    path: "home", component: MainComponent,
  },
  {
    path: "login", component: LoginComponent,
  },
  {
    path: "register", component: RegisterComponent,
  },
  {
    path: "seeker/home", component: SeekerPageComponent,
  },
  {
    path: "seeker/profile", component:SeekerProfileComponent
  },
  {
    path: "seeker/status", component: ApplicationStatusComponent,
  },
  {
    path: "seeker/account", component: ManageAccountComponent,
  },



];

@NgModule({
  imports: [RouterModule.forRoot(routes),PDFExportModule,CompanyModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
