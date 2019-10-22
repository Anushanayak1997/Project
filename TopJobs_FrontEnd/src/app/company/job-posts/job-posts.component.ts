import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CompanyService } from '../company.service';
import { User } from '../users';

import { Company } from '../company';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-job-posts',
  templateUrl: './job-posts.component.html',
  styleUrls: ['./job-posts.component.css']
})
export class JobPostsComponent implements OnInit {
  url=environment.apiBaseUrl+"getjobpost";
  job_posts:any;
  constructor( private route:Router , private http: HttpClient) { }

  ngOnInit() {
    this.http.get(this.url).subscribe(
      (response) => {

        this.job_posts=response;
        console.log(this.job_posts)

      }
    )
  }

  toCreatePost(){
    this.route.navigate(['company/create-post'])
  }

  getCompanyDetails(){
   
  }


}
