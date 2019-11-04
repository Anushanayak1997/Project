import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { CompanyService } from 'src/app/company/company.service';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { JobpostService } from 'src/app/company/jobpost.service';

@Component({
  selector: 'app-application-status',
  templateUrl: './application-status.component.html',
  styleUrls: ['./application-status.component.css']
})
export class ApplicationStatusComponent implements OnInit {

  applicationurl=environment.apiBaseUrl+"getapplicantsbyuserid/"+sessionStorage.getItem('user_id');
  constructor(private companyservice: CompanyService, private route: Router, private router: ActivatedRoute, private http: HttpClient,private jobservice:JobpostService) { }


  ngOnInit() {


    this.http.get(this.applicationurl).subscribe((Response)=>
    {
      console.log(Response);

    })

  }

}
