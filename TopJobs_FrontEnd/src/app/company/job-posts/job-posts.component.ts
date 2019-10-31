import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { CompanyService } from '../company.service';
import { User } from '../users';
import { HttpClient } from '@angular/common/http';
import { Company } from '../company';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-job-posts',
  templateUrl: './job-posts.component.html',
  styleUrls: ['./job-posts.component.css']
})
export class JobPostsComponent implements OnInit {
  url = environment.apiBaseUrl + "companydetails";
   details:any;
   company:any;
   companyDesc:any;
  constructor( private route:Router,private http:CompanyService,private _http: HttpClient) { }


  ngOnInit() {
    let obs=this._http.get(this.url)
    obs.subscribe(
      (Response) =>{
        this.details = Response;
       
        this.company = this.details[0].companyName;
        this.companyDesc = this.details[0].companyDescription;
       
        
      }
    )
 

  }

  toCreatePost(){
    this.route.navigate(['company/details'])
  }

  getCompanyDetails(){
   
  }


}
