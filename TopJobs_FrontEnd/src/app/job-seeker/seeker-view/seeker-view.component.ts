import { Component, OnInit } from '@angular/core';
import { SeekerService } from '../seeker.service';
import { Router, ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { seeker_Profile, Education, Certification, Experience, Project } from '../Jobseeker';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-seeker-view',
  templateUrl: './seeker-view.component.html',
  styleUrls: ['./seeker-view.component.css']
})
export class SeekerViewComponent implements OnInit {
  seeker_profile: string;
  skills: any;
  id: any;
  info: any;
  Eduinfo: any;
  certificate: any;
  Experinceinfo: any = "";
  Projectinfo: any;
  tenth_type: any = "";
  tweleth: any = "";
  Ug_type: any = "";
  postProject: any;
  userInfo: any;
  start10: any;
  end10: any;
  marks10: any;
  userEducation10: any;
  start12: any;
  end12: any;
  marks12: any;
  userEducation12: any;
  startug: any;
  endug: any;
  marksug: any;
  userEducationUG: any;
  users: string;


  constructor(private Seeker: SeekerService, private router: Router,private route:ActivatedRoute, private http:HttpClient) {
    this.seeker_profile=this.route.snapshot.paramMap.get('id');
    console.log(this.seeker_profile);

   }

  ngOnInit() {
    this.users=sessionStorage.getItem('user_type');
    
    if(this.users == ('JobSeeker' || 'Employer' ) ){
      this.getSeekerInfo()
      this.getEducationInfo()
      this.getCertificationInfo()
      this.getExperienceInfo()
      this.getProjectInfo()
    }else{
      this.router.navigate(['/login'])

    }
  }


  url_user = environment.apiBaseUrl + "getuserbyid/"  + this.route.snapshot.paramMap.get('id');
  url_edu = environment.apiBaseUrl + "getseekereducationbyid/" +  this.route.snapshot.paramMap.get('id');
  url_skills = environment.apiBaseUrl + "getseekerskillbyid/"+  this.route.snapshot.paramMap.get('id');
  url_experience = environment.apiBaseUrl + "getexperiencebyid/" +  this.route.snapshot.paramMap.get('id');
  url_projects = environment.apiBaseUrl + "getallseekerprojects/"+  this.route.snapshot.paramMap.get('id');


  //Get Methods
  getSeekerInfo() {
    this.http.get(this.url_user).subscribe(
      (Response) => {
        console.log("info")
        this.info = Response
        
        console.log(this.info)
      }
    )
  }

  getEducationInfo() {
    this.http.get(this.url_edu).subscribe(
      (Response) => {
        console.log("education")
        console.log(Response)
        this.Eduinfo = Response;
     
        for (let edu of this.Eduinfo) {
          console.log(edu.educationType);
          if (edu.educationType == '10th') {
            this.tenth_type = edu.educationType;
            console.log(this.tenth_type)
            this.start10 = edu.startingDate;
            this.end10 = edu.endingDate;
            this.marks10 = edu.marksPercentages;

         


          } if (edu.educationType == '12th') {
            this.tweleth = edu.educationType;
            console.log("12")
            console.log(this.tweleth)
            this.start12 = edu.startingDate;
            this.end12 = edu.endingDate;
            this.marks12 = edu.marksPercentages;

            
          } if (edu.educationType == 'ug') {
            this.Ug_type = edu.educationType;
            this.startug = edu.startingDate;
            this.endug = edu.endingDate;
            this.marksug = edu.marksPercentages;

            
          }
        }
      }
    )
  }



  getCertificationInfo() {
    console.log("seeker certifiva")
    this.http.get(this.url_skills).subscribe(
      (Response) => {
        console.log("certificate")
        console.log(Response);
        this.certificate = Response
        console.log(this.certificate)
      }
    )
  }

  getExperienceInfo() {
    this.http.get(this.url_experience).subscribe(
      (Response) => {
        console.log("experince")
        console.log(Response);
        this.Experinceinfo = Response;


      }
    )
  }

  getProjectInfo() {
    this.http.get(this.url_projects).subscribe(
      (Response) => {
        console.log("project")
        console.log(Response);
        this.Projectinfo = Response;
      }
    )
  }

}
