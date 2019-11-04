import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { CompanyService } from '../company.service';
import{JobpostService}from '../jobpost.service';
import { User } from '../users';
import { HttpClient } from '@angular/common/http';
import { Company } from '../company';
import { environment } from 'src/environments/environment';
import { from } from 'rxjs';


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
   Index:number;
   Position:string;
   Vaccancies:number;
   Status:string;
   Apllicants:number;
   Date:number;
   employes:any;
   public companies = [];
  jobposts:any;
  userType: string;

  constructor( private route:Router,private companyservice:CompanyService,private _http: HttpClient,private jobservice:JobpostService) { }


  ngOnInit() {
    
   this.getCompanyById();
    this.getJobsById();
    console.log("called");

   
 

    this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'Employer'){
      console.log("correct user");
    }else{
      this.route.navigate(['home']);
    }
   //this.getAllcompany();
  }

  getCompanyById(){
    console.log("klk2")
    this.companyservice.getCompbyId()
    .subscribe(
      (Response)=>{
        this.company = Response;
        console.log(this.company);
      }
    ) 
  }

  getJobsById(){

console.log("getting jobposts");
this.jobservice.getJobPostbyCompId()
    .subscribe(
      (Response)=>{
        this.jobposts = Response;
        console.log(this.jobposts);
      }
    )

  }

  toCreatePost(){
    this.route.navigate(['company/create-post'])
  }
  onEdit(id: string){
    console.log(id);
    this.route.navigate(['company/jobpost/'+id])
  }
  
  onDelete(id:any){
    
  }
  applicants(id:any){

    this.route.navigate(['company/Applicantdetails/'+id]);
  }
 



}
