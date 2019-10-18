import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-company-details',
  templateUrl: './company-details.component.html',
  styleUrls: ['./company-details.component.css']
})
export class CompanyDetailsComponent implements OnInit {

  constructor(private fb: FormBuilder,private http: HttpClient) { }

  ngOnInit() {
  }

   url = environment.apiBaseUrl + "companydetails";

  profileForm = this.fb.group({
    companyName: [''],
    companyDescription: [''],
    establishmentDate: [''],
    websiteUrl: [''],
    headquarter: [''],
    specialities: [''],
    industry: [''],
    type: [''],
  });

  onSubmit() {
    console.log(this.profileForm.value)
    this.http.post( this.url, this.profileForm.value).subscribe(
      () =>{
        console.log("posted");
        console.log(this.profileForm)
      }
    )
    
  }

}
