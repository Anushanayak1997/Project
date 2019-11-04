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
export class CompanyService {
  editcompany: string;
  deletecomp: string;
  constructor(private _http: HttpClient) { }

  addcompany = environment.apiBaseUrl + "addcompanydetails";
  getallcompany=environment.apiBaseUrl+"getallcompany";
  getcompany=environment.apiBaseUrl+"getcompbyid";

  //private url2:string="http://localhost:3000/company"



  enroll (company: Company) {
    return this._http.post<any>(this.addcompany, company)
      .pipe(catchError(this.errorHandler))
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error)
  }


  getAllComp(){
    return this._http.get(this.getallcompany)    
  }

  getCompbyId(){
    return this._http.get(this.getcompany+"/"+ sessionStorage.getItem('company_id'));
  }

  addCompany(company:Company){
    return this._http.post(this.addcompany,company);
  }

  

  editCompany(id:number,company:Company){
    return this._http.put<JobPostInterface>(this.editcompany+"/"+id,company);
  }

  deleteJobPost(id:number){
    return this._http.delete<JobPostInterface>(this.deletecomp+"/"+id);
  }

}