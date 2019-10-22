import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompanyModule } from './company/company.module';
import { CompanyDetailsComponent } from './company/company-details/company-details.component';
import { AppComponent } from './app.component';
import { JobPostsComponent } from './company/job-posts/job-posts.component';
import { EditPostComponent } from './company/edit-post/edit-post.component';
import { EmployerDetailsComponent } from './company/employer-details/employer-details.component';
import { MainComponent } from './home/main/main.component';
import { LoginComponent } from './home/login/login.component';
import { RegisterComponent } from './home/register/register.component';


const routes: Routes = [
  { path: "", component: AppComponent },
  {
    path: "company/details", component: CompanyDetailsComponent,
  },
  {
    path: "company/jobpost", component: JobPostsComponent,
  },
  {
    path: "company/edit-post/:id", component: EditPostComponent,
  },
  {
    path: "company/create-post", component: EditPostComponent,
  },
  {
    path: "company/employee-details", component: EmployerDetailsComponent,
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
  



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
