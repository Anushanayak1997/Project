import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { seeker_Profile, Education, Certification, Experience, Project } from './Jobseeker';


@Injectable({
  providedIn: 'root'
})
export class SeekerService {

  constructor(private http:HttpClient) { }

  url_user = environment.apiBaseUrl + "getuserbyid/"  +  sessionStorage.getItem('user_id');;
  url_edu = environment.apiBaseUrl + "getseekereducationbyid/"  + sessionStorage.getItem('user_id');
  url_skills = environment.apiBaseUrl + "getseekerskillbyid/" + sessionStorage.getItem('user_id');;
  url_experience = environment.apiBaseUrl + "getexperiencebyid/" +  sessionStorage.getItem('user_id');;
  url_projects = environment.apiBaseUrl + "getallseekerprojects/" + sessionStorage.getItem('user_id');;

getPersonalInfo():Observable<seeker_Profile>{

  return this.http.get<seeker_Profile>(this.url_user);
}

getEducationIfo():Observable<Education>{
  return this.http.get<Education>(this.url_edu);
}

getCertificationInfo():Observable<Certification>{
  return this.http.get<Certification>(this. url_skills);
}

getExperienceInfo():Observable<Experience>{
  return this.http.get<Experience>(this.url_experience);
}

getProjectInfo():Observable<Project>{
  return this.http.get<Project>(this.url_projects);
}

}
