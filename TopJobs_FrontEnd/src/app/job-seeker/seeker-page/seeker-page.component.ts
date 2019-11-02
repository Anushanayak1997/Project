import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { RouteConfigLoadEnd, Router } from '@angular/router';

@Component({
  selector: 'app-seeker-page',
  templateUrl: './seeker-page.component.html',
  styleUrls: ['./seeker-page.component.css']
})
export class SeekerPageComponent implements OnInit {

  url1 = environment.apiBaseUrl + "getallusers";
  url2 = environment.apiBaseUrl + "getalljobs";
  userName:any;
  userLastName:any;
  userEmail:any;
  jobDetails: any;
  userType:any;

  constructor(private http:HttpClient,private router:Router) { }

  ngOnInit() {

   this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'JobSeeker'){
      console.log("correct user");
    }else{
      this.router.navigate(['home']);
    }
  //  this.getJobSeeker();
  //  this.getJobs();
  }

  getJobSeeker(){
    this.http.get(this.url1).subscribe(
      (Response)=>{
        console.log(Response);
        this.userName = Response[0].firstName;
        this.userLastName = Response[0].userLastName;
        this.userEmail = Response[0].emailID
      }
    )
  }

  getJobs(){
    this.http.get(this.url2).subscribe(
      (Response)=>{
        this.jobDetails = Response;
        console.log(this.jobDetails)
      }
    )
  }



}
