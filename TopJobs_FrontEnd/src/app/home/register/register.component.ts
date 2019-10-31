import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegiseterUser } from '../H_user';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
<<<<<<< HEAD
  url1 = environment.apiBaseUrl + "addcompanydetails";
=======
  url1 = environment.apiBaseUrl + "setcompanyid";
>>>>>>> branch 'master' of https://github.com/Anushanayak1997/Project.git
  url2 = environment.apiBaseUrl + "adduser";
  url3= environment.apiBaseUrl + "getallcompany";
  details: any;
  company: any;
  user:any;
  PostCompany: any;
  PostCompanyid: any;
  topicHasError = true;
  comp:any;
<<<<<<< HEAD
 
=======
  headers={
    headers: new HttpHeaders({
        'Content-Type': 'application/json'
    })
  }
>>>>>>> branch 'master' of https://github.com/Anushanayak1997/Project.git
  constructor(private router: Router, private _http: HttpClient) { }

  regiseterModel = new RegiseterUser(
    "Namrata",
    "Nadang",
    "nammu@gmail.com ",
    "nammu9989",
    "987654321",
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
    this.user={'firstName': this.regiseterModel.firstName,
    'lastName':this.regiseterModel.lastName,
    'password':this.regiseterModel.password,
    'emailID':this.regiseterModel.emailID,
    'contactNumber':this.regiseterModel.contactNumber,
    'userType':this.regiseterModel.userType}
    

    this.PostCompanyid = {
      companyID: this.regiseterModel.companyID
    }

    this._http.post(this.url2,this.user).subscribe(
      (Response) => {
        console.log(Response);
        let user_id='user_id';
      
        localStorage.setItem('user_id',Response.toString());
        console.log(localStorage.getItem('user_id'));
        console.log("added user");

<<<<<<< HEAD
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
=======
       

      }

      
    )
 
      
  }

  onNext(){

    if(this.regiseterModel.userType=="JobSeeker"){
      this.router.navigate(['seeker/profile']);
    }
    if(this.regiseterModel.companyName=="others"){
      console.log("hi");
      this.PostCompany=null;
      this.router.navigate(['company/details']);
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
        console.log("company status");
    console.log(this.comp);
    console.log(localStorage.getItem('user_id'));
    this.PostCompany={'companyId':this.comp.companyId,'userId':localStorage.getItem('user_id')};
    this._http.post(this.url1, this.PostCompany).subscribe(
>>>>>>> branch 'master' of https://github.com/Anushanayak1997/Project.git
      (Response) => {
        console.log(Response);
        console.log("succees");

      }
    )
<<<<<<< HEAD
=======
    this.router.navigate(['company/jobpost']);
    }
>>>>>>> branch 'master' of https://github.com/Anushanayak1997/Project.git
    

    
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
