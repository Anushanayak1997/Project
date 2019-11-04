import { Injectable } from '@angular/core';
import { Company } from './company';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JobPostInterface } from './job-posts/jobPostInterface';

@Injectable({
  providedIn: 'root'
})
export class JobpostService {

  constructor(private _http: HttpClient) { }

  url = environment.apiBaseUrl + "getalljobs";
  addjob=environment.apiBaseUrl+"addjobpost";
  editjob=environment.apiBaseUrl+"editjobpost";
getjobpostbycompid=environment.apiBaseUrl+"getjobsbycompid";
getjobpostbyid=environment.apiBaseUrl+"getjobsbyid";
    deletejob=environment.apiBaseUrl+"deletejobpost";



  enroll (company: Company) {
    return this._http.post<any>(this.url, company)
      .pipe(catchError(this.errorHandler))
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error)
  }


  getAllJobPost():Observable<JobPostInterface[]>{
    return this._http.get<JobPostInterface[]>(this.url)    
  }

  getJobPostbyCompId():Observable<JobPostInterface[]>{
    return this._http.get<JobPostInterface[]>(this.getjobpostbycompid +"/"+ sessionStorage.getItem('company_id'));
  }

  addJobPost(jobPost:JobPostInterface):Observable<JobPostInterface>{
    return this._http.post<JobPostInterface>(this.addjob,jobPost);
  }

  getJobPostbyId(id:number):Observable<JobPostInterface>{
    return this._http.get<JobPostInterface>(this.getjobpostbyid +"/"+id);
  }

  EditJobPost(jobpost:any){
    return this._http.put<JobPostInterface>(this.editjob,jobpost);
  }

  deleteJobPost(id:number):Observable<JobPostInterface>{
    return this._http.delete<JobPostInterface>(this.deletejob+"/"+id);
  }

}
