import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-job-description',
  templateUrl: './job-description.component.html',
  styleUrls: ['./job-description.component.css']
})
export class JobDescriptionComponent implements OnInit {

  url = environment.apiBaseUrl + "getalljobs";
  constructor(private _http: HttpClient) { }
  jobDetails:any;
  ngOnInit() {
    this.getJobDetails()
  }

  getJobDetails(){
    this._http.get(this.url).subscribe(
      (Response)=>{
        console.log(Response);
       this.jobDetails = Response;
      }
    )
  }

}
