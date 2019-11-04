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

  userId = sessionStorage.getItem('user_id');
  url1 = environment.apiBaseUrl + "getuserbyid/" + this.userId;
  url2 = environment.apiBaseUrl + "getalljobs";
  url3 = environment.apiBaseUrl + "applyjobpost";
  url4 = environment.apiBaseUrl + "getapplicantsbyuserid/" + this.userId;
  User:any;
  seekerjobpost: any;
  jobDetails: any;
  userType:any;
  Status: any = [];

  constructor(private http:HttpClient,private router:Router) { }

  ngOnInit() {
   this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'JobSeeker'){
      console.log("correct user", this.userId);
      this.getSeekerStatus();
      this.getJobSeeker();
      this.getJobs();
    }else{
      this.router.navigate(['home']);
    }
  }

  getJobSeeker(){
    this.http.get(this.url1).subscribe(
      (Response)=>{
        console.log("User details", Response);
        this.User = Response;
      })
  }

  getJobs(){
    this.http.get(this.url2).subscribe(
      (Response)=>{
        this.jobDetails = Response;
        for(let i=0;i<this.jobDetails.length;i++) {
          for(let j=0;j<this.Status.length;j++) {
            if(this.jobDetails[i].jobPostId == this.Status[j].jobpost.jobPostId)
              this.jobDetails[i].status = 1;
          }
        }
        console.log("Job Posts", this.jobDetails)
      }
    )
  }

  getSeekerStatus() {
    this.http.get(this.url4).subscribe(
      (Response)=>{
        this.Status = Response;
        console.log("Status", this.Status);
      }
    )
  }

  onApply(jobpostid) {
    console.log("Index ", jobpostid);
    this.seekerjobpost = {
      'userId':sessionStorage.getItem('user_id'),
      'jobpostId': jobpostid,
      'status': 'Applied'
    }
    console.log(this.seekerjobpost);
    this.http.post(this.url3,this.seekerjobpost).subscribe(
      (response) => {
        console.log('Success!', response);
      });
  }
}
