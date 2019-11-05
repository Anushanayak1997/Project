import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegiseterUser } from '../H_user';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';
import { LoginComponent } from '../login/login.component';




@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  url1 = environment.apiBaseUrl + "setcompanyid";
  url2 = environment.apiBaseUrl + "adduser";
  url3 = environment.apiBaseUrl + "getallcompany"

  user_id:any;
  details: any;
  company: any;
  user: any;
  PostCompany: any;
  PostCompanyid: any;
  topicHasError = true;
  comp: any;
  headers = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private router: Router, private _http: HttpClient,private Toaster:ToastrService) { }

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
  topics = ["JobSeeker", "Employer"]

  gologin() {
    this.router.navigate(['login']);
  }

  validateTopic(value) {
    if (value === '1') {
      this.topicHasError = true;
    } else {
      this.topicHasError = false;
    }
  }


  onSubmit() {
    console.log("----->")
    console.log(this.regiseterModel.userType)
    console.log(this.regiseterModel);
    this.user = {
      'firstName': this.regiseterModel.firstName,
      'lastName': this.regiseterModel.lastName,
      'password': this.regiseterModel.password,
      'emailID': this.regiseterModel.emailID,
      'contactNumber': this.regiseterModel.contactNumber,
      'userType': this.regiseterModel.userType
    }
console.log(this.user);

   /* this.PostCompanyid = {
      companyID: this.regiseterModel.companyID
    }*/

    this._http.post(this.url2, this.user).subscribe(//add company
      (Response) => {
        console.log(Response);
        if (Response != null) {
          this.Toaster.success("successfull Registration")
           this.user_id = Response;

      
          console.log("added user");
          sessionStorage.setItem('user_type',this.user.userType);
        } else{
              
              setTimeout(() => 
                {
                  this.Toaster.error("unsecssfull regristation")
                 
                },
                2000);
                this.Toaster.warning("emaild id already in use");

        }


      }


    )
     

  }

  onNext() {

    if (this.regiseterModel.userType == "JobSeeker") {
      this.router.navigate(['login']);
    }
    if (this.regiseterModel.companyName == "others") {
      console.log("hi others");
      this.PostCompany = null;
      this.router.navigate(['login']);
    }
      else{
        console.log("hi");
        for (let company of this.details) {
          console.log(company);
         if(company.companyId==this.regiseterModel.companyName){
          console.log("true");
          this.comp = company;
        }
      }

      console.log("company status");
      console.log(this.comp);
    
      this.PostCompany = { 'companyId': this.comp.companyId, 'userId':this.user_id };
      sessionStorage.setItem('company_id',this.comp.companyId);
      this._http.post(this.url1, this.PostCompany).subscribe(
        (Response) => {
          console.log(Response);
          console.log("succees");
        }
      )
      this.router.navigate(['login']);
    }
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
login(){
  this.router.navigate(['login']);
}


}
