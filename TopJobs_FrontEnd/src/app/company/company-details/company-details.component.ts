import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

import { CompanyService } from '../company.service';
import { Company } from '../company';
import { Router } from '@angular/router';


@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {



  ngOnInit() {
  }




  title = 'app';

  userModel = new Company('', '', '.', "", '', '', "", "");


  errorMsg = '';

  constructor(private _enrollmentService: CompanyService, private route: Router) { }



  onSubmit() {

    console.log()
    this._enrollmentService.enroll(this.userModel).subscribe(
      (response) => {
        console.log('Success!', response),
          console.log(this.userModel);
      }
    )

  }

  goEmployerDetails() {
    this.route.navigate(['company/employee-details']);
  }

 

}



