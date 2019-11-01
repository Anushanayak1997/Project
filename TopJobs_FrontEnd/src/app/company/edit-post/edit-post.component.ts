import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { FormArray } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { job_details } from '../job_post';
import { CompanyService } from '../company.service';
import { IDropdownSettings} from 'ng-multiselect-dropdown';


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

dropdownList :any;
  selectedItems :any;
  dropdownSettings :IDropdownSettings ;

  

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
 
    getskills=environment.apiBaseUrl+"getallskills";
  
  constructor(private companyservice: CompanyService, private route: Router, private router: ActivatedRoute, private http: HttpClient) {


  }

date:any
  
  ngOnInit() {
    this.router.paramMap.subscribe((params: ParamMap) => {
      let Index = parseInt(params.get('Index'));
      console.log(Index)
      this.id = Index
      this.getCompanyId(this.id);
      this.http.get(this.getskills).subscribe(
        (Response)=>{
          this.selectedItems=Response;
        }
      )
    })

    
    /*this.selectedItems = [
      // { item_id: 3, item_text: 'Pune' },
      // { item_id: 4, item_text: 'Navsari' }
    ];*/
    this.dropdownSettings= {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }

  onItemSelect(item: any) {
    this.selectedItems.push(item);
    console.log(item);
    console.log(this.selectedItems);
  }

  onItemDeSelect(item: any) {
    let index = this.selectedItems.indexOf(item);
    this.selectedItems.splice(index, 1);
    console.log(item);
    console.log(this.selectedItems);
  }
  onSelectAll(items: any) {
    console.log(items);
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
    console.log(this.selectedItems);
    this.location = { }
    this.job_post = {
      'jobTitle': this.userModel.JobTitle,
      'jobDescription': this.userModel.jobDescription,
      'isActive': this.userModel.Status,
      'experience': this.userModel.experience,
      'noOfApplicants': this.userModel.Applicants,
      'postDate': this.userModel.PostDate,
      'noOfVacancies': this.userModel.Vacancy,
      'specialities': this.userModel.Specalities,
      'streetAdddress': this.userModel.StreetAddress,
       'city': this.userModel.City, 
       'state': this.userModel.State,
      'skills':this.selectedItems



    }


    console.log(this.job_post)
    this.companyservice.addJobPost(this.job_post).subscribe(
      (Response)=>{
        console.log("success")
      }
    )
    
    


  }



}
