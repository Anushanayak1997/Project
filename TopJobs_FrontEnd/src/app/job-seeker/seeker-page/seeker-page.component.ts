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
  url1 = environment.apiBaseUrl + "getuserbyid/"+sessionStorage.getItem('user_id');
  url2 = environment.apiBaseUrl + "getalljobs";
  url3 = environment.apiBaseUrl + "applyjobpost";
  url4 = environment.apiBaseUrl + "getapplicantsbyuserid/" + this.userId;
  getseekskills=environment.apiBaseUrl+"getseekerskillbyid";

  User:any;
  seekerjobpost: any;
  jobDetails: any;
  userType:any;
  Status: any = [];
  seekerskills: Object;
  skills: Object;

  constructor(private http:HttpClient,private router:Router) { }

  ngOnInit() {
    this.getseekerskills();
   this.userType=sessionStorage.getItem('user_type');
   this.userId=sessionStorage.getItem('user_id');
    if(this.userType == 'JobSeeker'){
     
      this.getSeekerStatus();
      this.getJobSeeker();
      this.getJobs();
    }else{
      this.router.navigate(['home']);
    }
  }

  getseekerskills(){
    this.http.get(this.getseekskills+"/"+this.userId).subscribe((Response)=>{
 
      this.skills = Response;
    })
  }

  getJobSeeker(){
  
    this.http.get(this.url1).subscribe(
      (Response)=>{
       
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
       
      }
    )
  }

  getSeekerStatus() {
    this.http.get(this.url4).subscribe(
      (Response)=>{
        this.Status = Response;
       
      }
    )
  }

  onApply(jobpostid) {
   
    this.seekerjobpost = {
      'userId':sessionStorage.getItem('user_id'),
      'jobpostId': jobpostid,
      'status': 'Applied'
    }
   
    this.http.post(this.url3,this.seekerjobpost).subscribe(
      (response) => {
       
      });
  }
}
