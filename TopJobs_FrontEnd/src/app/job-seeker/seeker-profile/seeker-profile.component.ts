import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { RegiseterUser } from 'src/app/home/H_user';
import { job_seeker_education, job_seeker_skills, job_seeker_project, job_seeker_experience } from '../Jobseeker';
import { SeekerService } from '../seeker.service';
import { Router, NavigationEnd } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Response } from 'selenium-webdriver/http';


@Component({
  selector: 'app-seeker-profile',
  templateUrl: './seeker-profile.component.html',
  styleUrls: ['./seeker-profile.component.css']
})
export class SeekerProfileComponent implements OnInit {
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
  url = environment.apiBaseUrl + "addjobseekerproject";
  url_update_info = environment.apiBaseUrl + "edituser";
  url_experience = environment.apiBaseUrl + "addjobseekerexperience";
  url_delete_project = environment.apiBaseUrl + "deleteseekerproject";
  url_add_edu = environment.apiBaseUrl + "addjobseekereducation";
  url_delete_experience = environment.apiBaseUrl + "deleteseekerexperience";

  userInfo = new RegiseterUser(
    "",
    "",
    "",
    "",
    "",
    "",
    "",
  )

  userEducation10 = new job_seeker_education(
    "",
    "",
    "",
    "",
    "",
    "",
  )
  userEducation12 = new job_seeker_education(
    "",
    "",
    "",
    "",
    "",
    "",
  )

  userEducationUG = new job_seeker_education(
    "",
    "",
    "",
    "",
    "",
    "",
  )

  userSkills = new job_seeker_skills(
    "",
    "",
    "",
    "",
  )

  userProjects = new job_seeker_project(
    "",
    "",
    ""
  )


  userProjectsAdd = new job_seeker_project(
    "",
    "",
    ""
  )

  userExperience = new job_seeker_experience(
    "",
    "",
    "",
    "",
    "",
    "",
    ""
  )

  AdduserExperience = new job_seeker_experience(
    "",
    "",
    "",
    "",
    "",
    "",
    ""
  )
  userType: string;
  start10: any;
  end10: any;
  marks10: any;
  start12: any;
  end12: any;
  marks12: any;
  startug: any;
  endug: any;
  marksug: any;
  userID: string;
  postExperience: any;
  updateInfo: any;
  idstored: any;
  mySubscription: any;
  post10: {};
  post12:any;
  postUG: any;
  currenturl:any;

  constructor(private Seeker: SeekerService, private router: Router, private http: HttpClient) {
    /* this.currenturl= this.router.url
      this.router.routeReuseStrategy.shouldReuseRoute = function () {
        return false;
      };
      this.mySubscription = this.router.events.subscribe((event) => {
        if (event instanceof this.currenturl) {
          // Trick the Router into believing it's last link wasn't previously loaded
          this.router.navigated = false;
        }
      });

      console.log("route")
      */
  }

  ngOnInit() {

    this.userType = sessionStorage.getItem('user_type');
    this.userID = sessionStorage.getItem('user_id');
    console.log(this.userID)
    if (this.userType == 'JobSeeker') {
      console.log("correct user");
    } else {
      this.router.navigate(['home']);
    }


    this.getSeekerInfo()
    this.getEducationInfo()
    this.getCertificationInfo()
    this.getExperienceInfo()
    this.getProjectInfo()

  }

  ngOnDestroy() {
    if (this.mySubscription) {
      this.mySubscription.unsubscribe();
    }
  }

  addProject() {

    this.postProject = {
      'userId': this.userID,
      'title': this.userProjectsAdd.title,
      'role': this.userProjectsAdd.role,
      'description': this.userProjectsAdd.description
    }

    console.log(this.postProject)

    this.http.post(this.url, this.postProject).subscribe(
      (Response) => {
        console.log("project succesfully added");
       // this.ngOnInit();
       this.getProjectInfo()
      }
    )




  }

  addEducation10() {
    this.post10 = {
      'userId': this.userID,
      'educationType' :'10th',
      'startingDate':this.userEducation10.start_date,
      'endingDate':this.userEducation10.end_date,
      'marksPercentages':this.userEducation10.marks_percentage
    }
    console.log(this.post10);
    this.http.post(this.url_add_edu,this.post10).subscribe(
      (Response)=>{
        console.log(Response)
        console.log("10th added")
      }
    )
  }

  addEducation12() {
    this.post12 = {
      'userId': this.userID,
      'educationType' :'12th',
      'startingDate':this.userEducation12.start_date,
      'endingDate':this.userEducation12.end_date,
      'marksPercentages':this.userEducation12.marks_percentage,
    
    }
    this.http.post(this.url_add_edu,this.post12).subscribe(
      (Response)=>{
        console.log(Response);
        console.log("12th added");
      }
    )
    
 
   }

   addEducationUG() {
    this.postUG = {
      'userId': this.userID,
      'educationType' :'ug',
      'startingDate':this.userEducation12.start_date,
      'endingDate':this.userEducation12.end_date,
      'marksPercentages':this.userEducation12.marks_percentage
    }
    this.http.post(this.url_add_edu,this.postUG).subscribe(
      (Response)=>{
        console.log(Response);
        console.log("UG added");
        this.ngOnInit();
      }
    )
 
   }


  addExperience() {
    this.postExperience = {
      'userId': this.userID,
      'jobTitle': this.AdduserExperience.job_title,
      'startDate': this.AdduserExperience.start_date,
      'endDate': this.AdduserExperience.end_date,
      'jobDescription': this.AdduserExperience.job_description,
      'streetAddress': this.AdduserExperience.streetaddress,
      'city': this.AdduserExperience.city,
      'state': this.AdduserExperience.state
    }

    console.log("post exp")
    console.log(this.postExperience);

    this.http.post(this.url_experience, this.postExperience).subscribe(
      (Response) => {
        console.log(Response);
        this.ngOnInit();
      }
    )
  }



  //Get Methods
  getSeekerInfo() {
    this.Seeker.getPersonalInfo().subscribe(
      (Response) => {
        console.log("info")
        this.info = Response
        this.userInfo.firstName = this.info.firstName;
        this.userInfo.lastName = this.info.lastName;
        this.userInfo.emailID = this.info.emailID;
        this.userInfo.contactNumber = this.info.contactNumber;
        console.log(this.info)
      }
    )
  }

  getEducationInfo() {
    this.Seeker.getEducationIfo().subscribe(
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

           // this.userEducation10.education_type_id=edu.educationType
            this.userEducation10.start_date = edu.startingDate;
            this.userEducation10.end_date = edu.endingDate;
            this.userEducation10.marks_percentage = edu.marksPercentages;


          } if (edu.educationType == '12th') {
            this.tweleth = edu.educationType;
            console.log("12")
            console.log(this.tweleth)
            this.start12 = edu.startingDate;
            this.end12 = edu.endingDate;
            this.marks12 = edu.marksPercentages;

            this.userEducation12.start_date = edu.startingDate;
            this.userEducation12.end_date = edu.endingDate;
            this.userEducation12.marks_percentage = edu.marksPercentages;

          } if (edu.educationType == 'ug') {
            this.Ug_type = edu.educationType;
            this.startug = edu.startingDate;
            this.endug = edu.endingDate;
            this.marksug = edu.marksPercentages;

            this.userEducationUG.start_date = edu.startingDate;
            this.userEducationUG.end_date = edu.endingDate;
            this.userEducationUG.marks_percentage = edu.marksPercentages;
          }
        }
      }
    )
  }



  getCertificationInfo() {
    console.log("seeker certifiva")
    this.Seeker.getCertificationInfo().subscribe(
      (Response) => {
        console.log("certificate")
        console.log(Response);
        this.certificate = Response
        console.log(this.certificate)
      }
    )
  }

  getExperienceInfo() {
    this.Seeker.getExperienceInfo().subscribe(
      (Response) => {
        console.log("experince")
        console.log(Response);
        this.Experinceinfo = Response;


      }
    )
  }

  getProjectInfo() {
    this.Seeker.getProjectInfo().subscribe(
      (Response) => {
        console.log("project")
        console.log(Response);
        this.Projectinfo = Response;
      }
    )
  }



  //End of Get Methods
  personalInfo() {
    this.updateInfo = {
      'userID': this.userID,
      'firstName':this.userInfo.firstName,
      'lastName':this.userInfo.lastName,
      'emailID':this.userInfo.emailID,
      'contactNumber':this.userInfo.contactNumber
      
    }
    console.log(this.updateInfo);
    this.http.put(this.url_update_info,this.updateInfo).subscribe(
      ()=>{
        console.log();
        console.log("User info Updated");
      }
    )
   
  }

  user10Info() {
    console.log("10th info called");
    console.log(this.userEducation10.start_date)

  }

  onDeleteProject(id: any) {
   
    console.log(id);
    for (let project of this.Projectinfo) {
      if (project.jobSeekerProjectId == id) {

        this.http.delete(this.url_delete_project + "/"+id).subscribe(
          (Response) =>{
            console.log(Response);

            console.log("project deleted");
            this.ngOnInit();
          }
        )
      }
    }

  }



  deleteExperience(id: any) {
    console.log(id)
    console.log("Experince Deleted");
    for (let experince of this.Experinceinfo) {
      if(experince.jobSeekerExperienceId==id){
        this.http.delete(this.url_delete_experience+"/"+id).subscribe(
          (Response)=>{
            console.log(Response);
            console.log("deleted experince");
            this.ngOnInit();
          }
        )
      }
    }
  }

}
