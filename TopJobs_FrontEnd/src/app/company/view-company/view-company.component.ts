import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-view-company',
  templateUrl: './view-company.component.html',
  styleUrls: ['./view-company.component.css']
})
export class ViewCompanyComponent implements OnInit {
  companyID: string;
  companies: any;
  companyDisplay:any

  constructor( private router: Router,private route:ActivatedRoute, private http:HttpClient) {
    this.companyID=this.route.snapshot.paramMap.get('id');
    console.log(this.companyID);
   }
   url = environment.apiBaseUrl + "getallcompany"


  ngOnInit() {
    this.getCompany()
  }

  getCompany(){
    this.http.get(this.url).subscribe(
      (Response)=>{
        console.log(Response);
        this.companies = Response
        for(let company of this.companies){
          if(this.companyID == company.companyId){
            this.companyDisplay = company;
          }
        }
      }
    )
  }

  goHome(){
    this.router.navigate(['/home'])
  }

}
