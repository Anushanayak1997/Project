import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

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
  jobDetails: any;
  seekerjobpost: any;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.getJobSeeker();
    this.getJobs();
  }

  getJobSeeker(){
    this.http.get(this.url1).subscribe(
      (Response)=>{
        console.log("User details", Response);
        this.User = Response;
        // this.userName = this.User.firstName;
        // this.userLastName = this.User.LastName;
        // this.userEmail = this.User.emailID;
      }
    )
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
