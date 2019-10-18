import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { FormArray } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-edit-post',
  templateUrl: './edit-post.component.html',
  styleUrls: ['./edit-post.component.css']
})
export class EditPostComponent implements OnInit {

  id: number;
  job_post:any;
  url = environment.apiBaseUrl + "addjobpost";
  constructor(private fb: FormBuilder, private route: Router, private router: ActivatedRoute,private http: HttpClient) {

    this.id = router.snapshot.params.id

  }

  ngOnInit() {
  }

  JobPostForm = this.fb.group({

    JobTitle: ['web-devloper'],
    Applicants:['10'],
    Status: ['Active'],
    Vacancy: ['4'],
    PostDate: ['12/12/12'],
    jobDescription: ['sucks'],
    experience: ['11'],
    Specalities:['dfgudy'],
    address: this.fb.group({
      street: ['marthalli'],
      city: ['bengalur'],
      state: ['karnataka'],
      country: ['India'],
      zip: ['12345'],
     
    }),
   

  });




  onSubmit() {
    console.log(this.JobPostForm.value)
    this.job_post={jobTitle:this.JobPostForm.controls.JobTitle,
                   jobDescription:this.JobPostForm.controls.jobDescription,
                  isActive:this.JobPostForm.controls.Status,
                  experience:this.JobPostForm.controls.experience,
                  noOfApplicants:this.JobPostForm.controls.Applicants,
                  postDate:this.JobPostForm.controls.PostDate,
                  specalities:this.JobPostForm.controls.Specalities,
                  noOfVacancies:this.JobPostForm.controls.Vacancy,
                  location:this.JobPostForm.controls.address
                 
                  }
    this.http.post( this.url, this.job_post).subscribe(
      () =>{
        console.log("posted");
        console.log(this.JobPostForm)
      }
    )
    


  }

}
