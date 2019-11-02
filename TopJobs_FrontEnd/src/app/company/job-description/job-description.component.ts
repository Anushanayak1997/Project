import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-job-description',
  templateUrl: './job-description.component.html',
  styleUrls: ['./job-description.component.css']
})
export class JobDescriptionComponent implements OnInit {

  url = environment.apiBaseUrl + "getalljobs";
  userType: string;

  constructor(private _http: HttpClient, private route:Router) { }
  
  jobDetails:any;
  ngOnInit() {
    this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'Employer'){
      console.log("correct user");
    }else{
      this.route.navigate(['home']);
    }
    
    this.getJobDetails()
  }

  getJobDetails(){
    this._http.get(this.url).subscribe(
      (Response)=>{
        console.log(Response);
       this.jobDetails = Response;
      }
    )
  }

}
