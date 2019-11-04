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
   Index:number;
   Position:string;
   Vaccancies:number;
   Status:string;
   Apllicants:number;
   Date:number;
   employes:any;
   public companies = [];
  userType: string;

  constructor( private route:Router,private companyservice:CompanyService,private _http: HttpClient) { }


  ngOnInit() {
    this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'Employer'){
      console.log("correct user");
    }else{
      this.route.navigate(['home']);
    }
   this.getAllcompany();
   
 

  }

  getAllcompany(){
    console.log("klk2")
    this.companyservice.getCompany()
    .subscribe(
      (Response)=>{
        this.employes = Response;
        console.log(this.employes)
      }
    )
    
  }

  toCreatePost(){
    this.route.navigate(['company/create-post'])
  }
  onEdit(employe){
    this.route.navigate(['company/jobpost/',employe.id])
  }
  

 



}
