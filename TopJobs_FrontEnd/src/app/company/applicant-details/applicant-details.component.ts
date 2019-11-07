import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { saveAs } from '@progress/kendo-file-saver';
@Component({
  selector: 'app-applicant-details',
  templateUrl: './applicant-details.component.html',
  styleUrls: ['./applicant-details.component.css']
})
export class ApplicantDetailsComponent implements OnInit {
  resume: any;

  constructor(private router:ActivatedRoute, private http:HttpClient, private route: Router) { }

  jobpostId: any;
  Applicants: any;
  userType: any;
  URL1: any;
  URL2 = environment.apiBaseUrl + "updatestatus/";

  ngOnInit() {
    this.userType =sessionStorage.getItem('user_type');
    if(this.userType == 'Employer'){
      console.log("correct user");
      this.jobpostId = this.router.snapshot.paramMap.get('Index');
      console.log(this.jobpostId);
      this.URL1 = environment.apiBaseUrl + "getapplicantsbyid/" + this.jobpostId;
      this.getAllApplicants();
    }else{
      this.route.navigate(['home']);
    }
  }

  getAllApplicants() {
    console.log(this.URL1);
    this.http.get(this.URL1).subscribe(
      (Response)=>{
        console.log("User details", Response);
        this.Applicants = Response;
      })
  }

  onSelect(applicant) {
    console.log('Selected Applicant', applicant);
    applicant.status = 'Selected';
    this.http.post(this.URL2,applicant).subscribe(
      (response) => {
        console.log('Success!', response);
      });
  }

  selected(){
  
 this.route.navigate(['/company/selected/'+this.jobpostId])

  }

  onDownload(applicant) {
    let URL3 = environment.apiBaseUrl + "download/" + applicant.user.userID;
    this.http.get(URL3).subscribe((res) => {
      console.log("Response server", res['Image']);
      this.resume = res['Image'];
      const byteArray = new Uint8Array(atob(this.resume).split('').map(char => char.charCodeAt(0)));
      console.log("ByteArray", byteArray);
      var mediaType = 'application/pdf';
      var blob = new Blob([byteArray], {type: mediaType});
      var filename = applicant.user.firstName + applicant.user.firstName + '.pdf';
      saveAs(blob, filename);
    });
  }
}
