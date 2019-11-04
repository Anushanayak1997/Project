import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-applicant-details',
  templateUrl: './applicant-details.component.html',
  styleUrls: ['./applicant-details.component.css']
})
export class ApplicantDetailsComponent implements OnInit {

  constructor(private router:ActivatedRoute, private http:HttpClient) { }

  jobpostId: any;
  Applicants: any;
  URL1: any;

  ngOnInit() {
    this.jobpostId = parseInt(this.router.snapshot.paramMap.get('Index'));
    console.log(this.jobpostId);
    this.URL1 = environment.apiBaseUrl + "getapplicantsbyid/" + this.jobpostId;
    this.getAllApplicants();
  }

  getAllApplicants() {
    console.log(this.URL1);
    this.http.get(this.URL1).subscribe(
      (Response)=>{
        console.log("User details", Response);
        this.Applicants = Response;
      })
  }
}
