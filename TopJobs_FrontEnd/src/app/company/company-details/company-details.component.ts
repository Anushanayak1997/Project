import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';

import { CompanyService } from '../company.service';
import { Company } from '../company';
import { Router } from '@angular/router';

import { pipe, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {
  compDetails:any;
  url = environment.apiBaseUrl + "addcompanydetails";
  userType: string;
  company: any;

  ngOnInit() {
    this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'Employer'){
      console.log("correct user");
    }else{
      this.route.navigate(['home']);
    }
  }

  title = 'app';

  userModel = new Company('a1', 'a1', 'a1', "a1", 'a1', 'a1', "a1", "a1");
  
  errorMsg = '';

  constructor(private _http: HttpClient, private route: Router) { }



  onSubmit() {
    this.compDetails = {
      'companyName':this.userModel.companyName,
      'companyDescription':this.userModel.companyDescription,
      'establishmentDate':this.userModel.establishmentDate,
      'websiteUrl':this.userModel.websiteUrl,
      'headquarter':this.userModel.headquarter,
      'specialiaties':this.userModel.specialities,
      'industry':this.userModel.industry,
      'type':this.userModel.type,
      'userId':sessionStorage.getItem('user_id')
    }
    console.log(this.compDetails);
    console.log("000000")

    this._http.post(this.url,this.compDetails).subscribe(
      (response) => {
        console.log('Success!', response);
        this.company=response;
        sessionStorage.setItem('company_id',this.company);
          console.log(this.userModel)
      }
    ) || pipe(catchError(this.errorHandler) )

  }

  errorHandler(error: HttpErrorResponse) {
    console.log(error)
    return throwError(error)
  }

  goEmployerDetails() {
    this.route.navigate(['company/jobpost']);
  }
}



