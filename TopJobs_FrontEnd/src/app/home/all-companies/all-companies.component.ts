import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-all-companies',
  templateUrl: './all-companies.component.html',
  styleUrls: ['./all-companies.component.css']
})
export class AllCompaniesComponent implements OnInit {

  url = environment.apiBaseUrl + "getallcompany" 
  companies: any;
  companyID: any;
  companyDisplay: any;

  sony_name:any;
  sony_disc:any;
  sont_website:any;

  constructor(private http: HttpClient,private router:Router,private Toaster:ToastrService) { }

  ngOnInit() {
    this.getCompany();
  }

  
  getCompany(){
    this.http.get(this.url).subscribe(
      (Response)=>{
        console.log(Response);
        this.companies = Response
        for(let company of this.companies){
          
        }
      }
    )
  }

  viewCompany(id:any){
    this.router.navigate(['company/'+ id])
  }

}
