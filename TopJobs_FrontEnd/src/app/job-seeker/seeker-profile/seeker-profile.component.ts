import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { RegiseterUser } from 'src/app/home/H_user';
import { job_seeker_education, job_seeker_skills, job_seeker_project, job_seeker_experience } from '../Jobseeker';

@Component({
  selector: 'app-seeker-profile',
  templateUrl: './seeker-profile.component.html',
  styleUrls: ['./seeker-profile.component.css']
})
export class SeekerProfileComponent implements OnInit {
skills:any;
  
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
    ""
  )

  constructor() { }

  ngOnInit() {

    this.skills=[{id:1,name:"xyz"},{id:2,name:"abc"},{id:3,name:"fjkd"}];
    console.log(this.skills);
  }

}
