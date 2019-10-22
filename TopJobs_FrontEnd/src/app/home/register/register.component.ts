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
  details: any;
  company: any;
  PostCompany:any;
  topicHasError = true;

  constructor(private router: Router, private _http: HttpClient) { }

  regiseterModel = new RegiseterUser(
    "",
    "",
    "",
    "",
    "",
    "",
    "",
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
    this.PostCompany ={
      firstName:this.regiseterModel.firstName,
      lastName:this.regiseterModel.lastName,
      password:this.regiseterModel.password,
      emailID:this.regiseterModel.emailID,
      contactNumber:this.regiseterModel.contactNumber,
      userType:this.regiseterModel.userType,
      companyName:this.regiseterModel.companyName
    }
    
    this._http.post(this.url2,this.PostCompany).subscribe(
      ()=>{
        console.log("succees");
        
      }
    )
    /*
    if(this.regiseterModel.companyName == 'others'){
      this.router.navigate(['company/employee-details']);
    }else{
      this.router.navigate(['company/jobpost']);
    }
    */
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
