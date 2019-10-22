import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { FormArray } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { job_details } from '../job_post';


@Component({
  selector: 'app-edit-post',
  templateUrl: './edit-post.component.html',
  styleUrls: ['./edit-post.component.css']
})
export class EditPostComponent implements OnInit {

  id: number;
  job_post: any;
 location:any;



  url = environment.apiBaseUrl + "addjobpost";

  constructor(private fb: FormBuilder, private route: Router, private router: ActivatedRoute, private http: HttpClient) {

    this.id = router.snapshot.params.id

  }

  ngOnInit() {
   


  }

 

  userModel = new job_details(
   "",
    "",
    "",
    ""
    ,"",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
   
  )

  
  onSubmitSecond(){
   
    console.log(this.userModel);
  }
  
  onSubmit() {
    console.log("hi");
    this.location={streetAdddress:this.userModel.StreetAddress,city:this.userModel.City,state:this.userModel.State,country:this.userModel.Country,pincode:this.userModel.Zipcode}
    this.job_post = {
      jobTitle: this.userModel.JobTitle,
      jobDescription: this.userModel.jobDescription,
      isActive: this.userModel.Status,
      experience: this.userModel.experience,
      noOfApplicants: this.userModel.Applicants,
      postDate: this.userModel.PostDate,
      noOfVacancies: this.userModel.Vacancy,
      location:this.location,
      specialities:this.userModel.Specalities

    }

    this.http.post(this.url, this.job_post).subscribe(
      (response) => {
        console.log('Success!', response),
        console.log(this.job_post);

      }
    )


  }

  

}
