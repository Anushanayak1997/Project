import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { RouteConfigLoadEnd, Router } from '@angular/router';
import{UsermodelService} from "../usermodel.service";
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
@Component({
  selector: 'app-seeker-page',
  templateUrl: './seeker-page.component.html',
  styleUrls: ['./seeker-page.component.css']
})
export class SeekerPageComponent implements OnInit {

  userId = sessionStorage.getItem('user_id');
  url1 = environment.apiBaseUrl + "getuserbyid/"+sessionStorage.getItem('user_id');
  url2 = environment.apiBaseUrl + "getalljobs";
  url3 = environment.apiBaseUrl + "applyjobpost";
  url4 = environment.apiBaseUrl + "getapplicantsbyuserid/" + this.userId;
  getseekskills=environment.apiBaseUrl+"getseekerskillbyid";
  uploadimage=environment.apiBaseUrl+"uploadResume";

  User:any;
  seekerjobpost: any;
  jobDetails: any;
  userType:any;
  skillsnull:boolean;
  Status: any = [];
  seekerskills: Object;
  skills:any =[];
  status: number=0;
  Data: any=[];
  a: void;
  uploadresume:any;
 // user=new UsermodelService();
  constructor(private http:HttpClient,private router:Router) { }

  ngOnInit() {
    this.getseekerskills();
   this.userType=sessionStorage.getItem('user_type');
   this.userId=sessionStorage.getItem('user_id');
    if(this.userType == 'JobSeeker'){
     
      this.getSeekerStatus();
      this.getJobSeeker();
      this.getJobs();
    }else{
      this.router.navigate(['home']);
    }

   

  }

  getseekerskills(){
    this.http.get(this.getseekskills+"/"+this.userId).subscribe((Response)=>{
 
      this.skills = Response;
    if(this.skills.length=0){
      this.skillsnull=true;
    }
    })
  }

  getJobSeeker(){
  
    this.http.get(this.url1).subscribe(
      (Response)=>{
       
        this.User = Response;
        console.log(this.User);
      })
  }

  getJobs(){
    this.http.get(this.url2).subscribe(
      (Response)=>{
        this.jobDetails = Response;
        for(let i=0;i<this.jobDetails.length;i++) {
          console.log("hi  1st loop");
          for(let j=0;j<this.Status.length;j++) {
            console.log("hi  2st loop");
            if(this.jobDetails[i].jobPostId == this.Status[j].jobpost.jobPostId)
              this.jobDetails[i].status = 1;
              console.log(this.jobDetails[i].status);
          }
        }
       
      }
    )
  }

  getSeekerStatus() {
    this.http.get(this.url4).subscribe(
      (Response)=>{
        this.Status = Response;
       
      }
    )
  }


  onUploadChange(evt: any) {
    const file = evt.target.files[0];
    console.log("File uploaded", file);
    if (file) {
      const reader = new FileReader();
      this.status=1;
      reader.onload = this.handleReaderLoaded.bind(this);
      this.a= reader.readAsBinaryString(file);
      // this.http.post(this.url , this.Data);
    }
  }
  handleReaderLoaded(e) {
    this.Data.push(btoa(e.target.result));
    console.log("Base645", this.Data[0]);
    this.uploadresume={
      'userID':sessionStorage.getItem('user_id'),
      'firstName':this.User.firstName,
      'lastName': this.User.lastName,
      'password': this.User.password,
      'emailID': this.User.emailID,
      'contactNumber': this.User.contactNumber,
      'userType': this.User.userType,
      'image':this.User.image,
      'userimage':this.User.userimage,
      'resume':this.User.resume,
      'userresume':this.Data[0]
    }

    this.http.put(this.uploadimage,this.uploadresume).subscribe((Response)=>{
      console.log("success");
    })
    
  }
  onApply(jobpostid) {
   
    this.seekerjobpost = {
      'userId':sessionStorage.getItem('user_id'),
      'jobpostId': jobpostid,
      'status': 'Applied'
    }
   
    this.http.post(this.url3,this.seekerjobpost).subscribe(
      (response) => {
       
      });
  }
}
