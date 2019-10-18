import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompanyModule } from './company/company.module';
import { CompanyDetailsComponent } from './company/company-details/company-details.component';
import { AppComponent } from './app.component';
import { JobPostsComponent } from './company/job-posts/job-posts.component';
import { EditPostComponent } from './company/edit-post/edit-post.component';


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
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
