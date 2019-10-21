import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

import { CompanyService } from '../company.service';
import { Company } from '../company';


@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {
 
  model;

  ngOnInit() {
  }

 


   title = 'app';
   
   userModel = new Company('','','.', "", '', '', "","");
   
  
   errorMsg = '';
 
   constructor(private _enrollmentService: CompanyService) {}
 
   
 
   onSubmit() {
   
    console.log()
     /*
       .subscribe(
         response => console.log('Success!', response),
         error => this.errorMsg = error.statusText
       )
   }
*/
  }

  goEmployerDetails(){
    
  }
}
