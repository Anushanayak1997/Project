import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormsModule } from '@angular/forms';
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
  job_post:any;
 // userModel:any;
 
    
   
  url = environment.apiBaseUrl+"addjobpost";
  constructor(private fb: FormBuilder, private route: Router, private router: ActivatedRoute,private http: HttpClient) {

    this.id = router.snapshot.params.id

  }

  ngOnInit() {
  }
location={street:"fehue",city:"hefuru",state:"dheuidh",country:"ruefhur",zip:"ieyufd"};
 userModel=new job_details("web-devloper",10,"Active", 4,"dyfy","uwdyeu", "3 years","ueyduewis", this.location)


  onSubmit() {
    console.log("hi");
    this.job_post={jobTitle:this.userModel.JobTitle,

      
                   jobDescription:this.userModel.jobDescription,
                  isActive:this.userModel.Status,
                  experience:this.userModel.experience,
                  noOfApplicants:this.userModel.Applicants,
                  postDate:this.userModel.PostDate,
                  
                  noOfVacancies:this.userModel.Vacancy,
                  location:this.userModel.location
                 
                  }
 this.http.post( this.url, this.job_post).subscribe(
      () =>{
        console.log("posted");
       
      }
    )
    


  }

}