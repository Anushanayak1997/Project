import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { FormArray } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { job_details } from '../job_post';
import { CompanyService } from '../company.service';


@Component({
  selector: 'app-edit-post',
  templateUrl: './edit-post.component.html',
  styleUrls: ['./edit-post.component.css']
})
export class EditPostComponent implements OnInit {

  index: number;
  id: number;
  job_post: any;
  job_edit:any;
  company =[];
  location: any;



  

  userModel = new job_details(
    "",
    "",
    "",
    ""
    , "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",
    "",

  )
  url = environment.apiBaseUrl + "addjobpost";

  
  constructor(private companyservice: CompanyService, private route: Router, private router: ActivatedRoute, private http: HttpClient) {


  }

date:any
  
  ngOnInit() {
    this.router.paramMap.subscribe((params: ParamMap) => {
      let Index = parseInt(params.get('Index'));
      console.log(Index)
      this.id = Index
      this.getCompanyId(this.id)
    })
  
    
  }

  getCompanyId(id: number) {
    this.companyservice.getCompanyById(id).subscribe(
      (Response) => {
        console.log(Response);
        this.company =  Response
       
      }
    )
  }

  deleteCompany(){

  }


  
 

  onSubmitSecond() {
    console.log("2nd submit")
    this.date = this.userModel.PostDate;
    console.log(this.date)
    if(this.userModel.PostDate == null ){
      this.job_edit ={
        id: this.id,
        Status:this.userModel.Status,
      //  PostDate: this.company.
      }
    }
    
   this.companyservice.EditCompany(this.job_edit,this.id).subscribe(
     (Response) =>{
       console.log(Response);
       console.log("edited")
     }
   )
  }

  onSubmit() {
    console.log("hi");
    this.location = { streetAdddress: this.userModel.StreetAddress, city: this.userModel.City, state: this.userModel.State, country: this.userModel.Country, pincode: this.userModel.Zipcode }
    this.job_post = {
      jobTitle: this.userModel.JobTitle,
      jobDescription: this.userModel.jobDescription,
      isActive: this.userModel.Status,
      experience: this.userModel.experience,
      noOfApplicants: this.userModel.Applicants,
      postDate: this.userModel.PostDate,
      noOfVacancies: this.userModel.Vacancy,
      location: this.location,
      specialities: this.userModel.Specalities

    }
    this.companyservice.addJobPost(this.job_post).subscribe(
      (Response)=>{
        console.log("success")
      }
    )
    
    


  }



}
