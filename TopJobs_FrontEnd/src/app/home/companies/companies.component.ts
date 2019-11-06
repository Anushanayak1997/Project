import { Component, OnInit, ViewChild } from '@angular/core';
import { NgImageSliderComponent } from 'ng-image-slider';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-companies',
  templateUrl: './companies.component.html',
  styleUrls: ['./companies.component.css']
})
export class CompaniesComponent implements OnInit {

  url = environment.apiBaseUrl + "getallcompany" 
  companies: any;
  companyID: any;
  companyDisplay: any;

  sony_name:any;
  sony_disc:any;
  sony_website:any;
 
  hp_name:any;
  hp_disc:any;
  hp_website:any;

  google_name:any;
  google_disc:any;
  google_website:any;
  constructor( private router: Router,private route:ActivatedRoute, private http:HttpClient) { }

  ngOnInit() {
    this.getCompany()
  }

  
  getCompany(){
    this.http.get(this.url).subscribe(
      (Response)=>{
        console.log(Response);
        this.companies = Response
        for(let company of this.companies){
          if(company.companyName == "sony"){

            this.sony_name = company.companyName;
            this.sony_disc = company.companyDescription;
            this.sony_website =company.websiteUrl;
            console.log(this.sony_website);

          } if(company.companyName == "Havlet P"){

            this.hp_name = company.companyName;
            this.hp_disc = company.companyDescription;
            this.hp_website =company.websiteUrl;
          } if(company.companyName == "Google"){

            this.google_name = company.companyName;
            this.google_disc = company.companyDescription;
            this.google_website =company.websiteUrl;
          }
        }
      }
    )
  }
goAllcompany(){
  this.router.navigate(['company'])
}

 
}
