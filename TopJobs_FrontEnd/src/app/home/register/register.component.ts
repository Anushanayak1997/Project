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
  url1 = environment.apiBaseUrl + "addcompanydetails";
  url2 = environment.apiBaseUrl + "adduser";
  url3= environment.apiBaseUrl + "getallcompany";
  details: any;
  company: any;
  PostCompany: any;
  topicHasError = true;
  comp:any;
 
  constructor(private router: Router, private _http: HttpClient) { }

  regiseterModel = new RegiseterUser(
    "a1",
    "a1",
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

    if(this.regiseterModel.companyName=="others"){
      this.comp=null;
    }
      else{
        console.log("hi");
        for (let company of this.details) {
          console.log(company);
         if(company.companyId==this.regiseterModel.companyName){
          console.log("true");
          this.comp=company;
         }
          
        }

    }
    
    console.log("company status");
    console.log(this.comp);
    this._http.post(this.url2,this.PostCompany ).subscribe(
      (Response) => {
        console.log(Response);
        console.log("added user");

       

      }

      
    )



    this._http.post(this.url1, this.comp).subscribe(
      (Response) => {
        console.log(Response);
        console.log("succees");

      }
    )
    

  }

  getCompanies() {
    let obs = this._http.get(this.url3)
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
