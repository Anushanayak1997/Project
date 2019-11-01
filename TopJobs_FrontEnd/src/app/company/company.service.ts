import { Injectable } from '@angular/core';
import { Company } from './company';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { catchError, retry } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JobPostInterface } from './job-posts/jobPostInterface';
import { user } from './users';
@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  constructor(private _http: HttpClient) { }

  url = environment.apiBaseUrl + "addcompanydetails";
  url1=environment.apiBaseUrl+"addjobpost";

  private url2:string="http://localhost:3000/company"



  enroll (company: Company) {
    return this._http.post<any>(this.url, company)
      .pipe(catchError(this.errorHandler))
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error)
  }


  getCompany():Observable<JobPostInterface[]>{
    return this._http.get<JobPostInterface[]>(this.url2)    
  }

  getCompanyById(id:any):Observable<JobPostInterface[]>{
    return this._http.get<JobPostInterface[]>(this.url2 +"/"+ id)
  }

  addJobPost(jobPost:JobPostInterface):Observable<JobPostInterface>{
    return this._http.post<JobPostInterface>(this.url1,jobPost);
  }

  EditCompany(company:JobPostInterface, id:number):Observable<JobPostInterface>{
    return this._http.put<JobPostInterface>(this.url2+"/"+id,company)
  }

  deleteCompany(id:number):Observable<JobPostInterface>{
    return this._http.delete<JobPostInterface>(this.url2+"/"+id);
  }

}