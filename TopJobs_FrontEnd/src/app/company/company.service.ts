import { Injectable } from '@angular/core';
import { Company } from './company';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  constructor(private _http: HttpClient) { }

  url = environment.apiBaseUrl + "companydetails";

  enroll (user: Company) {
    return this._http.post<any>(this.url, user)
      .pipe(catchError(this.errorHandler))
  }

  errorHandler(error: HttpErrorResponse) {
    return throwError(error)
  }
}
