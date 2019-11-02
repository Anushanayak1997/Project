import { Component, OnInit } from '@angular/core';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { RegiseterUser } from 'src/app/home/H_user';
import { job_seeker_education, job_seeker_skills, job_seeker_project, job_seeker_experience } from '../Jobseeker';
import { SeekerService } from '../seeker.service';

@Component({
  selector: 'app-seeker-profile',
  templateUrl: './seeker-profile.component.html',
  styleUrls: ['./seeker-profile.component.css']
})
export class SeekerProfileComponent implements OnInit {
  skills: any;
  id:any;
  info:any;
  Eduinfo:any;
  certificate:any;
  Experinceinfo:any;
  Projectinfo:any;

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

  userExperience = new job_seeker_experience(
    "",
    "",
    "",
    "",
    "",
    "",
    ""
  )

  constructor(private Seeker: SeekerService) { }

  ngOnInit() {
   
   this.getSeekerInfo()
   this.getEducationInfo()
   this.getCertificationInfo()
   this.getExperienceInfo()
   this.getProjectInfo()
  
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
        console.log(this.Eduinfo)
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
