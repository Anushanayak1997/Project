import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-applicant-details',
  templateUrl: './applicant-details.component.html',
  styleUrls: ['./applicant-details.component.css']
})
export class ApplicantDetailsComponent implements OnInit {

  constructor(private router:ActivatedRoute, private http:HttpClient, private route: Router) { }

  jobpostId: any;
  Applicants: any;
  userType: any;
  URL1: any;
  URL2 = environment.apiBaseUrl + "updatestatus/";

  ngOnInit() {
    this.userType =sessionStorage.getItem('user_type');
    if(this.userType == 'Employer'){
      console.log("correct user");
      this.jobpostId = this.router.snapshot.paramMap.get('Index');
      console.log(this.jobpostId);
      this.URL1 = environment.apiBaseUrl + "getapplicantsbyid/" + this.jobpostId;
      this.getAllApplicants();
    }else{
      this.route.navigate(['home']);
    }
  }

  getAllApplicants() {
    console.log(this.URL1);
    this.http.get(this.URL1).subscribe(
      (Response)=>{
        console.log("User details", Response);
        this.Applicants = Response;
      })
  }

  onSelect(applicant) {
    console.log('Selected Applicant', applicant);
    applicant.status = 'Selected';
    this.http.post(this.URL2,applicant).subscribe(
      (response) => {
        console.log('Success!', response);
      });
  }

  selected(){
    let id=sessionStorage.getItem('company_id');
 this.route.navigate(['/company/selected/'+id])

  }
}
