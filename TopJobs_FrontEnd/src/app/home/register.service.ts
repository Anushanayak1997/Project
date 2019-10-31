import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
 
  url = environment.apiBaseUrl+"adduser";
  
  constructor(private _http: HttpClient) { }
  public register(regiseterModel):Observable<any>{
    
  const params=new HttpParams()

  .set('firstName', regiseterModel.firstName)
  .set('lastName',regiseterModel.lastName)
  .set('password',regiseterModel.password)
  .set('emailID', regiseterModel.emailID)
  .set('contactNumber',regiseterModel.contactNumber)
  .set('userType', regiseterModel.userType)

  return this._http.post(this.url,params,{headers : new HttpHeaders({ 'Content-Type': 'application/json' })});
  }
}
