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
  url1 = environment.apiBaseUrl + "getuserbyid/1";
  url2 = environment.apiBaseUrl + "getalljobs";
  url3 = environment.apiBaseUrl + "applyjobpost";
  User:any;
  seekerjobpost: any;
  jobDetails: any;
  userType:any;

  constructor(private http:HttpClient,private router:Router) { }

  ngOnInit() {

   this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'JobSeeker'){
      console.log("correct user");
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
        console.log("Job POsts", this.jobDetails)
      }
    )
  }

  onApply(jobpostid) {
    console.log("Index ", jobpostid);
    this.seekerjobpost = {
      'userId':sessionStorage.getItem('user_id'),
      'jobpostId': jobpostid,
      'status': 'Apply'
    }
    console.log(this.seekerjobpost);
    this.http.post(this.url3,this.seekerjobpost).subscribe(
      (response) => {
        console.log('Success!', response);
      });
  }
}
