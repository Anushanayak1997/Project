import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegiseterUser } from '../H_user';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  url1 = environment.apiBaseUrl + "companydetails";
  url2 = environment.apiBaseUrl + "adduser";
  url3 = environment.apiBaseUrl + "sendcompany"
  details: any;
  company: any;
  PostCompany: any;
  PostCompanyid: any;
  topicHasError = true;


  constructor(private router: Router, private _http: HttpClient) { }

  regiseterModel = new RegiseterUser(
    "Ak",
    "sa",
    "a1",
    "a1",
    "a1",
    "1",
    "a1",
  )

  ngOnInit() {
    this.getCompanies();
  }
  topics = ["JobSeeker", "Employer", "Admin"]

  gologin() {
    this.router.navigate(['login']);
  }


  onSubmit() {
    console.log(this.regiseterModel);
    this.PostCompany = {
      firstName: this.regiseterModel.firstName,
      lastName: this.regiseterModel.lastName,
      password: this.regiseterModel.password,
      emailID: this.regiseterModel.emailID,
      contactNumber: this.regiseterModel.contactNumber,
      userType: this.regiseterModel.userType,
    }

    this.PostCompanyid = {
      companyID: this.regiseterModel.companyID
    }
/*
    this.service.regester(this.PostCompany).subscribe(
      (Response) => {
        this.router.navigate(['login'])
        if (Response.status === 200) {
           console.log("succes full registeration");
              setTimeout(() => {
                //navigate to login
          }, 2000)
        }
      }
    )
    */
    this._http.post(this.url2, this.PostCompany).subscribe(
      (Response) => {
        console.log(Response);
        console.log("succees");

      }
    )

    
    if (this.regiseterModel.userType == 'Employer') {
      if (this.regiseterModel.companyName == 'others') {
        this.router.navigate(['company/details']);
      } else {
        this.router.navigate(['company/jobpost']);
      }
    }else{
      console.log("nothing")
    }
  }

  getCompanies() {
    let obs = this._http.get(this.url1)
    obs.subscribe(
      (Response) => {
        console.log(Response);
        this.details = Response;
        this.company = this.details[0].companyName;
      }
    )
  }
  validateTopic(value) {
    if (value === '') {
      this.topicHasError = true;
    } else {
      this.topicHasError = false;
    }
  }

}
