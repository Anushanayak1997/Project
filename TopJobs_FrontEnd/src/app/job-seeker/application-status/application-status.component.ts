import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { CompanyService } from 'src/app/company/company.service';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { JobpostService } from 'src/app/company/jobpost.service';

@Component({
  selector: 'app-application-status',
  templateUrl: './application-status.component.html',
  styleUrls: ['./application-status.component.css']
})
export class ApplicationStatusComponent implements OnInit {
  userType: string;
  statusurl=environment.apiBaseUrl+"getapplicantsbyuserid/"+sessionStorage.getItem('user_id');
  appliedjob_posts: any;
  constructor(private router:Router,private http:HttpClient) { }

  ngOnInit() {
    this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'JobSeeker'){
      console.log("correct user");
    }else{
      this.router.navigate(['home']);
    }
    this.http.get(this.statusurl).subscribe((Response)=>
    {
      console.log(Response);
      this.appliedjob_posts=Response;
    })

  }

}
