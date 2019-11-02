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
  skills:any;

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
  userType: string;
  
  constructor(private companyservice: CompanyService, private route: Router, private router: ActivatedRoute, private http: HttpClient) {
  }

date:any
  
  ngOnInit() {
    this.userType=sessionStorage.getItem('user_type');
    if(this.userType == 'Employer'){
      console.log("correct user");
    }else{
      this.route.navigate(['home']);
    }
    
    this.router.paramMap.subscribe((params: ParamMap) => {
      let Index = parseInt(params.get('Index'));
      console.log(Index)
      this.id = Index
     
      this.http.get(this.getskills).subscribe(
        (Response)=>{
          if(Response!=null){
            console.log(Response);
          this.dropdownList=Response;
          console.log("Drop down list: " , this.dropdownList);
          }
        }
      )
    })
    /*this.selectedItems = [
      // { item_id: 3, item_text: 'Pune' },
      // { item_id: 4, item_text: 'Navsari' }
    ];*/
    this.dropdownSettings= {
      singleSelection: false,
      idField: 'skillId',
      textField: 'skillName',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }

  onItemSelect(item: any) {
    console.log("Item: " , item);
    console.log("Selected Items: ", this.selectedItems);
    this.selectedItems.forEach(v => {
      delete v.isDisabled;
    });
  }

  onItemDeSelect(item: any) {
    // let index = this.selectedItems.indexOf(item);
    // this.selectedItems.splice(index, 0);
    console.log(item);
    console.log("Deselect: ", this.selectedItems);
  }
  onSelectAll(items: any) {
    console.log(items);
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
    console.log(sessionStorage.getItem('company_id'));
    this.job_post = {
      
      'companyId':sessionStorage.getItem('company_id'),
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
      'skillset':this.selectedItems
    }


    console.log(this.job_post)
    this.companyservice.addJobPost(this.job_post).subscribe(
      (Response)=>{
        console.log("success")
      }
    )
    }
}
