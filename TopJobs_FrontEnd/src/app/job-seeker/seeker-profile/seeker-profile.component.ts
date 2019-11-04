import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { RegiseterUser } from 'src/app/home/H_user';
import { job_seeker_education, job_seeker_skills, job_seeker_project, job_seeker_experience } from '../Jobseeker';
import { SeekerService } from '../seeker.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

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
  url_experience = environment.apiBaseUrl + "addjobseekerexperience";



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
    77,
    11,
    1,
    19,
  )
  userEducation12 = new job_seeker_education(
    "",
    "",
    77,
    11,
    1,
    19,
  )

  userEducationUG = new job_seeker_education(
    "",
    "",
    77,
    11,
    1,
    19,
  )

  userSkills = new job_seeker_skills(
    "",
    "",
    1,
    2,
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

  constructor(private Seeker: SeekerService, private router: Router, private http: HttpClient) { }

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

  addProject() {
    this.postProject = {
      'userId':this.userID,
      'title': this.userProjectsAdd.title,
      'role': this.userProjectsAdd.role,
      'description': this.userProjectsAdd.description
    }

    console.log(this.postProject)

    this.http.post(this.url, this.postProject).subscribe(
      (Response) => {
        console.log("project succesfully added")
      }
    )
  }


  addExperience(){
    this.postExperience ={
      'userId':this.userID,
      'jobTitle':this.AdduserExperience.job_title,
      'startDate':this.AdduserExperience.start_date,
      'endtDate':this.AdduserExperience.end_date,
      'jobDescription':this.AdduserExperience.job_description,
      'streetAddress':this.AdduserExperience.streetaddress,
      'city':this.AdduserExperience.city,
      'state':this.AdduserExperience.state
    }

    console.log(this.postExperience);

    this.http.post(this.url_experience,this.postExperience).subscribe(
      (Response) =>{
        console.log(Response);
      }
    )
  }



  //Get Methods
  getSeekerInfo() {
    this.Seeker.getPersonalInfo().subscribe(
      (Response) => {
        console.log("info")
        this.info = Response
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
            this.start10 = edu.startingDate;
            this.end10 = edu.endingDate;
            this.marks10 = edu.marksPercentages;
          } if (edu.educationType == '12th') {
            this.tweleth = edu.educationType;
            this.start12 = edu.startingDate;
            this.end12 = edu.endingDate;
            this.marks12 = edu.marksPercentages
          } if (edu.educationType == 'ug') {
            this.Ug_type = edu.educationType;
            this.startug = edu.startingDate;
            this.endug = edu.endingDate;
            this.marksug = edu.marksPercentages
          }
        }
      }
    )
  }



  getCertificationInfo() {
    this.Seeker.getCertificationInfo().subscribe(
      (Response) => {
        console.log("certificate")
        console.log(Response);
        this.certificate = Response
      }
    )
  }

  getExperienceInfo() {
    this.Seeker.getExperienceInfo().subscribe(
      (Response) => {
        console.log("experince")
        console.log(Response);
        this.Experinceinfo = Response

      }
    )
  }

  getProjectInfo() {
    this.Seeker.getProjectInfo().subscribe(
      (Response) => {
        console.log("project")
        console.log(Response);
        this.Projectinfo = Response
      }
    )
  }



  //End of Get Methods




}
